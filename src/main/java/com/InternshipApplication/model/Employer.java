package com.InternshipApplication.model;

import com.InternshipApplication.exception.BusinessException;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employer")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    private String description;
    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL)
    private List<Job> jobList = new ArrayList<>();

    public Employer(String name, String city, String description) {
        this.name = name;
        this.city = city;
        this.description = description;
    }

    public Employer(int id, String name, String city, String description) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.description = description;
    }

    //method for adding a job to a joblist of an employer
    public void addJob(Job job) throws BusinessException {
        if (job == null) {
            throw new BusinessException("Job cannot be null, please type a proper job");
        }
        jobList.add(job);
    }

    //method to add a new job to an employer with validation
    public void addNewJob(Job job) throws BusinessException {
        if (job.getJobTitle() == null) {
            throw new BusinessException("Title of job cannot be empty, please type a job title");
        }
        if (job.getSalary() == null) {
            throw new BusinessException("salary cannot be empty, please provide a salary for the job");
        }
        if (job.getExperience() == null) {
            throw new BusinessException("Experience cannot be empty, please provide the required experience for the job");
        }
        if (job.getLocation() == null) {
            throw new BusinessException("Location cannot be empty, please provide a location for the job");
        }
        if (job.getJobType() == null) {
            throw new BusinessException("Job type cannot be empty, please provide type of the job");
        }
        jobList.add(job);

    }

    //method for displaying all the jobs
    public void displayAllJobs() {
        System.out.println("All jobs for " + name + " are:");
        for (Job job : jobList) {
            System.out.println(job.getId() + ". " + job.getJobTitle());
        }

    }

    //method to get all applicants from a job
    public List<Applicant> getAllApplicants() {
        List<Applicant> applicantList = new ArrayList<>();
        for (Job job : jobList) {
            applicantList.addAll(job.getApplicantList());
        }
        return applicantList;
    }

    //method for deleting a job from the employer job list
    public void deleteJob(Job job) {
        jobList.remove(job);
    }
}
