package com.vasudha.springdataredis.service;

public interface ProgrammerService {
    public  void setProgrammerAsString(String key,String programmer);
    public String getProgrammerAsString(String key);
}
