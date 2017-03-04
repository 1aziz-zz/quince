package org.aziz.quince.rest;

import org.aziz.quince.model.Course;
import org.aziz.quince.service.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by aziz on 21-2-17.
 */
@RestController

public class MainResources {

    /*
    Refactoring: Extract Parameter Object:

    @RequestMapping(value = "/rest/calculate", method = RequestMethod.GET, produces = "application/json")
    public int calculate(@RequestParam("a") Integer numberA, @RequestParam("b") Integer numberB, @RequestParam("o") String operation) {
        Calculator calculator = new Calculator(numberA, numberB, operation);
        return calculator.calculate();
    }
*/
    private Calculator calculator;

    @RequestMapping(value = "/rest/add", method = RequestMethod.GET, produces = "application/json")
    public int addNumbers(@RequestParam("a") Integer numberA, @RequestParam("b") Integer numberB) {
        calculator = new BasicCalculation(numberA, numberB);
        return calculator.calculate();
    }

    @RequestMapping(value = "/rest/add/check", method = RequestMethod.GET, produces = "application/json")
    public boolean checkNumbers() {
        return calculator.checkSum();
    }

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
