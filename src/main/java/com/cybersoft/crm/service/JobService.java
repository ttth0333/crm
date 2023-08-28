package com.cybersoft.crm.service;

import com.cybersoft.crm.model.JobModel;
import com.cybersoft.crm.repository.JobRepository;

import java.util.List;

public class JobService {
    private JobRepository jobRepository = new JobRepository();

    public List<JobModel> getAllJobs() {
        return jobRepository.getJobs();
    }

    public boolean deleteJobById(int id) {
        int result = jobRepository.deleteJobById(id);
        return result > 0 ? true : false;
    }
}
