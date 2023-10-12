<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ page import="java.util.List" %>
<%@ page import="com.InternshipApplication.model.Employer" %>
<%@ page import="com.InternshipApplication.exception.BusinessException" %>
<%@ page import="com.InternshipApplication.repository.EmployerRepository" %>



<html>

<body>
<%
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String description = request.getParameter("description");

        Employer employer = new Employer(name,city,description);
            try {
                EmployerRepository employerRepo = new EmployerRepository();
                employerRepo.createEmployer(employer);
                } catch (BusinessException e) {
                    request.setAttribute("errorMessage", e.getMessage());
                    request.getRequestDispatcher("errorPage.jsp").forward(request, response);
                }

    %>

</body>

</html>
