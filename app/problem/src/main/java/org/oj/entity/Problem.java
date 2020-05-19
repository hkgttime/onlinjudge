package org.oj.entity;

public class Problem {

    private String pid;
    private String title;
    private String description;
    private String inputFormat;
    private String outputFormat;
    private IOExample example;
    private String hint;
    private int status;
    private String score;
    private String provider;


    public Problem() {
    }

    ;

    public Problem(String pid, String title, String description, String inputFormat, String outputFormat, IOExample example, String hint, int status, String score, String provider) {
        this.pid = pid;
        this.title = title;
        this.description = description;
        this.inputFormat = inputFormat;
        this.outputFormat = outputFormat;
        this.example = example;
        this.hint = hint;
        this.status = status;
        this.score = score;
        this.provider = provider;
    }

    public String getPid() {
        return pid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInputFormat() {
        return inputFormat;
    }

    public String getOutputFormat() {
        return outputFormat;
    }

    public String getHint() {
        return hint;
    }

    public int getStatus() {
        return status;
    }

    public String getScore() {
        return score;
    }

    public String getProvider() {
        return provider;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInputFormat(String inputFormat) {
        this.inputFormat = inputFormat;
    }

    public void setOutputFormat(String outputFormat) {
        this.outputFormat = outputFormat;
    }

    public IOExample getExample() {
        return example;
    }

    public void setExample(IOExample example) {
        this.example = example;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
