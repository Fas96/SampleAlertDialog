package com.neetpiq.android.samplealertdialog.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Topic {
	
	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField
	private String Name;
	
	@DatabaseField
	private String Description;
	
	/*
	 * constructor
	 */
	public Topic() {
		// ORMLite needs a no-arg constructor
	}
	
	public Topic(String name, String description) {
		this.Name = name;
		this.Description = description;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
}
