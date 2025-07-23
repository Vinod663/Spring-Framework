package org.example.back_end.controller;

import lombok.RequiredArgsConstructor;
import org.example.back_end.dto.JobDto;
import org.example.back_end.service.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//controller package is the entry point of the application and presentation layer
@RequestMapping("api/v1/job")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")//allow all origins to access this API
public class JobController {
    //Constructor injection through @RequiredArgsConstructor
    /*@Autowired*///no need bcs @RequiredArgsConstructor will inject the dependency as a constructor injection
    private final JobServiceImpl jobService;


    @PostMapping("create")
    public void createJob(@RequestBody JobDto jobDto) {
        jobService.saveJob(jobDto);
        /*System.out.println(jobDto);*/
    }

    @PutMapping("update")
    public void updateJob(@RequestBody JobDto jobDto) {
        jobService.updateJob(jobDto);

    }

    @GetMapping("getAll")
    public List<JobDto> getAllJobs() {
        return jobService.getAllJobs();
    }

    @PatchMapping("status/{id}")
    public void changeStatus(@PathVariable String id) {
        jobService.changeJobStatus(id);//Custom Method
    }

    @GetMapping("search/{keyword}")
    public List<JobDto> searchJob(@PathVariable String keyword) {
        return jobService.getAllJobsByKeyword(keyword);
    }

    @GetMapping("get/{id}")
    public JobDto getJobById(@PathVariable Integer id) {
        return jobService.getById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteJob(@PathVariable Integer id) {
        jobService.deleteJob(id);
    }

}
