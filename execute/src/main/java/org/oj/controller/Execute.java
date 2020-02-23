package org.oj.controller;

import org.oj.entity.ExecuteRes;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Execute {

    @PostMapping("exec")
    public ExecuteRes execute(){

        return null;
    }
}
