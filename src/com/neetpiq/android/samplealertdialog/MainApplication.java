package com.neetpiq.android.samplealertdialog;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

import com.neetpiq.android.samplealertdialog.data.DatabaseManager;
import com.neetpiq.android.samplealertdialog.util.ToastUtils;

public class MainApplication extends Application {
	
	protected static final String TAG = "MainApplication";
	
	public static String versionName;
	
	@Override
	public void onCreate() {
		
		versionName = getVersionName();
		
		// init database manager
		DatabaseManager.initInstance(getApplicationContext());
		
		super.onCreate();
		
	}
	
	@Override
	public void onLowMemory() {
		
		ToastUtils.showToast(getApplicationContext(), "onLowMemory");
		
		super.onLowMemory();
		
	}
	
	private String getVersionName() {
        
		PackageManager pm = getPackageManager();
        
		try {
            PackageInfo pi = pm.getPackageInfo(getPackageName(), 0);
            return pi.versionName == null ? "" : pi.versionName;
        } catch (NameNotFoundException e) {
            return "";
        }
    }

}
