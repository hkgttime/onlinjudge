import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.oj.OnlineJudge;
import org.oj.entity.RunCode;
import org.oj.service.ExecuteService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineJudge.class)
public class test {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private ExecuteService service;

    @Test
    public void test() {
        RunCode map = new RunCode();
        map.setUid("dsdasdsad");
        map.setPid("jidsaidhias");
        map.setData("20120203");
        map.setLanguage("c");
        for (int i=0; i<5; i++){
            service.send(map);
        }
    }
}
