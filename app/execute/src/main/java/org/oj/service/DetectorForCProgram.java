package org.oj.service;

import org.oj.api.Detector;

import java.util.ArrayList;

public class DetectorForCProgram implements Detector {

    private ArrayList<String> array = new ArrayList<>();

    public DetectorForCProgram() {
        this.array.add("<unistd.h>");
    }

    @Override
    public ArrayList<String> detectorCode(String code) {
        ArrayList<String> ret = new ArrayList<>();
        for (int i = 0; i < this.array.size(); i++) {
            if (code.indexOf(this.array.get(i)) < 0) {
                break;
            }
            ret.add(this.array.get(i));
        }
        return ret;
    }
}
