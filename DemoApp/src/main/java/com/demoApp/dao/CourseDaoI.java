/**
 * 
 */
package com.demoApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoApp.entities.Course;

/**
 * @author Harshal-Git
 *
 */
// <Entity class which will be managed by this interface, Type of the primary key of the class>
public interface CourseDaoI extends JpaRepository<Course, Long>{

}
