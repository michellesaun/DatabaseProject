package com.example.application.resource;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.example.application.persistence.StudentCouncil;
import com.example.application.service.StudentCouncilService;

import ch.qos.logback.core.joran.spi.HttpUtil.RequestMethod;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class StudentCouncilResource {

    @Autowired
    private StudentCouncilService service;

    public StudentCouncilResource(StudentCouncilService service){
        this.service = service;
    }

    @GetMapping("/studentcouncils")
    public List<StudentCouncil> getAll(){
        return this.service.getAll();
    }
    @GetMapping("/studentcouncils/{studentcouncilID}")
    public StudentCouncil getByID(@PathVariable Integer studentcouncilID){
        return this.service.getByID(studentcouncilID);
    }
    @PostMapping(value = "/studentcouncils/add")
    public StudentCouncil postStudentCouncil(@RequestBody StudentCouncil studentcouncil){
        return this.service.saveStudentCouncil(studentcouncil);
        
    }
    //consumes = "application/json"
    @PutMapping(value = "/studentcouncils/update/{studentcouncilID}")
    public StudentCouncil update(@PathVariable Integer studentcouncilID, @RequestBody StudentCouncil studentcouncil){
        return this.service.update(studentcouncilID, studentcouncil);
    }
    @DeleteMapping("/studentcouncils/delete/{studentcouncilID}")
    public void delete(@PathVariable Integer studentcouncilID){
        this.service.delete(studentcouncilID);
    }
}
