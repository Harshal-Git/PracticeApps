/**
 * 
 */
package com.hibernateMapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Harshal
 *
 */
@Entity
@Table(name = "laptop")
public class Laptop {

	@Id
	@Column(name="laptop_id")
	private int laptop_id;
	
	@Column(name="brand")
	private String name;

	// many laptop can be acquired by single student
	// it can be done only in compliance with each student having multiple laptop.
	//@ManyToOne
	//private Student student;
	
	/**
	 * @return the student
	 */
	/*public Student getStudent() {
		return student;
	}*/

	/**
	 * @param student the student to set
	 */
	/*public void setStudent(Student student) {
		this.student = student;
	}*/
	
	@ManyToMany
	private List<Student> students = new ArrayList<>();

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * @return the laptop_id
	 */
	public int getLaptop_id() {
		return laptop_id;
	}

	/**
	 * @param laptop_id the laptop_id to set
	 */
	public void setLaptop_id(int laptop_id) {
		this.laptop_id = laptop_id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Laptop [laptop_id=").append(laptop_id).append(", name=").append(name).append("]");
		return builder.toString();
	}
	
}
