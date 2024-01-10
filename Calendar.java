/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 0;
	static int month = 0;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	static int sunday = 0;
	static int yearToPrint = 0;
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    int debugDaysCounter = 0;
		yearToPrint = Integer.parseInt(args[0]);
	 	while (true) {

			 advance();
			 debugDaysCounter++;
			 dayOfWeek++;
			 dayOfMonth++;

			if (year == yearToPrint+1) {
				break;
			}
        }
	 	//// Write the necessary ending code here
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		if(dayOfWeek%7 == 0 && year == yearToPrint){
		 System.out.println(dayOfMonth%(nDaysInMonth(month+1,year))+1+"/"+(month+1)+"/"+year+" Sunday");}
		else if(yearToPrint == year)
		{
			System.out.println(dayOfMonth%(nDaysInMonth(month+1,year))+1+"/"+(month+1)+"/"+year);}
		if((nDaysInMonth(month+1,year))==dayOfMonth+1)
		 {
			 dayOfMonth = -1;
			 month++;
			 if (month == 12)
			 {
				 month = 0;
				 year++;
			 }
		 }
	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	public static boolean isLeapYear(int year) {
		if(year%100 != 0 && year%4 ==0)
		{
			return true;
		}
		else if(year%400 ==0)
		{
			return true;
		}
		return false;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	public static int nDaysInMonth(int month, int year) {
		switch (month){
			case 1,3,5,7,8,10,12:
				return 31;
			case 4,6,9,11:
				return 30;
			case 2:
				if(isLeapYear(year))
				{
					return 29;
				}
				return  28;
		}
		return 0;
	}
}