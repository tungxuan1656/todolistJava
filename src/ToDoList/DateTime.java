package ToDoList;

import java.io.Serializable;
import java.util.StringTokenizer;

public class DateTime implements Serializable{

	private static final long serialVersionUID = 1L;
	private int day, month, year, hour, minute;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	void SetDate(String text) {
		if (text.equals("")) {
			day = 0;
			month = 0;
			year = 0;
		}
		else {
			StringTokenizer st = new StringTokenizer(text, "-./_ :*", false);
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
		}
	}
	
	void SetDate(DateTime dt) {
		day = dt.getDay();
		month = dt.getMonth();
		year = dt.getYear();
		hour = dt.getHour();
		minute = dt.getMinute();
	}
	
	void SetDateTime(String text, int h, int m) {
		this.SetDate(text);
		hour = h;
		minute = m;
	}
	
	boolean equalsDate(DateTime dt2) {
		if (day == dt2.getDay() && month == dt2.getMonth() && year == dt2.getYear()) return true;
		else return false;
	}
	
	boolean isSameDay(String text1, String text2) {
		DateTime dt1 = new DateTime();
		DateTime dt2 = new DateTime();
		dt1.SetDate(text1);
		dt2.SetDate(text2);
		return dt1.equalsDate(dt2);
	}
	
	boolean isTrueDate(DateTime dt) {
		
		if (year > dt.getYear()) return false;
		else if (year < dt.getYear()) return true;
		
		if (month > dt.getMonth()) return false;
		else if (month < dt.getMonth()) return true;
		
		if (day > dt.getDay()) return false;
		else if (day < dt.getDay()) return true;
			
		if (hour > dt.getHour()) return false;
		else if (hour < dt.getHour()) return true;
			
		if (minute > dt.getMinute()) return false;
		else if (minute < dt.getMinute()) return true;
		return true;
		
	}
}
