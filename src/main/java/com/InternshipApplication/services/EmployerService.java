package com.InternshipApplication.services;

import com.InternshipApplication.exception.BusinessException;
import com.InternshipApplication.model.Applicant;
import com.InternshipApplication.model.Employer;
import com.InternshipApplication.model.Job;

import java.util.List;

public class EmployerService {
    private List<Employer> employerList;
    private Employer employer;

    public List<Employer> addEmployer(Employer employer) {
        employerList.add(employer);
        return employerList;
    }

    public void addNewJob(int id, String jobTitle, String salary, String experience, String location, String jobType, List<Applicant> applicantList) throws BusinessException {
        if (jobTitle == null) {
            throw new BusinessException("Title of job cannot be empty, please type a job title");
        }
        if (salary == null) {
            throw new BusinessException("salary cannot be empty, please provide a salary for the job");
        }
        if (experience == null) {
            throw new BusinessException("Experience cannot be empty, please provide the required experience for the job");
        }
        if (location == null) {
            throw new BusinessException("Location cannot be empty, please provide a location for the job");
        }
        if (jobType == null) {
            throw new BusinessException("Job type cannot be empty, please provide type of the job");
        }

        Job newJob = new Job(id, jobTitle, salary, experience, location, jobType);
        employer.getJobList().add(newJob);
    }
}
