import java.io.Serializable;

/**
 * Date class represents a date in the month/day/year format.
 * @author katarinamcgaughy
 *
 */
public class Date implements Cloneable, Comparable<Date>, Serializable { //what type of argument??
	
	//day represents the day of the month
	private int day;
	//month represents the month of the year
	private int month;
	//year represents year
	private int year;
	
	/**
	 * getDay
	 * @return : day
	 */
	public int getDay() {
		return this.day;
	}
	
	/**
	 * getMonth
	 * @return: month
	 */
	public int getMonth() {
		return this.month;
	}
	
	/**
	 * getYear
	 * @return: year
	 */
	public int getYear() {
		return this.year;
	}
	
	/**
	 * setMonth
	 * function that sets the month
	 * @param m : month
	 * PRE: month must be between 1 and 12 or else set
	 * to default of 1
	 */
	public void setMonth(int m) {
		if (m>=1 && m<=12) {
			this.month = m;
		}
		else {
			System.out.println("Month must be between 1 and 12 inclusive. Setting to default of 1.");
			this.month = 1;
		}
	}
	
	/**
	 * setDay
	 * function that sets the day
	 * @param d : day
	 * PRE: day must be between 1 and 31 or else set to
	 * default of 1
	 */
	public void setDay(int d) {
		if (d>=1 && d<=31) {
			this.day = d;
		}
		else {
			System.out.println("Day must be between 1 and 31 inclusive. Setting to default of 1.");
			this.day = 1;
		}
	}
	
	/**
	 * setYear
	 * function that sets the year
	 * @param y : year
	 * PRE: year must be between 2014 and 2024 or else set to
	 * default of 2014
	 */
	public void setYear(int y) {
		if (y>=2014 && y<= 2024) {
			this.year = y;
		}
		else {
			System.out.println("Year must be between 2014 and 2024."
					+ " Setting to default of 2014.");
			this.year = 2014;
		}
	}
	
	/**
	 * Date 
	 * Constructor that initializes a date
	 * @param m : month
	 * @param d : day 
	 * @param y : year
	 */
	public Date(int m, int d, int y) {
		setMonth(m);
		setDay(d);
		setYear(y);
	}
	
	/**
	 * Date 
	 * Constructor that initializes a date
	 * @param other: another Date object
	 */
	public Date(Date other) {
		if (other != null) {
			setMonth(other.getMonth());
			setDay(other.getDay());
			setYear(other.getYear());
		} 
		
	}
	
	/**
	 * clone 
	 * this creates a clone of date
	 * @return: clone of date
	 */
	public Object clone()throws CloneNotSupportedException{  
	      return new Date(this);
	   }
	
	/**
	 * compareTo
	 * this function compares two dates
	 * @return: 0 if they are equal, 1 if its greater than, and -1 if less than 
	 * object 
	 */
	public int compareTo(Date that) {
		if (this.equals(that)) {
			return 0;
		}
		//that is before this
		else if (isBeforeDate(that)) {
			return 1;
		}
		else if (!isBeforeDate(that)){
			return -1;
		}
		
		return 0;
	}
	
	/**
	 * isBeforeCurrent this functions takes in a date to check if it is before the
	 * current date
	 * 
	 * @param other: another date
	 * @return: returns true if the date entered is before the current date
	 */
	public boolean isBeforeDate(Date other) {
		if (other == null) {
			return false;
			//if other year is less than the date is before
		} else if (other.getYear() < this.getYear()) {
			return true;
			//if same year and month is less then then other is before 
		} else if (other.getYear() == this.getYear()) {
			if (other.getMonth() < this.getMonth()) {
				return true;
				//if same month and day is less than then other is before...
			} else if (other.getMonth() == this.getMonth()) {
					return other.getDay() < this.getDay();
				// assuming it can't be the same as current date
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	//is is before date is true... then the date is younger but the child is older...
	
	/**
	 * toString 
	 * @return : String representation of date 
	 */
	public String toString() {
		return this.month + "/" + this.day + "/" + this.year;
	}
	
	/**
	 * equals 
	 * @return: true if the objects are equal 
	 */
	public boolean equals(Object other) {
		  if (other == null || other.getClass() != this.getClass()) {
			  return false;
		  }
		  
		  Date that = (Date)other;
		  
		  if (this.month != that.month) {
			  return false;
		  }
		  else if (this.day != that.day) {
			  return false;
		  }
		  else if (this.year != that.year) {
			  return false;
		  }
		  
		  return true;

	}

}
