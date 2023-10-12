package com.InternshipApplication.model;

import com.InternshipApplication.exception.BusinessException;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String jobTitle;
    private String salary;
    private String experience;
    private String location;
    private String jobType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private Employer employer;
    @OneToMany(mappedBy = "jobs", cascade = CascadeType.ALL)
    private List<Applicant> applicantList = new ArrayList<>();

    public Job(int id, String jobTitle, String salary, String experience, String location, String jobType) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.experience = experience;
        this.location = location;
        this.jobType = jobType;
    }
    //method for validating the number format
    private boolean isPhoneNumberValid(String phoneNumber) {
        String phoneValidation = "^07\\d{8}$";
        return phoneNumber.matches(phoneValidation);
    }
    //method for validating the email
    private boolean isEmailValid(String email) {
        String emailValidation = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailValidation);
    }
    //method for applying to a job
    public void apply(Applicant applicant) throws BusinessException {
        if (applicant.getFirstName() == null) {
            throw new BusinessException("First name cannot be null, please insert a name");
        }
        if (applicant.getLastName() == null) {
            throw new BusinessException("Last name cannot be empty, please provide a last name");
        }
        if (!isPhoneNumberValid(applicant.getPhoneNumber())) {
            throw new BusinessException("The phone number is invalid, please enter a proper phone number");
        }
        if (!isEmailValid(applicant.getEmail())) {
            throw new BusinessException("The email is invalid, please enter a valid email");
        }
        if (applicant.getAddress1() == null) {
            throw new BusinessException("The address cannot be empty, please enter a street and number of street");
        }
        if (applicant.getCountry() == null) {
            throw new BusinessException("The country cannot be empty, please enter a country");
        }
        if (applicant.getCity() == null) {
            throw new BusinessException("The city cannot be empty, please enter a city name");
        }
        applicantList.add(applicant);

    }
    //method for getting all applicants from a job
    public List<Applicant> getAllApplicantsForJob() {
        return applicantList;

    }

}
