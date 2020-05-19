package org.oj.entity;

public class ProblemList {
    private String pid;
    private String title;
    private int Passing;
    private int commit;

    public ProblemList() {
    }

    public ProblemList(String pid, String title, int passing, int commit) {
        this.pid = pid;
        this.title = title;
        Passing = passing;
        this.commit = commit;
    }

    public String getPid() {
        return pid;
    }

    public String getTitle() {
        return title;
    }

    public int getPassing() {
        return Passing;
    }

    public int getCommit() {
        return commit;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPassing(int passing) {
        Passing = passing;
    }

    public void setCommit(int commit) {
        this.commit = commit;
    }
}
