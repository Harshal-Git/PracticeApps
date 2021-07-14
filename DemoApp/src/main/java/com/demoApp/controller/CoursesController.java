/**
 * 
 */
package com.demoApp.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demoApp.entities.Course;
import com.demoApp.services.CourseServices;

/**
 * @author Harshal-Git
 *
 *	-> Controller for all courses operations
 */
@RestController
public class CoursesController {

	// service class reference for Course service
	@Autowired
	private CourseServices courseServiceI; 
	
	// prepare logging
	Logger LOGGER = LoggerFactory.getLogger(CoursesController.class);
	/*
	 * LOGGER.trace("A TRACE Message");
	 * LOGGER.debug("A DEBUG Message");
	 * LOGGER.info("An INFO Message");
	 * LOGGER.warn("A WARN Message");
	 * LOGGER.error("An ERROR Message");
	 * LOGGER.fatal("A FATAL ERROR Message");
	 */
	
	/*
	 * @RequestMapping is MVC annotation - for boot applications
	 * annotations are preferred as per the request type. 
	 */
	//@GetMapping("/home")
	@RequestMapping(path="/home", method = RequestMethod.GET)
	public String home() {
		String msg = "Welcome to Courses application.";
		LOGGER.debug(msg);
		return msg;
	}
	
	/**
	 * returns list of all courses (GET : /courses)
	 * @return - list of courses
	 */
	@GetMapping("/courses")
	public List<Course> getCourses(){
		LOGGER.debug("getCourses() for all courses called");
		return this.courseServiceI.getCourses();
	}
	
	/**
	 * returns Course with specific ID (GET : /courses/{courseId})
	 * @param courseID - course ID (string)
	 * @return - returns Optional<Course> with ID if present
	 */
	@GetMapping("/courses/{courseId}")
	public Optional<Course> getCourseByID(@PathVariable String courseId) {
		LOGGER.debug("getCourseByID() called for ID-"+courseId);
		return this.courseServiceI.getCourseById(courseId);
	}
	
	/**
	 * inserts a new course object (POST : /courses)
	 * @param newCourse - new course object to be inserted (obtained from message body)
	 * @return - newly created course
	 */
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course newCourse) {
		LOGGER.debug("addCourse() called for : "+newCourse.toString());
		return this.courseServiceI.addCourse(newCourse);
	}
	
	/**
	 * update the given course data (PUT : /courses)
	 * @param updatedCourseObj - course object which needs to be updated
	 * @return - updated course object
	 */
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course updatedCourseObj) {
		LOGGER.debug("updateCourse() called for : "+updatedCourseObj.toString());
		return this.courseServiceI.updateCourse(updatedCourseObj);
	}
	
	/**
	 * delete the course by given course ID (DELETE : /courses/{courseId} )
	 * @param courseId - course ID to be deleted
	 * @return - deleted course string representation 
	 */
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourseByID(@PathVariable String courseId) {
		LOGGER.debug("deleteCourseByID() called for : "+courseId);
		return this.courseServiceI.deleteCourse(courseId);
	}
}
