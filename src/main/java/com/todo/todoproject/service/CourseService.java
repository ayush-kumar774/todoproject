package com.todo.todoproject.service;

import com.todo.todoproject.entity.Course;
import com.todo.todoproject.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository ;

    // POST
    public Course saveCourse(Course course) {
        System.out.println(course.toString());
        return courseRepository.save(course);
    }

    // POST
    public List<Course> saveCourses(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    // GET
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course getCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    public List<Course> getCourseForUser(String username) {
        return courseRepository.findAllByUsername(username);
    }

    // PUT

    public Course updateCourse(Course course) {
        System.out.println("updates");
        Course existing_course = courseRepository.findById(course.getId()).orElse(null);
        existing_course.setName(course.getName());
        existing_course.setDescription(course.getDescription());
        existing_course.setStatus(course.getStatus());
        return courseRepository.save(existing_course);
    }

    // DELETE
    public String deleteCourse(int id) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course == null) {
            return "There is no such course.";
        }
        courseRepository.deleteById(id);
        return id + " id -> " + course + " removed/completed.";
    }

}
