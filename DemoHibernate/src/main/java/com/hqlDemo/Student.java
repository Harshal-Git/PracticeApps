/**
 * 
 */
package com.hqlDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Harshal
 *
 */
@Entity
@Table(name = "students")
public class Student {

	@Id
	@Column(name="student_id")
	private int student_id;

	@Column(name = "student_name", length = 50)
	private String student_name;

	@Column(name="student_marks")
	private int marks;

	/**
	 * @return the student_id
	 */
	public int getStudent_id() {
		return student_id;
	}

	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	/**
	 * @return the student_name
	 */
	public String getStudent_name() {
		return student_name;
	}

	/**
	 * @param student_name the student_name to set
	 */
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	/**
	 * @return the marks
	 */
	public int getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [student_id=").append(student_id).append(", student_name=").append(student_name)
		.append(", marks=").append(marks).append("]");
		return builder.toString();
	}
}
