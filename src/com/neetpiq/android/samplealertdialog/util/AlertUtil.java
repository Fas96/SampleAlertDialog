package com.neetpiq.android.samplealertdialog.util;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertUtil {
	
	/**
     * Show Alert Dialog
     * @param context
     * @param titleId
     * @param messageId
     */
    public static void showAlert(Context context, int titleId, int messageId) {

    	showAlert(context, context.getString(titleId), context.getString(messageId));

    }

    /**
     * Show Alert Dialog
     * @param context
     * @param titleId
     * @param message
     */
    public static void showAlert(Context context, int titleId, String message) {

    	showAlert(context, context.getString(titleId), message);
    	
    }
    
    /**
     * Show Alert Dialog
     * @param context
     * @param title
     * @param message
     */
    public static void showAlert(Context context, String title, String message) {
        Dialog dlg = new AlertDialog.Builder(context)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle(title)
            .setPositiveButton(android.R.string.ok, null)
            .setMessage(message)
            .create();
        
        dlg.show();
    }
    
    /**
     * Show Alert Dialog
     * @param context
     * @param titleId
     * @param messageId
     * @param positiveButtontxt
     * @param positiveListener
     * @param negativeButtontxt
     * @param negativeListener
     */
    public static void showAlert(Context context, int titleId, int messageId,
            CharSequence positiveButtontxt, DialogInterface.OnClickListener positiveListener,
            CharSequence negativeButtontxt, DialogInterface.OnClickListener negativeListener) {
        
    	showAlert(context,
    			context.getString(titleId),
    			context.getString(messageId),
    			positiveButtontxt, positiveListener,
    			negativeButtontxt, negativeListener);
    	
    }

    /**
     * Show Alert Dialog
     * @param context
     * @param title
     * @param message
     * @param positiveButtontxt
     * @param positiveListener
     * @param negativeButtontxt
     * @param negativeListener
     */
    public static void showAlert(Context context, String title, String message,
            CharSequence positiveButtontxt, DialogInterface.OnClickListener positiveListener,
            CharSequence negativeButtontxt, DialogInterface.OnClickListener negativeListener) {
        Dialog dlg = new AlertDialog.Builder(context)
            //.setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle(title)
            .setPositiveButton(positiveButtontxt, positiveListener)
            .setNegativeButton(negativeButtontxt, negativeListener)
            .setMessage(message)
            .setCancelable(false)
            .create();

        dlg.show();
    }
    
    /**
     * Show Alert Dialog
     * @param context
     * @param title
     * @param message
     * @param positiveButtontxt
     * @param positiveListener
     * @param negativeButtontxt
     * @param negativeListener
     * @param neutralButtontxt
     * @param neutralListener
     */
    public static void showAlert(Context context, String title, String message,
            CharSequence positiveButtontxt, DialogInterface.OnClickListener positiveListener,
            CharSequence negativeButtontxt, DialogInterface.OnClickListener negativeListener,
            CharSequence neutralButtontxt, DialogInterface.OnClickListener neutralListener) {
        Dialog dlg = new AlertDialog.Builder(context)
            //.setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle(title)
            .setPositiveButton(positiveButtontxt, positiveListener)
            .setNegativeButton(negativeButtontxt, negativeListener)
            .setNeutralButton(neutralButtontxt, neutralListener)
            .setMessage(message)
            .setCancelable(false)
            .create();

        dlg.show();
    }

    /**
     * Show Alert Dialog
     * @param context
     * @param title
     * @param message
     * @param positiveButtontxt
     * @param positiveListener
     */
    public static void showAlert(Context context, String title, String message,
            CharSequence positiveButtontxt, DialogInterface.OnClickListener positiveListener) {
        Dialog dlg = new AlertDialog.Builder(context)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .setTitle(title)
            .setPositiveButton(positiveButtontxt, positiveListener)
            .setMessage(message)
            .setCancelable(false)
            .create();

        dlg.show();
    }

}
