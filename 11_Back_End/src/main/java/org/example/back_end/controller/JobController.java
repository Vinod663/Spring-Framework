package org.example.back_end.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.back_end.dto.JobDto;
import org.example.back_end.service.impl.JobServiceImpl;
import org.example.back_end.utill.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

//controller package is the entry point of the application and presentation layer
@RequestMapping("api/v1/job")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")//allow all origins to access this API
@Slf4j //Slf4j is a logging framework that provides a simple and efficient way to log messages in the application
public class JobController {
    /*Logger logger = Logger.getLogger(JobController.class.getName());*///(OLD Method for LOGS)Logger is used to log messages in the application, here it is used for debugging purposes
    //Constructor injection through @RequiredArgsConstructor
    /*@Autowired*///no need bcs @RequiredArgsConstructor will inject the dependency as a constructor injection
    private final JobServiceImpl jobService;


    /*@PostMapping("create")
    public void createJob(@RequestBody JobDto jobDto) {
        jobService.saveJob(jobDto);
        *//*System.out.println(jobDto);*//*
    }*/


    @PostMapping("create")
    public ResponseEntity<APIResponse> createJob(@Valid @RequestBody JobDto jobDto) {//@Valid annotation is used to validate the request body
        /*log.info("INFO - Job Created");
        log.debug("DEBUG - Job Created");
        log.error("ERROR - Job Created");
        log.warn("WARN - Job Created");
        log.trace("TRACE - Job Created");*/

        jobService.saveJob(jobDto);
        return new ResponseEntity(//ResponseEntity.ok wenuwata HttpStatus.CREATED use karala hadana widiha
                new APIResponse(
                        200,
                        "Job Created Successfully",
                        jobDto
                ),
                HttpStatus.CREATED
        );
    }

    /*@PutMapping("update")
    public void updateJob(@RequestBody JobDto jobDto) {
        jobService.updateJob(jobDto);

    }*/

    @PutMapping("update")
    public ResponseEntity<APIResponse> updateJob(@RequestBody JobDto jobDto) {
        jobService.updateJob(jobDto);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "Job Updated Successfully",
                        jobDto)
        );

    }

    /*@GetMapping("getAll")
    public List<JobDto> getAllJobs() {
        return jobService.getAllJobs();
    }*/

    @GetMapping("getAll")
    public ResponseEntity<APIResponse> getAllJobs() {
        List<JobDto> jobDtos = jobService.getAllJobs();
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "All Jobs Retrieved Successfully",
                        jobDtos)
        );
    }

    /*@PatchMapping("status/{id}")
    public void changeStatus(@PathVariable String id) {
        jobService.changeJobStatus(id);//Custom Method
    }*/


    @PatchMapping("status/{id}")
    public ResponseEntity<APIResponse> changeStatus(@PathVariable String id) {
        jobService.changeJobStatus(id);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "Job Status Changed Successfully",
                        null)
        );
    }

    /*@GetMapping("search/{keyword}")
    public List<JobDto> searchJob(@PathVariable String keyword) {
        return jobService.getAllJobsByKeyword(keyword);
    }*/

    @GetMapping("search/{keyword}")
    public ResponseEntity<APIResponse> searchJob(@PathVariable String keyword) {
        List<JobDto> jobDtos = jobService.getAllJobsByKeyword(keyword);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "Jobs Retrieved Successfully",
                        jobDtos)
        );
    }


    /*@GetMapping("get/{id}")
    public JobDto getJobById(@PathVariable Integer id) {
        return jobService.getById(id);
    }*/


    @GetMapping("get/{id}")
    public ResponseEntity<APIResponse> getJobById(@PathVariable Integer id) {
        JobDto jobDto = jobService.getById(id);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "Job Retrieved Successfully According to ID",
                        jobDto)
        );
    }

    /*@DeleteMapping("delete/{id}")
    public void deleteJob(@PathVariable Integer id) {
        jobService.deleteJob(id);
    }*/

    @DeleteMapping("delete/{id}")
    public ResponseEntity<APIResponse> deleteJob(@PathVariable Integer id) {
        jobService.deleteJob(id);
        return ResponseEntity.ok(
                new APIResponse(
                        200,
                        "Job Deleted Successfully",
                        null)
        );
    }
}
