/**
 * 
 */
package com.hibernateMapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author Harshal
 *
 */
@Entity
@Table(name = "students")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Student {

	@Id
	@Column(name="student_id")
	private int student_id;

	@Column(name = "student_name", length = 50)
	private String student_name;

	@Column(name="student_marks")
	private int marks;

	// each student has one laptop
	//@OneToOne
	//private Laptop laptop;

	/**
	 * @return the laptop
	 */
	/*public Laptop getLaptop() {
		return laptop;
	}*/

	/**
	 * @param laptop the laptop to set
	 */
	/*public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}*/

	// each student has multiple laptop
	@ManyToMany(mappedBy = "students", fetch = FetchType.LAZY)
	// mappedBy will inform Student table not to create an internal table for it's mapping
	// that mapping is taken care by "student" object within Laptop class
	private List<Laptop> laptops = new ArrayList<>();
	
	/**
	 * @return the laptops
	 */
	public List<Laptop> getLaptops() {
		return laptops;
	}

	/**
	 * @param laptops the laptops to set
	 */
	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

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
