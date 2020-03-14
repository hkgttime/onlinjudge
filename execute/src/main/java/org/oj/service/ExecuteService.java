package org.oj.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.oj.entity.RunCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class ExecuteService {

    private Logger logger = LoggerFactory.getLogger(ExecuteService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper mapper;

    public int run(RunCode runCode){
        String id = UUID.randomUUID().toString().replaceAll("-","");
        HashMap hash = new HashMap();
        hash.put("eid", id);
        hash.put("code", runCode);
        send(hash);

        return 1;
    }


    private void send(HashMap map) {
        String body = null;
        MessageProperties messageProperties = new MessageProperties();
        try {
            body = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            logger.error(e.toString());
        }
        Message msg = new Message(body.getBytes(), messageProperties);
        rabbitTemplate.sendAndReceive("exec_dir", "exec.run.c", msg);

    }

}
