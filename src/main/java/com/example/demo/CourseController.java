package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    Service ser;

    @RequestMapping("/courses2")

    public List<Course> retrieveAllCourses() throws IOException {
        return ser.whenSetDefaultHeader_thenCorrect();
//        return Arrays.asList(
//                new Course(1,"learn aws","desc1"),
//                new Course(2,"learn devops","desc2")
//        );
    }
}
