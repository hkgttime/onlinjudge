package org.oj.controller;

import org.oj.entity.Restful;
import org.oj.entity.RunCode;
import org.oj.service.DetectorTemplate;
import org.oj.service.ExecuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Execute {

    @Autowired
    private ExecuteService service;
    @Autowired
    private DetectorTemplate template;

    @PostMapping("exec")
    public Restful execute(RunCode code){
        ArrayList<String> illegals = template.detectorCodeByType(code.getType(),code.getData());
        Restful res = new Restful();
        if (illegals.size() < 0){
            return res;
        }
        service.run(code);
        return null;
    }
}
