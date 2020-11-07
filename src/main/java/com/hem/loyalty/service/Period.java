package com.hem.loyalty.service;

public class Period {
   private int number;
   private PeriodTypes periodTypes;
   
   /****
    * 
    * @param period 
    * period may be 1 day , 1 year, 2 days etc.
    */
   public Period(String period) {
	   String str[]= period.split(" ");
	   
	   this.number=Integer.valueOf(str[0]);
	   this.periodTypes= PeriodTypes.valueOf(str[1]);
   }
   public Period() {
	   
   }
   
   public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public PeriodTypes getPeriodTypes() {
	return periodTypes;
}
public void setPeriodTypes(PeriodTypes periodTypes) {
	this.periodTypes = periodTypes;
}
public static int getDays(Period period) {
	   
	   int numDays=0;
	   switch(period.periodTypes) {
	   			case Days:
	   			case Day:
	   				    numDays=period.number;
	   				    break;
	   			case Month:
	   			case Months:
	   				    numDays= (30)*period.number;
	   				    break;
	   			case Week: 
	   			case Weeks:
	   				   numDays= 7 * period.number;
	   				   break;
	   			case Year:
	   			case Years:
	   				   numDays=365 * period.number;
	   				   break;
	   			 default:
	   				    
	   } 
	   return numDays;
   }
   
}
