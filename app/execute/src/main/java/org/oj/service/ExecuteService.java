package org.oj.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.oj.entity.Code;
import org.oj.entity.ExecCode;
import org.oj.entity.RunCode;
import org.oj.mapper.ExecuteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class ExecuteService {

    private Logger logger = LoggerFactory.getLogger(ExecuteService.class);
    @Value("${send.ip}")
    private String ip;
    @Value("${send.port}")
    private String port;

    @Autowired
    private ExecuteMapper executeMapper;

    public int run(Code code) {
        RunCode runCode = new RunCode();
        runCode.setEid(UUID.randomUUID().toString().replaceAll("-", ""));
        runCode.setStatus(ExecCode.OJ_WT0);
        runCode.setData(code.getData());
        logger.trace(code.toString());
   /*     try {
            executeMapper.insertExeLine(code);
        }catch (Exception e){
            logger.error("insert err:" + e.toString());
        }*/
        send(runCode);
        return 1;
    }


    private void send(RunCode code) {
        StringBuffer uri = new StringBuffer();
        uri.append(ip).append(":").append(port);
        logger.debug(uri.toString());
        try {
            CloseableHttpClient client = null;
            CloseableHttpResponse response = null;
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> data = new HashMap<>();
                data.put("data", code);

                HttpPost httpPost = new HttpPost(uri.toString());

                httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
                httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(data),
                        ContentType.create("text/json", "UTF-8")));

                client = HttpClients.createDefault();
                response = client.execute(httpPost);
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                logger.debug(result);
            } finally {
                if (response != null) {
                    response.close();
                }
                if (client != null) {
                    client.close();
                }
            }
        } catch (Exception e) {
            logger.error(e.toString());
            e.printStackTrace();
        }
    }
}
