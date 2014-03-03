package com.neetpiq.android.samplealertdialog.data;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

import com.neetpiq.android.samplealertdialog.model.Speaker;
import com.neetpiq.android.samplealertdialog.model.Topic;

public class DatabaseManager {

	protected static final String TAG = "DatabaseManager";

	static private DatabaseManager instance;

	static public void initInstance(Context ctx) {
		
		if (null == instance) {
			instance = new DatabaseManager(ctx);
		}
		
	}

	static public DatabaseManager getInstance() {
		return instance;
	}

	private DatabaseHelper helper;

	private DatabaseManager(Context ctx) {
		helper = new DatabaseHelper(ctx);
	}

	
	public List<Topic> getAllTopics() {
		
		List<Topic> topics = null;
		
		try {
			topics = helper.getTopicDao().queryForAll();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return topics;
	}
	
	public List<Speaker> getAllSpeakers() {
		
		List<Speaker> speakers = null;
		
		try {
			speakers = helper.getSpeakerDao().queryForAll();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return speakers;
	}

}
