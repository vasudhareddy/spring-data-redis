package com.vasudha.springdataredis.service;

import com.vasudha.springdataredis.model.*;
import com.vasudha.springdataredis.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {
    @Autowired
    ProgrammerRepository programmerRepository;

    @Override
    public void setProgrammerAsString(String key, String programmer) {
        programmerRepository.setProgrammerAsString(key, programmer);
    }

    @Override
    public String getProgrammerAsString(String key) {
        return programmerRepository.getProgrammerAsString(key);
    }

    @Override
    public void addProgrammerToList(Programmer programmer) {
        programmerRepository.addProgrammerToList(programmer);
    }

    @Override
    public List<Programmer> getProgrammerListMembers() {
        return programmerRepository.getProgrammerListMembers();
    }

    @Override
    public Long getProgrammerListCount() {
        return programmerRepository.getProgrammerListCount();
    }

    @Override
    public void addProgrammerToSet(Programmer... programmer) {
        programmerRepository.addProgrammerToSet(programmer);
    }

    @Override
    public Set<Programmer> getProgrammerSetMembers() {
        return programmerRepository.getProgrammerSetMembers();
    }

    @Override
    public boolean isSetMember(Programmer programmer) {
        return programmerRepository.isSetMember(programmer);
    }

    @Override
    public void saveHash(Programmer programmer) {
        programmerRepository.saveHash(programmer);
    }

    @Override
    public void updateHash(Programmer programmer) {
        programmerRepository.updateHash(programmer);
    }

    @Override
    public Map<Integer, Programmer> findAllHash() {
        return programmerRepository.findAllHash();
    }

    @Override
    public Programmer findInHash(int id) {
        return programmerRepository.findInHash(id);
    }

    @Override
    public void deleteHash(int id) {
        programmerRepository.deleteHash(id);
    }
}
