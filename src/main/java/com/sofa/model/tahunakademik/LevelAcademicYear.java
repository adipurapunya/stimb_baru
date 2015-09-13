package com.sofa.model.tahunakademik;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LevelAcademicYear 
{	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	@Column(nullable = false, length = 30)
	private String levelAcademic;
	
	@Column(nullable = true, length = 30)
	private String description;
	
	public LevelAcademicYear()
	{}

	public LevelAcademicYear(String levelAcademic, String description) {
		this.levelAcademic = levelAcademic;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevelAcademic() {
		return levelAcademic;
	}

	public void setLevelAcademic(String levelAcademic) {
		this.levelAcademic = levelAcademic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
