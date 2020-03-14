import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oj.OnlineJudge;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineJudge.class)
public class test {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void test(){
        String body = null;
        MessageProperties messageProperties = new MessageProperties();
        HashMap map = new HashMap();
        map.put("id", "kokojojhiuhou");
        map.put("body", "kokhdahdihaiodhisa");
        try {
            body = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Message msg = new Message(body.getBytes(), messageProperties);
        rabbitTemplate.sendAndReceive("exec_dir", "exec.run.c", msg);
    }

}
