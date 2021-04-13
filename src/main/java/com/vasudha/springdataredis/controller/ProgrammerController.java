package com.vasudha.springdataredis.controller;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.vasudha.springdataredis.model.*;
import com.vasudha.springdataredis.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/programmer")
public class ProgrammerController {
    @Autowired
    ProgrammerService programmerService;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/save")
    public void addTopic(@RequestBody Programmer programmer) throws JsonProcessingException {
        programmerService.setProgrammerAsString(String.valueOf(programmer.getId()), objectMapper.writeValueAsString(programmer));
    }

    @GetMapping("/{id}")
    public String readString(@PathVariable(name = "id") String id) {
        return programmerService.getProgrammerAsString(String.valueOf(id));
    }

}
