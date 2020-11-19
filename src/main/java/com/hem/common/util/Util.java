package com.hem.common.util;

import org.springframework.beans.factory.annotation.Autowired;

public class Util {
    
	private static MyDateTimeFomatter dateTimeFormatter;
    
	public static MyDateTimeFomatter getMyDateTimeFormatter () {
		if(dateTimeFormatter==null) {
			
		}
		return dateTimeFormatter;
	}
	public static void setDateTimeFormatter( MyDateTimeFomatter dateTimeFormatter_) {
		dateTimeFormatter=dateTimeFormatter_;
	}

	
}
