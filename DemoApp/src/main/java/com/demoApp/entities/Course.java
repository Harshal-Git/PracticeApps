/**
 * 
 */
package com.demoApp.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Harshal-Git
 *
 */
@Entity
@Table(name = "Course")
public class Course implements Serializable{

	private static final long serialVersionUID = 473825610079004209L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	
	private String description;

	/**
	 * Default constructor 
	 */
	public Course() {
		super();
	}
	
	/**
	 * @param id
	 * @param title
	 * @param description
	 * WILL NOT BE USED FOR JPA
	 */
	public Course(long id, String title, String description) {
		super();
		setId(id);
		setTitle(title);
		setDescription(description);
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	private void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Course [id=").append(id).append(", title=").append(title).append(", description=")
				.append(description).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Course))
			return false;
		Course other = (Course) obj;
		return Objects.equals(description, other.description) && id == other.id && Objects.equals(title, other.title);
	}
	
}
