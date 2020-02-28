package org.oj.controller;

import org.oj.entity.ExecuteRes;
import org.oj.entity.ExecutedBody;
import org.oj.entity.RunCode;
import org.oj.service.ExecuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Execute {

    @Autowired
    private ExecuteService service;

    @PostMapping("exec")
    public ExecuteRes execute(RunCode code){
        ExecutedBody body = new ExecutedBody("122",code);
        service.run(body);
        return null;
    }
}
