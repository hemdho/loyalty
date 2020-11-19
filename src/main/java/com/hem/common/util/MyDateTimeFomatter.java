package com.hem.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class MyDateTimeFomatter {

   private String currentDateFormat;
   
   
   private SimpleDateFormat formatter;	
   
   private SimpleDateFormat dateTimeFormatter;
    
    public MyDateTimeFomatter() {
    	
    }
    public MyDateTimeFomatter(String currentDateFormat,String currentDateTimeFormat) {
    	this.currentDateFormat=currentDateFormat;
    	formatter=new SimpleDateFormat(currentDateFormat);
    	dateTimeFormatter=new SimpleDateFormat(currentDateTimeFormat);
    }
   
       
    
   public SimpleDateFormat getDateFormatter() {
	   return formatter;
   }
   public SimpleDateFormat getDateTimeFormatter() {
	   return dateTimeFormatter;
   }
   public Date getDate(String date) throws ParseException {
	   return formatter.parse(date);
   }
   public String getDate(Date date) {
	   return formatter.format(date);
   }
   public Date getDateWithTime(String date) throws ParseException{
	   return dateTimeFormatter.parse(date);
   }
   public String getDateTimeWithTime(Date date) {
	   return dateTimeFormatter.format(date);
   }
	
}
