package com.vasudha.springdataredis.repo;

public interface ProgrammerRepository {
    public  void setProgrammerAsString(String key,String programmer);
    public String getProgrammerAsString(String key);
}
