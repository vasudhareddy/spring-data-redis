package com.vasudha.springdataredis.service;

import com.vasudha.springdataredis.repo.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

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
}
