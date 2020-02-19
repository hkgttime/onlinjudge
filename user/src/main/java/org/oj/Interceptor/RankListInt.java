package org.oj.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.oj.entity.ReslutCode;
import org.oj.entity.Restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class RankListInt implements HandlerInterceptor {

    @Autowired
    RedisTemplate redisTemplate;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        int page = (int) request.getAttribute("page");
        if (page < 21){
            int start = page * 20;
            int end = start + 40;
            ListOperations ops = redisTemplate.opsForList();
            List list = ops.range("z2tpages", start, end);
            if (list != null){
                Restful restful = new Restful();
                ObjectMapper mapper = new ObjectMapper();
                restful.setReslutCode(ReslutCode.OK_0000);
                restful.setData(list);
                String res = mapper.writeValueAsString(restful);
                response.getWriter().write(res);
                response.getWriter().close();
                return false;
            }
        }
        return true;
    }

}
