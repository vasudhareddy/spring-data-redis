package com.vasudha.springdataredis.service;

import com.vasudha.springdataredis.model.*;

import java.util.*;

public interface ProgrammerService {
    public void setProgrammerAsString(String key, String programmer);

    public String getProgrammerAsString(String key);

    public void addProgrammerToList(Programmer programmer);

    public List<Programmer> getProgrammerListMembers();

    Long getProgrammerListCount();

    public void addProgrammerToSet(Programmer... programmer);

    public Set<Programmer> getProgrammerSetMembers();

    public boolean isSetMember(Programmer programmer);

    void saveHash(Programmer programmer);

    void updateHash(Programmer programmer);

    Map<Integer, Programmer> findAllHash();

    Programmer findInHash(int id);

    void deleteHash(int id);
}
