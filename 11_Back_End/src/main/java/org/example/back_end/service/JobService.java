package org.example.back_end.service;

import org.example.back_end.dto.JobDto;

import java.util.List;

public interface JobService {
    public void saveJob(JobDto jobDTO);
    public void updateJob(JobDto jobDTO);
    public List<JobDto> getAllJobs();

    void changeJobStatus(String id);

    List<JobDto> getAllJobsByKeyword(String keyword);

    JobDto getById(Integer id);

    void deleteJob(Integer id);
}
