package com.smbc.lad.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Saravanan T
 * @since April 2022
 * 
 * This is an utility class used to generalized functions like for convert date to string etc.
 *
 */
public class LADUtils {

	public static String formatDatetoString(Date inputDate) {
	
			String dateStr = "";
			
			if(inputDate != null) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				dateStr = dateFormat.format(inputDate);
			}
			
			return dateStr;
	}
	
	public static String formatDatetoTimestamp(Date inputDate) {
		
		String dateStr = "";
		
		if(inputDate != null) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			dateStr = dateFormat.format(inputDate);
		}
		
		return dateStr;
}
	
	public static Date formatStringtoDate(String inputDate) throws Exception {		
		//String dateStr = "";
		Date formattedDate = null;
		
		if(inputDate != null && !inputDate.trim().isEmpty()) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			formattedDate = dateFormat.parse(inputDate);
		}
		
		return formattedDate;
	}
	
	
	public static boolean checkNullorEmpty(String inputStr) {
		boolean flag = true;
		if(inputStr != null && !inputStr.trim().isEmpty()) {
			flag = false;
		}
		return flag;
	}
	
	public static String setNullIfEmpty(String inputStr) {
		String output = null;
		if(inputStr != null && !inputStr.trim().isEmpty()) {
			output = inputStr;
		}
		return output;
	}
	
	public static String convertDoubleToString(double inputVal) {
		
		String inputStr = "";
		
		if(inputVal > 0 ) {
			inputStr = Double.valueOf(inputVal).toString();
		}
		
		return inputStr;
	}
	
	public static int formatStringtoInt(String inputVal) {		
		int val = 0;
		
		try {
			if(inputVal != null && !inputVal.trim().isEmpty()) {
				val = Integer.valueOf(inputVal).intValue();
			}
		} catch (Exception ex) {}
		
		return val;
	}
	
	public static double formatStringtoDouble(String inputVal) {		
		double val = 0;
		
		try {
			if(inputVal != null && !inputVal.trim().isEmpty()) {
				val = Double.valueOf(inputVal).intValue();
			}
		} catch (Exception ex) {}
		
		return val;
	}
	
}
