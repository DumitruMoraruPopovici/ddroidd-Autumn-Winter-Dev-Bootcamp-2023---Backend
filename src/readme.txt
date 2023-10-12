     Data Structure Breakdown
**Package Exception**

 -- Classes --
 1. BusinessException
 - Is for custom messages thrown by business logic

**Package Model**
 -- Classes --

1. Employer
   - Represents a company or organization.
   - Attributes:
     - id: Unique identifier for the employer.
     - name: Name of the employer.
     - city: Location of the employer.
     - description: Short description of the employer.
     - jobList: List of jobs posted by the employer.

2. Job
   - Represents a job opportunity posted by an employer.
   - Attributes:
     - id: Unique identifier for the job.
     - jobTitle: Title of the job listing.
     - salary: Description of the salary provided for the job.
     - experience: Experience required for the job.
     - location: Location for the job.
     - jobType: Type of work performed at the job.
     - applicantsList: List with applicants that applied at the job.

3. Applicant
   - Represents a person applying for a job.
   - Attributes:
     - id: Unique identifier for the applicant.
     - firstName: First name of the applicant.
     - lastName: Last name of the applicant.
     - phoneNumber: Phone number of the applicant.
     - email: Email of the applicant.
     - address1: Street name and number of the applicant.
     - address2: Suite and apartment of the applicant.
     - country: Country where applicant is living.
     - state: State where applicant is living.
     - city: City where applicant is living.

-- Methods

1. apply(Applicant applicant) - Job class
   - Allows an applicant to apply for a specific job listing.

2. addJob(String title, String description) - Employer class
   - Adds a new job listing for the employer.
   - Validates input data to ensure it's not null or empty.

-- Usage

1. Create employers, job listings, and applicants.
2. Distribute applicants to job listings.
3. Display the contents of the data structure.
4. Allow applicants to apply for job listings.
5. Add new job listings for employers.

** Package program **

-- Classes --

1. Main
It has the basic data structure build and also it can display the content of the data structure defined
by simply running the psvm.
Has 2 employers created , with 4 jobs and 10 applicants for each employer.

-- Usage --
point of entry and basic display


** Package repository**

-- Classes --

1. ApplicantRepository
-Used for applicant repository with CRUD methods

2. EmployerRepository
-Used for employer repository with CRUD methods


** Package resources**
Contains the persistence.xml file who creates the link to the database and helps us work with our database


** Package webapp **
Contains the .jsp files and .css files for proper deploy on site


Requirements :
   - Java 17
   -GIT

Application can be accessed from program/main and from configuration with Apache Tomcat
