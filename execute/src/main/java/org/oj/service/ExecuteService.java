package org.oj.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.oj.entity.RunCode;
import org.oj.mapper.ExecuteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ExecuteService implements RabbitTemplate.ConfirmCallback{

    private Logger logger = LoggerFactory.getLogger(ExecuteService.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private ExecuteMapper executeMapper;


    public int run(RunCode run){
        run.setUid(UUID.randomUUID().toString().replaceAll("-",""));
        run.setStatus(0);
        try {
            executeMapper.insertExeLine(run);
        }catch (Exception e){
            logger.error("insert err:" + e.toString());
        }
        send(run);

        return 1;
    }


    public void send(RunCode code) {
        String body = null;
        MessageProperties messageProperties = new MessageProperties();
        try {
            body = mapper.writeValueAsString(code);
        } catch (JsonProcessingException e) {
            logger.error(e.toString());
        }

        Message msg = new Message(body.getBytes(), messageProperties);
        rabbitTemplate.convertAndSend("exec_dir_c", "exec.run.c", msg);

    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("------------ack--------------");
    }
}
