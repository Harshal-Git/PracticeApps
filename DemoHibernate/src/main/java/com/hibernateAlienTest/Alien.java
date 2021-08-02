/**
 * 
 */
package com.hibernateAlienTest;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author hcharadava
 *
 */
@Entity
@Table(name = "alien_table")
public class Alien {

	@Id
	@Column(name = "alien_id")
	private int alien_id;
	
	@Column
	private AlienName alien_name;
	
	@Column(name = "alien_color")
	private String color;
	
	@Transient
	private String origin;

	/**
	 * @return the alien_id
	 */
	public int getAlien_id() {
		return alien_id;
	}

	/**
	 * @param alien_id the alien_id to set
	 */
	public void setAlien_id(int alien_id) {
		this.alien_id = alien_id;
	}

	/**
	 * @return the alien_name
	 */
	public AlienName getAlien_name() {
		return alien_name;
	}

	/**
	 * @param alien_name the alien_name to set
	 */
	public void setAlien_name(AlienName alien_name) {
		this.alien_name = alien_name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the origin
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(String origin) {
		this.origin = origin;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alien [alien_id=").append(alien_id).append(", alien_name=").append(alien_name)
				.append(", color=").append(color).append("]");
		return builder.toString();
	}
	
}
