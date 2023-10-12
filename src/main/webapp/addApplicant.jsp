<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="java.util.List" %>
<%@ page import="com.InternshipApplication.model.Applicant" %>
<%@ page import="com.InternshipApplication.exception.BusinessException" %>
<%@ page import="com.InternshipApplication.repository.ApplicantRepository" %>



<html>

<body>
<%
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String description = request.getParameter("description");

        Applicant applicant = new Applicant(name,city,description);

                ApplicantRepository applicantRepository = new ApplicantRepository();
                applicantRepository.addApplicant(applicant);

    %>

</body>

</html>
