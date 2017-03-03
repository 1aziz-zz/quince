package org.aziz.quince.service;

import org.aziz.quince.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional

public interface CourseRepository extends CrudRepository<Course, Integer> {

}
