/**
 * 
 */
package com.demoApp.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demoApp.dao.CourseDaoI;
import com.demoApp.entities.Course;

/**
 * @author Harshal-Git
 *
 */
@Service
public class CourseServicesImpl implements CourseServices {

	// Logger
	static Logger LOGGER = LoggerFactory.getLogger(CourseServicesImpl.class);
	
	// Dao implementation reference
	@Autowired
	private CourseDaoI coursesDao;
	
	@Override
	public List<Course> getCourses() {
		//return DummyDao.getCourses();
		return coursesDao.findAll();
	}

	@Override
	public Optional<Course> getCourseById(String courseID) {
		//return DummyDao.getCourseByID(Long.parseLong(courseID));
		return coursesDao.findById(Long.parseLong(courseID));
	}

	@Override
	public Course addCourse(Course newCourse) {
		//return DummyDao.addNewCourse(newCourse);
		return coursesDao.save(newCourse);
	}

	@Override
	public Course updateCourse(Course updatedCourseObj) {
		//return DummyDao.updateCourse(updatedCourseObj);
		return coursesDao.saveAndFlush(updatedCourseObj);
	}

	@Override
	public ResponseEntity<HttpStatus> deleteCourse(String courseId) {
		//return DummyDao.deleteCourse(Long.parseLong(courseId));
		try {
			coursesDao.deleteById(Long.parseLong(courseId));
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch(EmptyResultDataAccessException exc) {
			LOGGER.error(exc.getLocalizedMessage());
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
