 <%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
 <%@ page import="java.util.List" %>
 <%@ page import="com.InternshipApplication.model.Employer" %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">

            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
            <link rel="stylesheet" href="https://unpkg.com/bootstrap-table@1.21.4/dist/bootstrap-table.min.css">
            <link rel="stylesheet" href="styleHome.css">
</head>
<body>
 <form action="addEmployer.jsp">
             <div class="form-outline mb-4">
                 <input type="text" name="name" value="Name..." onclick="this.value=''" required/><br/>
             </div>
             <div class="form-outline mb-4">
                 <input type="text" name="city"  value="City..." onclick="this.value=''" required/><br/>
             </div>
             <div class="form-outline mb-4">
                 <input type="text" name="Description" value="Description..." onclick="this.value=''" required/><br/>
             </div>
             <input type="submit" value="SignUp" class="btn btn-primary">
             </form>

</body>
</html>