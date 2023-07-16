package in.ushatech.mastermicroservice.controller;


import in.ushatech.mastermicroservice.domain.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

// .courses
// Course: id,name,author
@RestController
public class CourseController
{
    @RequestMapping("courses")
    public List<Course> retrieveAllCourses()
    {
        return Arrays.asList(
                new Course(1L,"Learn AWS","Fastprep"),
        new Course(1L,"Learn Azure","Fastprep"),
        new Course(1L,"Learn Maths","Fastp rep")
        );
    }
}
