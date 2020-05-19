package org.oj.conf;

import org.oj.entity.LanguageType;
import org.oj.service.DetectorForCProgram;
import org.oj.service.DetectorTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DetectorTemplateConf {

    @Bean
    public DetectorTemplate detectorTemplate() {
        DetectorTemplate detectorTemplate = DetectorTemplate.getDetectorTemplate();
        detectorTemplate.addDetector(LanguageType.C, new DetectorForCProgram());
        return detectorTemplate;
    }

}
