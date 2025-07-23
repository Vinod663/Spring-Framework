package org.example.back_end.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.back_end.dto.JobDto;
import org.example.back_end.entity.Job;
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
        jobRepository.save(modelMapper.map(jobDto, Job.class));//mee save method eka enne CrudRepository interface ekn
    }

    @Override
    public void updateJob(JobDto jobDto) {
        jobRepository.save(modelMapper.map(jobDto, Job.class));
    }

    @Override
    public List<JobDto> getAllJobs() {
        List<Job> allJobs = jobRepository.findAll();
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
            throw new RuntimeException("Job not found with id: " + id);
        }
    }
}
