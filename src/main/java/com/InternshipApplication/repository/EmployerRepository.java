package com.InternshipApplication.repository;

import com.InternshipApplication.exception.BusinessException;
import com.InternshipApplication.model.Employer;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@PersistenceContext
public class EmployerRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
    EntityManager entityManager = emFactory.createEntityManager();
    List<Employer> employerList = new ArrayList<>();

    public List<Employer> getAllEmployers() {
        TypedQuery<Employer> typedQuery = entityManager.createQuery("select e from Employer e", Employer.class);
        List<Employer> employerList1 = typedQuery.getResultList();
        entityManager.close();
        emFactory.close();
        return employerList1;
    }

    public boolean employerAlreadyExists(Employer employer) {
        if (employerList.contains(employer)) {
            return false;
        }
        return true;
    }

    public void createEmployer(Employer employer) throws BusinessException {
        try {
            if (employerAlreadyExists(employer)) {
                try {
                    entityManager.getTransaction().begin();
                    entityManager.persist(employer);
                    entityManager.getTransaction().commit();
                } catch (RuntimeException e) {
                    throw new BusinessException("Internal error adding employer");
                }
            } else {
                throw new BusinessException("Employer exists already");
            }
        } catch (RuntimeException e) {
            throw new BusinessException("Internal error, cannot continue");
        }
    }


}
