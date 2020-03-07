package org.oj.service;

import org.oj.Api.Detector;

import java.util.ArrayList;
import java.util.HashMap;

public class DetectorTemplate {

    private HashMap<String, Detector> map;
    private static DetectorTemplate detectorTemplate;

    private DetectorTemplate(){
        this.map = new HashMap<>();
    }

    public static DetectorTemplate getDetectorTemplate(){
        if (detectorTemplate == null){
            detectorTemplate = new DetectorTemplate();
            return detectorTemplate;
        }
        return detectorTemplate;
    }

    public void addDetector(String key, Detector detector){
        map.put(key, detector);
    }

    public ArrayList<String> detectorCodeByType(String type, String code){
        return this.map.get(type).detectorCode(code);
    }
}
