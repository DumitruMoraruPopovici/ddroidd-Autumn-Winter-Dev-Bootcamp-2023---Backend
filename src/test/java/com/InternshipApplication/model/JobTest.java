package com.InternshipApplication.model;

import com.InternshipApplication.exception.BusinessException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JobTest {

    @Test
    void givenAJobApplyAnInvalidApplicant() throws BusinessException {
        Job job = new Job();
        Applicant applicant = new Applicant();
        BusinessException exception = assertThrows(BusinessException.class, () -> job.apply(applicant));


        assertEquals("First name cannot be null, please insert a name", exception.getMessage());
    }

    @Test
    void givenAJobApplyAnValidApplicant() throws BusinessException {
        Job job = new Job();
        Applicant applicant = new Applicant(1, "Paul", "Y", "0745888124",
                "paul@yahoo.com", "Strada nufar, 21", "ap2", "romania", "Ro", "Iasi");

        job.apply(applicant);

        assertEquals(1, job.getApplicantList().size());
    }

}