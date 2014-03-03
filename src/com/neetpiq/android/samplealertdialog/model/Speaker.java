package com.neetpiq.android.samplealertdialog.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable
public class Speaker {
	
	@DatabaseField(generatedId=true)
	private int id;
	
	@DatabaseField
	private String Name;
	
	@DatabaseField
	private String Description;
	
	@DatabaseField
	private String PersonalUrl;
	
	/*
	 * constructor
	 */
	public Speaker() {
		// ORMLite needs a no-arg constructor
	}
	
	public Speaker(String name, String description, String personalUrl) {
		this.Name = name;
		this.Description = description;
		this.PersonalUrl = personalUrl;
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

	public String getPersonalUrl() {
		return PersonalUrl;
	}

	public void setPersonalUrl(String personalUrl) {
		PersonalUrl = personalUrl;
	}
	
}
