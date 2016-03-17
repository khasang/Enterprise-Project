package io.khasang.enterprise.model;

public class AccessToNewBase {
    private String status;

    public AccessToNewBase() {
    }

    public AccessToNewBase(String hello){
        status = hello;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
