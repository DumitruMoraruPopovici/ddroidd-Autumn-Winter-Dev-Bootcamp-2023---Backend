package com.InternshipApplication.repository;

import com.InternshipApplication.model.Applicant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@PersistenceContext
public class ApplicantRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");

    EntityManager entityManager = emFactory.createEntityManager();

    List<Applicant> applicantList = new ArrayList<>();

    public void addApplicant (Applicant applicant) {
        entityManager.getTransaction().begin();
        entityManager.persist(applicant);
        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }
}
