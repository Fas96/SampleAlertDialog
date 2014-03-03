package com.neetpiq.android.samplealertdialog.data;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.neetpiq.android.samplealertdialog.model.Speaker;
import com.neetpiq.android.samplealertdialog.model.Topic;



public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	protected static final String TAG = "DatabaseHelper";

	// name of the database file for your application
	private static final String DATABASE_NAME = "SampleDB.sqlite";

	// any time you make changes to your database objects, you may have to
	// increase the database version
	private static final int DATABASE_VERSION = 1;

	// the DAO object we use to access the SimpleData table
	private Dao<Speaker, Integer> speakerDao = null;
	private Dao<Topic, Integer> topicDao = null;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database,
			ConnectionSource connectionSource) {

		try {

			TableUtils.createTable(connectionSource, Speaker.class);
			TableUtils.createTable(connectionSource, Topic.class);
			// TableUtils.createTable(connectionSource, WishItem.class);

			Log.i(TAG, "Database tables created.");

			populateSpeakers();
			populateTopics();

			Log.i(TAG, "Database tables populated.");

		} catch (SQLException e) {

			Log.e(TAG, "Can't create database", e);
			throw new RuntimeException(e);

		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {

		try {
			List<String> allSql = new ArrayList<String>();

			switch (oldVersion) {
			case 2:
				// allSql.add("alter table AdData add column `new_col` VARCHAR");
				// allSql.add("alter table AdData add column `new_col2` VARCHAR");
				TableUtils.dropTable(connectionSource, Speaker.class, true);
				TableUtils.dropTable(connectionSource, Topic.class, true);

				Log.i(TAG, "Database tables dropped.");

				TableUtils.createTable(connectionSource, Speaker.class);
				TableUtils.createTable(connectionSource, Topic.class);
				// TableUtils.createTable(connectionSource, WishItem.class);

				Log.i(TAG, "Database tables created.");

				populateSpeakers();
				populateTopics();

				Log.i(TAG, "Database tables populated.");

			}

			for (String sql : allSql) {
				db.execSQL(sql);
			}

		} catch (java.sql.SQLException e) {

			Log.e(TAG, "exception during onUpgrade", e);
			throw new RuntimeException(e);
		}

	}

	public Dao<Speaker, Integer> getSpeakerDao() throws SQLException {

		if (null == this.speakerDao) {
			this.speakerDao = getDao(Speaker.class);
		}

		return this.speakerDao;
	}

	public Dao<Topic, Integer> getTopicDao() throws SQLException {

		if (null == this.topicDao) {
			this.topicDao = getDao(Topic.class);
		}

		return this.topicDao;
	}

	private void populateSpeakers() {

		List<Speaker> listSpeaker = new ArrayList<Speaker>();
		
		// reading initial fields from json file

		try {

			for (Speaker item : listSpeaker) {
				getSpeakerDao().create(item);
			}

		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}

	}

	private void populateTopics() {

		List<Topic> listTopic = new ArrayList<Topic>();
		

		try {

			for (Topic item : listTopic) {
				getTopicDao().create(item);
			}

		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}

	}

}
