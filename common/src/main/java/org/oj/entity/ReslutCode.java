package org.oj.entity;

public enum ReslutCode {
    /**
     * 命名约定：E[两位功能模块代码]_[4位该功能模块下各种错误码]
     * 之所以以E开头是因为Java变量不允许以数字开头
     */
    // 数据库异常不要展示给用户，可以替换为全局统一的话术，例如：系统正在开小差，请稍后重试！
    OK_0000("00", "ok"),

    E_1000("00",  "数据库异常"),
    E_1001("10",  "文件命名格式有误，正确格式为：文件类别-文件名"),
    E_1002("10",  "文件类别仅支持：证明类、证据类、其他类"),
    E_1003("10",  "请将上传文件大小控制为10M以内");


    /**
     *
     * @param functionCode 功能模块代码
     * @param functionDesc 功能模块描述
     * @param code 第一位：1表示前端要原封不动地将该错误码的含义展示给用户，2表示前端仅仅在浏览器控制台打印出来，方便定位问题，
     *                     但向用户展示时可以使用全局统一的话术，例如：系统正在开小差，请稍后重试！
     * @param message 错误码的含义
     */

    private String functionCode;
    private String message;

    ReslutCode(String functionCode, String message) {
        this.functionCode = functionCode;
        this.message      = message;
    }


    public String getFunctionCode() {
        return functionCode;
    }

    public String getMessage() {
        return message;
    }
}
