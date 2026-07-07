# course-management-system

## Testing using POSTMAN

### Step 1: Setup Postman Environment

1. Open Postman.
2. Click **New** → **Collection**.
3. Name it: **Course Management System**.
4. Click **Save**.

### Step 2: Create a New Course (POST)

- Method: `POST`
- URL: `http://localhost:8080/api/courses`
- Headers:
  ```
  Content-Type: application/json
  ```
- Body: `raw` → `JSON`

#### Course 1 - Computer Science
```json
{
    "courseCode": "CS101",
    "courseName": "Introduction to Computer Science",
    "courseTime": "MWF 10:00 AM - 11:00 AM",
    "courseInstructor": "Dr. Alan Turing"
}
```

#### Course 2 - Mathematics
```json
{
    "courseCode": "MATH201",
    "courseName": "Calculus II",
    "courseTime": "TTH 2:00 PM - 3:30 PM",
    "courseInstructor": "Dr. Ada Lovelace"
}
```

#### Course 3 - Physics
```json
{
    "courseCode": "PHY101",
    "courseName": "Introductory Physics",
    "courseTime": "MWF 1:00 PM - 2:00 PM",
    "courseInstructor": "Dr. Marie Curie"
}
```

#### Course 4 - Biology
```json
{
    "courseCode": "BIO301",
    "courseName": "Molecular Biology",
    "courseTime": "TTH 10:00 AM - 11:30 AM",
    "courseInstructor": "Dr. Rosalind Franklin"
}
```

#### Course 5 - English
```json
{
    "courseCode": "ENG101",
    "courseName": "English Composition",
    "courseTime": "MWF 3:00 PM - 4:00 PM",
    "courseInstructor": "Dr. Jane Austen"
}
```

#### Course 6 - History
```json
{
    "courseCode": "HIST101",
    "courseName": "World History",
    "courseTime": "TTH 1:00 PM - 2:30 PM",
    "courseInstructor": "Dr. Herodotus"
}
```

#### Course 7 - Psychology
```json
{
    "courseCode": "PSY201",
    "courseName": "Cognitive Psychology",
    "courseTime": "MWF 11:00 AM - 12:00 PM",
    "courseInstructor": "Dr. Sigmund Freud"
}
```

#### Course 8 - Chemistry
```json
{
    "courseCode": "CHEM101",
    "courseName": "General Chemistry",
    "courseTime": "TTH 3:00 PM - 4:30 PM",
    "courseInstructor": "Dr. Marie Curie"
}
```

#### Course 9 - Economics
```json
{
    "courseCode": "ECO101",
    "courseName": "Principles of Economics",
    "courseTime": "MWF 9:00 AM - 10:00 AM",
    "courseInstructor": "Dr. Adam Smith"
}
```

#### Course 10 - Art
```json
{
    "courseCode": "ART101",
    "courseName": "Introduction to Fine Arts",
    "courseTime": "TTH 11:00 AM - 12:30 PM",
    "courseInstructor": "Dr. Leonardo da Vinci"
}
```

### Expected Response (201 Created)
```json
{
    "id": 1,
    "courseCode": "CS101",
    "courseName": "Introduction to Computer Science",
    "courseTime": "MWF 10:00 AM - 11:00 AM",
    "courseInstructor": "Dr. Alan Turing"
}
```

### Step 3: Get All Courses (GET)

- Method: `GET`
- URL: `http://localhost:8080/api/courses`

### Expected Response (200 OK)
```json
[
    {
        "id": 1,
        "courseCode": "CS101",
        "courseName": "Introduction to Computer Science",
        "courseTime": "MWF 10:00 AM - 11:00 AM",
        "courseInstructor": "Dr. Alan Turing"
    },
    {
        "id": 2,
        "courseCode": "MATH201",
        "courseName": "Calculus II",
        "courseTime": "TTH 2:00 PM - 3:30 PM",
        "courseInstructor": "Dr. Ada Lovelace"
    },
    {
        "id": 3,
        "courseCode": "PHY101",
        "courseName": "Introductory Physics",
        "courseTime": "MWF 1:00 PM - 2:00 PM",
        "courseInstructor": "Dr. Marie Curie"
    }
]
```

### Step 4: Get Course by ID (GET)

- Method: `GET`
- URL: `http://localhost:8080/api/courses/1`

