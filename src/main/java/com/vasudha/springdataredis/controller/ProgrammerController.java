package com.vasudha.springdataredis.controller;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.vasudha.springdataredis.model.*;
import com.vasudha.springdataredis.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    //adding programmer to list
    @PostMapping("/list")
    public void addProgrammerToList(@RequestBody Programmer programmer) {
        programmerService.addProgrammerToList(programmer);
    }

    //getting all programmer list
    @GetMapping("/list")
    public List<Programmer> getProgrammersList() {
        return  programmerService.getProgrammerListMembers();
    }

    @GetMapping("/count")
    public Long getProgrammersListCount() {
        return programmerService.getProgrammerListCount();
    }

    //adding programmer to set
    @PostMapping("/set")
    public void addProgrammerToSet(@RequestBody Programmer... programmer) {
        programmerService.addProgrammerToSet(programmer);
    }

    //getting all programmer set
    @GetMapping("/set")
    public Set<Programmer> getProgrammersset() {
        return  programmerService.getProgrammerSetMembers();
    }

    @GetMapping("/member")
    public boolean getProgrammersListCount(@RequestBody Programmer programmer) {
        return programmerService.isSetMember(programmer);
    }

    // *****************HASH Demo**********************//

    // add programmer to hash
    @RequestMapping(method = RequestMethod.POST, value = "/programmers-hash")
    public void savePHash(@RequestBody Programmer programmer) {
        programmerService.saveHash(programmer);

    }

    // update programmer in hash
    @RequestMapping(method = RequestMethod.PUT, value = "/programmers-hash")
    public void updatePHash(@RequestBody Programmer programmer) {
        programmerService.updateHash(programmer);

    }

    // get all programmers from hash
    @RequestMapping(method = RequestMethod.GET, value = "/programmers-hash")
    public Map<Integer, Programmer> FindAllPHash() {
        return programmerService.findAllHash();

    }

    // get programmer from hash
    @RequestMapping(method = RequestMethod.GET, value = "/programmers-hash/{id}")
    public Programmer FindPInHash(@PathVariable int id) {
        return programmerService.findInHash(id);

    }

    // delete programmer from hash
    @RequestMapping(method = RequestMethod.DELETE, value = "/programmers-hash/{id}")
    public void deletePhash(@PathVariable int id) {
        programmerService.deleteHash(id);

    }
}
