package org.example.back_end.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.back_end.dto.JobDto;
import org.example.back_end.entity.Job;
import org.example.back_end.exception.ResourceFoundException;
import org.example.back_end.exception.ResourceNotFoundException;
import org.example.back_end.repository.JobRepository;
import org.example.back_end.service.JobService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//define this class as a service component
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;//constructor injection through @RequiredArgsConstructor
    private final ModelMapper modelMapper;//constructor injection through @RequiredArgsConstructor

    /*@Transactional*/// This annotation is used to manage transactions, ensuring that the method is executed within a transaction context.
    @Override
    public void saveJob(JobDto jobDto) {
        if (jobDto.getId() != null && jobRepository.existsById(jobDto.getId())) {
            throw new ResourceFoundException("Job already exists with id: " + jobDto.getId());//Custom Exception
        }
        jobRepository.save(modelMapper.map(jobDto, Job.class));//mee save method eka enne CrudRepository interface ekn
    }

    @Override
    public void updateJob(JobDto jobDto) {
        List<Job> jobs = jobRepository.findAllById(List.of(jobDto.getId()));//findAllById method returns a list of jobs with the given id
        if(jobs.isEmpty()) {
            throw new ResourceNotFoundException("No jobs found to update");//Custom Exception
        }//if eke awlak tiyenne
        jobRepository.save(modelMapper.map(jobDto, Job.class));
    }

    @Override
    public List<JobDto> getAllJobs() {
        List<Job> allJobs = jobRepository.findAll();
        /*throw new RuntimeException("Exception Thrown");*/
        if (allJobs.isEmpty()) {
            throw new ResourceNotFoundException("No jobs found");//Custom Exception
        }
        /*throw new ResourceNotFoundException("No jobs found");*///to check GlobalExceptionHandler
        return modelMapper.map(allJobs, new TypeToken<List<JobDto>>() {}.getType());
    }

    @Override
    public void changeJobStatus(String id) {
        jobRepository.updateJobStatus(id);//Custom Method
    }

    @Override
    public List<JobDto> getAllJobsByKeyword(String keyword) {
        List<Job> list=jobRepository.findJobByJobTitleContainingIgnoreCase(keyword);
        return modelMapper.map(list, new TypeToken<List<JobDto>>() {}.getType());
    }

    @Override
    public JobDto getById(Integer id) {
        Job job = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
        return modelMapper.map(job, JobDto.class);
    }

    @Override
    public void deleteJob(Integer id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("No jobs found to delete with id: " + id);//Custom Exception
        }
    }
}