### Expected Response (200 OK)
```json
{
    "id": 1,
    "courseCode": "CS101",
    "courseName": "Introduction to Computer Science",
    "courseTime": "MWF 10:00 AM - 11:00 AM",
    "courseInstructor": "Dr. Alan Turing"
}
```

### Step 5: Update a Course (PUT)

- Method: `PUT`
- URL: `http://localhost:8080/api/courses/1`
- Headers:
  ```
  Content-Type: application/json
  ```
- Body: `raw` → `JSON`

#### Update Course 1 - Change Time and Name
```json
{
    "courseCode": "CS101",
    "courseName": "Advanced Computer Science",
    "courseTime": "MWF 2:00 PM - 3:30 PM",
    "courseInstructor": "Dr. Alan Turing"
}
```

#### Update Course 2 - Change Instructor
```json
{
    "courseCode": "MATH201",
    "courseName": "Calculus II",
    "courseTime": "TTH 2:00 PM - 3:30 PM",
    "courseInstructor": "Dr. Alan Turing"
}
```

### Expected Response (200 OK)
```json
{
    "id": 1,
    "courseCode": "CS101",
    "courseName": "Advanced Computer Science",
    "courseTime": "MWF 2:00 PM - 3:30 PM",
    "courseInstructor": "Dr. Alan Turing"
}
```

### Step 6: Delete a Course (DELETE)

- Method: `DELETE`
- URL: `http://localhost:8080/api/courses/1`

### Expected Response
- Status: `204 No Content`
- Body: Empty

### Step 7: Test Validation Errors

#### Test 1: Missing Course Code (POST)
```json
{
    "courseCode": "",
    "courseName": "Test Course",
    "courseTime": "MWF 10:00 AM",
    "courseInstructor": "Dr. Test"
}
```

#### Test 2: Course Code Too Long
```json
{
    "courseCode": "THISISAVERYLONGCOURSECODETHATEXCEEDSTWENTYCHARACTERS",
    "courseName": "Test Course",
    "courseTime": "MWF 10:00 AM",
    "courseInstructor": "Dr. Test"
}
```

#### Test 3: Missing Course Name
```json
{
    "courseCode": "TEST101",
    "courseName": "",
    "courseTime": "MWF 10:00 AM",
    "courseInstructor": "Dr. Test"
}
```

#### Test 4: Course Not Found (GET)
- URL: `http://localhost:8080/api/courses/999`

#### Test 5: Course Not Found (PUT)
- URL: `http://localhost:8080/api/courses/999`

#### Test 6: Invalid Credentials (Unauthorized)
- Remove or change the Authorization header

### Step 8: Complete Testing Sequence

1. Create 5 Courses using POST
2. Get all courses with GET
3. Get course by ID with GET
4. Update a course with PUT
5. Get all courses again
6. Delete a course with DELETE
7. Get all courses again
8. Test error handling

### Step 9: H2 Database Verification

#### Access H2 Console
- URL: `http://localhost:8080/h2-console`
- Driver Class: `org.h2.Driver`
- JDBC URL: `jdbc:h2:mem:coursedb`
- User Name: `sa`
- Password: (leave empty)

#### SQL Queries
```sql
SELECT * FROM COURSES;
SELECT COUNT(*) FROM COURSES;
SELECT * FROM COURSES WHERE COURSE_CODE = 'CS101';
SELECT * FROM COURSES WHERE COURSE_INSTRUCTOR = 'Dr. Marie Curie';
SELECT * FROM COURSES WHERE COURSE_TIME LIKE '%PM%';
SELECT COURSE_INSTRUCTOR, COUNT(*) as total_courses 
FROM COURSES 
GROUP BY COURSE_INSTRUCTOR;
```

### Step 10: Postman Collection Export

Request list:
- POST `/api/courses` — Create CS101
- POST `/api/courses` — Create MATH201
- POST `/api/courses` — Create PHY101
- GET `/api/courses` — Get all courses
- GET `/api/courses/1` — Get CS101
- GET `/api/courses/2` — Get MATH201
- PUT `/api/courses/1` — Update CS101
- DELETE `/api/courses/3` — Delete PHY101
- GET `/api/courses` — Verify deletion
- GET `/api/courses/999` — Test 404 error
- POST `/api/courses` — Test validation error

### Quick Reference

- Base URL: `http://localhost:8080`
- Headers: `Content-Type: application/json`
- HTTP Status Codes:
  - `200 OK`
  - `201 Created`
  - `204 No Content`
  - `400 Bad Request`
  - `404 Not Found`
  - `500 Internal Server Error`
