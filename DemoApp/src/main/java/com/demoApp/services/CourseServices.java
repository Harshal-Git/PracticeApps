/**
 * 
 */
package com.demoApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demoApp.entities.Course;

/**
 * @author Harshal-Git
 *
 *	-> course services 
 */
public interface CourseServices {

	/**
	 * @return - list of all courses
	 */
	public List<Course> getCourses();
	
	/**
	 * @param id - course ID
	 * @return - returns Optional<Course> with ID if present
	 */
	public Optional<Course> getCourseById(String courseID);
	
	/**
	 * @param newCourse - new course object to be inserted
	 * @return - newly created course
	 */
	public Course addCourse(Course newCourse);

	/**
	 * @param updatedCourseObj - course object which needs to be updated
	 * @return - updated course object
	 */
	public Course updateCourse(Course updatedCourseObj);

	/**
	 * @param courseId - course ID to be deleted
	 * @return - deleted course string representation
	 */
	public ResponseEntity<HttpStatus> deleteCourse(String courseId);
}
