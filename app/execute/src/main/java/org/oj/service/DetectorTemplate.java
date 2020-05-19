package org.oj.service;

import org.oj.api.Detector;
import org.oj.entity.LanguageType;

import java.util.ArrayList;
import java.util.HashMap;

public class DetectorTemplate {

    private HashMap<String, Detector> map;
    private static DetectorTemplate detectorTemplate;
    private static Object object = new Object();

    private DetectorTemplate() {
        this.map = new HashMap<>();
    }

    public static DetectorTemplate getDetectorTemplate() {
        synchronized (object) {
            if (detectorTemplate == null) {
                detectorTemplate = new DetectorTemplate();
                return detectorTemplate;
            }
        }
        return detectorTemplate;
    }

    public void addDetector(String key, Detector detector) {
        map.put(key, detector);
    }

    public ArrayList<String> detectorCodeByType(LanguageType type, String code) {
        return this.map.get(type).detectorCode(code);
    }
}
