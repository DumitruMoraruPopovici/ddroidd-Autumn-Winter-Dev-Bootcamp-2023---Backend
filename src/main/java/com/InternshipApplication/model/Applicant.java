package com.InternshipApplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "applicant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Applicant {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address1;
    private String address2;
    private String country;
    private String state;
    private String city;
    @ManyToOne(fetch = FetchType.LAZY) //relation between applicant and job
    @JoinColumn(name = "jobs_id")
    List<Job> job = new ArrayList<>();

    public Applicant(int id, String firstName, String lastName, String phoneNumber, String email, String address1, String address2, String country, String state, String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address1 = address1;
        this.address2 = address2;
        this.country = country;
        this.state = state;
        this.city = city;
    }

    public Applicant(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Applicant(int id) {
        this.id = id;
    }
//method override for toString()
    @Override
    public String toString() {
        return "Applicant " + id;
    }
}
