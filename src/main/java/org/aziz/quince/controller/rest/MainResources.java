package org.aziz.quince.controller.rest;

import org.aziz.quince.model.Course;
import org.aziz.quince.service.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by aziz on 21-2-17.
 */
@RestController

public class MainResources {

    @RequestMapping(value = "/rest/courses", method = RequestMethod.GET, produces = "application/json")
    public Iterable<Course> loadAllCourses() {
        return courseRepository.findAll();
    }


    @RequestMapping(value = "/rest/courses/{id}", method = RequestMethod.GET, produces = "application/json")
    public Course loadCoursebyID(@PathVariable("id") Integer id) {
        return courseRepository.findOne(id);

    }

    @Autowired
    private CourseRepository courseRepository;
}
