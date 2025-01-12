package com.springboot.restapi.exceptionhandling;

import java.time.LocalDate;

public class ExceptionDetail {

    private LocalDate time;
    private String desc;
    private String message;

    public ExceptionDetail(LocalDate time, String desc, String message) {
        this.time = time;
        this.desc = desc;
        this.message = message;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
