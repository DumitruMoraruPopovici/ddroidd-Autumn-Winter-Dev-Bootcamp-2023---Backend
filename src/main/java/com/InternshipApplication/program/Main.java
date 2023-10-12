package com.InternshipApplication.program;

import com.InternshipApplication.exception.BusinessException;
import com.InternshipApplication.model.Applicant;
import com.InternshipApplication.model.Employer;
import com.InternshipApplication.model.Job;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws BusinessException {
        Employer employer1 = new Employer(1, "Popa SRL", "Iasi", "IT");
        Employer employer2 = new Employer(2, "Anca SRL", "Cluj", "Sales");

        Job job1 = new Job(1, "Java Developer", "1000$", "beginner", "Iasi", "Full time");
        Job job2 = new Job(2, "QA", "500$", "senior", "Cluj", "Part time");
        Job job3 = new Job(3, "Sales Agent", "2000$", "3 years", "Suceava", "Full time");
        Job job4 = new Job(4, "Junior tester", "400$", "beginner", "Iasi", "Full time");
        Job job5 = new Job(5, "Manager", "4000$", "10 years", "Bucuresti", "Full time");
        Job job6 = new Job(6, "Manual Tester", "1000$", "medium", "Iasi", "Full time");
        Job job7 = new Job(7, "Car Driver", "8000$", "20 years", "Timisoara", "Fulltime");
        Job job8 = new Job(8, "Web Developer", "5000$", "senior", "Iasi", "Part time");

        employer1.addJob(job1);
        employer1.addJob(job2);
        employer1.addJob(job3);
        employer1.addJob(job4);
        employer2.addJob(job5);
        employer2.addJob(job6);
        employer2.addJob(job7);
        employer2.addJob(job8);

        List<Applicant> employer1Aplicants = new ArrayList<>();
        List<Applicant> employer2Aplicants = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            employer1Aplicants.add(new Applicant(i));
            employer2Aplicants.add(new Applicant(i + 10));
        }
        List<Job> employer1Jobs = employer1.getJobList();
        List<Job> employer2Jobs = employer2.getJobList();
        int countEmployer1 = 0;
        for (int i = 0; i < employer1.getJobList().size() - 1; i++) {

            employer1Jobs.get(i).setApplicantList(employer1Aplicants.subList(countEmployer1, countEmployer1 + 2));
            countEmployer1 += 2;
        }
        job4.setApplicantList(employer1Aplicants.subList(9, 10));
        int countEmployer2 = 0;
        for (int i = 0; i < employer2.getJobList().size() - 1; i++) {

            employer2Jobs.get(i).setApplicantList(employer2Aplicants.subList(countEmployer2, countEmployer2 + 2));
            countEmployer2 += 2;
        }
        job8.setApplicantList(employer2Aplicants.subList(9, 10));


        for (Employer employer : List.of(employer1, employer2)) {
            System.out.println("\n Employer " + employer.getName() + " in location " + employer.getCity() + ", has "
                    + employer.getJobList().size() + " jobs listed:");
            for (Job job : employer.getJobList()) {
                System.out.println(job.getId() + ". " + job.getJobTitle());
                System.out.println("Salary: " + job.getSalary());
                System.out.println("Experience required: " + job.getExperience());
                System.out.println("Location: " + job.getLocation());
                System.out.println("Applicants " + job.getApplicantList().size() + ": ");
                for (Applicant applicant : job.getApplicantList()) {
                    System.out.println(applicant.getId());
                }
            }
        }
        Job job9 = new Job(9, "Gamer", "750 $", "medium", "Covasna", "2 hours");
        Job job10 = new Job(10, "Secretary", "230 $", "3 years", "Covasna", "Part time");
        Job job11 = new Job(11, "Junior Java", "830 $", "beginner", "Bacau", "Internship");
        Job job12 = new Job(12, "Secretary", "330 $", "3 years", "Iasi", "Full time");
        employer1.addNewJob(job9);
        employer1.addNewJob(job10);
        employer2.addNewJob(job11);
        employer2.addNewJob(job12);

        job9.apply(new Applicant(21, "Toma", "X", "0745888123", "toma@yahoo.com", "Strada nufar, 21", "ap2", "romania", "Ro", "Iasi"));
        job10.apply(new Applicant(22, "Paul", "Y", "0745888124", "paul@yahoo.com", "Strada nufar, 21", "ap2", "romania", "Ro", "Iasi"));
        job11.apply(new Applicant(23, "Ana", "Z", "0745888125", "ana@yahoo.com", "Strada nufar, 21", "ap2", "romania", "Ro", "Iasi"));
        job12.apply(new Applicant(24, "Anca", "W", "0745888126", "anca@yahoo.com", "Strada nufar, 21", "ap2", "romania", "Ro", "Iasi"));
        job9.apply(new Applicant(25, "Alex", "V", "0745888127", "alex@yahoo.com", "Strada nufar, 21", "ap2", "romania", "Ro", "Iasi"));

        employer1.displayAllJobs();
        List<Applicant> applicantList = employer1.getAllApplicants();
        System.out.println("\n All applicants for " + employer1.getName() + "are:");
        for (Applicant applicant : applicantList) {
            System.out.println(applicant.getFirstName() + " " + applicant.getLastName());
        }
        List<Applicant> applicantsOnJob = job9.getAllApplicantsForJob();
        System.out.println("\n Applicants on job " + job9.getJobTitle() + " are:");
        for (Applicant applicant : applicantsOnJob) {
            System.out.println(applicant.getFirstName() + " " + applicant.getLastName());
        }
        employer1.displayAllJobs();
        employer1.deleteJob(job1);
        employer1.displayAllJobs();
    }
}
