/**
 * 
 */
package com.demoApp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demoApp.entities.Course;

/**
 * @author Harshal-Git
 *
 */
public final class DummyDao {

	// prepare logging
	static Logger LOGGER = LoggerFactory.getLogger(DummyDao.class);

	// courses list 
	static List<Course> COURSES_LIST =  new ArrayList<>();

	// no constructor allowed
	private DummyDao() {
	}

	static {
		COURSES_LIST.add(new Course(110, "Java", "Core Java"));
		COURSES_LIST.add(new Course(111, "J2EE", "Advance Java with enterprise applications"));
		COURSES_LIST.add(new Course(112, "Python", "Python basics"));
		COURSES_LIST.add(new Course(113, "Flask", "Python for enterprise applications"));
		COURSES_LIST.add(new Course(114, "RDBMS", "Relational Database Managemenet System basics"));
		COURSES_LIST.add(new Course(115, "Spring", "Spring framework basics"));
	}

	/**
	 * @return - list of all courses
	 */
	public static List<Course> getCourses() {
		return COURSES_LIST;
	}

	/**
	 * @param id - course ID
	 * @return - returns Optional<Course> with ID if present
	 */
	public static Optional<Course> getCourseByID(long id) {
		return COURSES_LIST.stream().filter((course) -> (course.getId() == id)).findAny();
	}

	/**
	 * @param newCourse - new course object to be inserted
	 * @return - newly created course
	 */
	public static Course addNewCourse(Course newCourse) {
		COURSES_LIST.add(newCourse);
		return newCourse;
	}

	/**
	 * @param updatedCourseObj - get updated course object from user
	 * @return - updated course 
	 */
	public static Course updateCourse(Course updatedCourseObj) {
		COURSES_LIST.forEach(course -> {
			if(course.getId() == updatedCourseObj.getId()) {
				course.setTitle(updatedCourseObj.getTitle());
				course.setDescription(updatedCourseObj.getDescription());
			}
		});
		return updatedCourseObj;
	}

	/**
	 * @param courseId - course ID to be deleted
	 * @return - deleted course string representation 
	 */
	public static ResponseEntity<HttpStatus> deleteCourse(long id) {
		Optional<Course> deleteCourse = getCourseByID(id);
		if(deleteCourse.isEmpty()) {
			LOGGER.error("Invalid course ID passed. No course with ID= "+id+" found.");
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			COURSES_LIST.remove(deleteCourse.get());
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
}
