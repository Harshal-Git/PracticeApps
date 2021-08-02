/**
 * 
 */
package com.hibernateAlienTest;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author hcharadava
 *
 */
@Embeddable
public class AlienName {

	@Column
	private String first_name;
	
	@Column
	private String middle_name;
	
	@Column
	private String last_name;

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the middle_name
	 */
	public String getMiddle_name() {
		return middle_name;
	}

	/**
	 * @param middle_name the middle_name to set
	 */
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AlienName [first_name=").append(first_name).append(", middle_name=").append(middle_name)
				.append(", last_name=").append(last_name).append("]");
		return builder.toString();
	}
	
}
