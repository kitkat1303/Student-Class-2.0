import java.io.Serializable;

/**
 * YoungHuman class is an abstract representation of a young human that holds
 * their full name, current weight, birth date, and the date of their last check
 * up.
 * 
 * @author Katarina McGaughy
 *
 */
public class YoungHuman implements Cloneable, Comparable<YoungHuman>, Serializable { 
	
	// currentWeight is the current weight of the young human
	private Weight currentWeight;

	// birthDate is the birth date of the young human
	private Date birthDate;

	// lastCheckUpDate is the date the last check up was
	private Date lastCheckUpDate;

	// lastName is a String representation of the last name
	private String lastName;

	// firstName is a String representation of the first name
	private String firstName;

	/**
	 * YoungHuman Constructor to initialize YoungHuman
	 * 
	 * @param weight:    Weight object with weight
	 * @param birthDate: Date object of birth date
	 * @param firstName: String first name
	 * @param lastName:  String last name PRE: first and last name must be between 3
	 *                   and 20 characters long POST: YoungHuman initialized with a
	 *                   null lastCheckUpDate
	 */
	public YoungHuman(Weight weight, Date birthDate, String firstName, String lastName) {
		setName(firstName, lastName);
		this.currentWeight = new Weight(weight);
		this.birthDate = new Date(birthDate);

	}

	/**
	 * YoungHuman Constructor to initialize YoungHumanYoung
	 * 
	 * @param toCopy: YoungHuman Object PRE: YoungHuman toCopy can't be null POST:
	 *                YoungHuman object initialized
	 * @throws CloneNotSupportedException 
	 */
	public YoungHuman(YoungHuman toCopy) throws CloneNotSupportedException {
		if (toCopy != null) {
			setName(toCopy.firstName, toCopy.lastName);
			this.birthDate = (Date)toCopy.getBirthDate().clone();
			this.lastCheckUpDate = (Date)toCopy.getLastCheckUpDate().clone(); 
			this.currentWeight = (Weight)toCopy.getWeight().clone();
		} else {
			System.out.println("YoungHuman can't be null.");
		}

	}
	
	/**
	 * clone 
	 * returns a cloned version of YoungHuman
	 */
	public YoungHuman clone()throws CloneNotSupportedException{ 
		return new YoungHuman(this);
	   }
	
	/**
	 * compareTo
	 * this function compares two YoungHumans
	 * @return: 0 if they are equal, 1 if its greater than, and -1 if less than 
	 * object 
	 */
	public int compareTo(YoungHuman that) {
		
		if (this.birthDate.compareTo(that.birthDate) == 0) {
			if (this.currentWeight.compareTo(that.getWeight()) > 0) {
				return 1;
			}
			else if (this.currentWeight.compareTo(that.getWeight()) < 0) {
				return -1;
			}
			else {
				return 0;
			}
		}
		else if (this.birthDate.compareTo(that.getBirthDate()) > 0) {
			return 1;
		}
		else {
			return -1;
		}		
	}

	/**
	 * getBirthDate
	 * 
	 * @return: a new Object Date with birth date
	 */
	public Date getBirthDate() {
		return new Date(this.birthDate);
	}

	/**
	 * getLastCheckUpDate
	 * 
	 * @return: a new Object Date with last check up date
	 */
	public Date getLastCheckUpDate() {
		return new Date(this.lastCheckUpDate);
	}

	/**
	 * getName
	 * 
	 * @return: first name and last name
	 */
	public String getName() {
		return this.firstName + " " + this.lastName;
	}

	/**
	 * hasHadCheckUp
	 * 
	 * @return: returns true if lastCheckUpDate does not equal null
	 */
	public boolean hasHadCheckUp() {
		return this.lastCheckUpDate != null;
	}

	/**
	 * isAfterBirthday this functions takes in a date and checks to see if the date
	 * entered is after the birthday
	 * 
	 * @param other: another date
	 * @return: true if the date entered is after the birth date
	 */
	public boolean isAfterBirthday(Date other) {
		if (other == null) {
			return false;
		} else if (this.birthDate.getYear() < other.getYear()) {
			return true;
		} else if (this.birthDate.getYear() == other.getYear()) {
			if (this.birthDate.getMonth() < other.getMonth()) {
				return true;
			} else if (this.birthDate.getMonth() == other.getMonth()) {
				return this.birthDate.getDay() < other.getDay();
				// assuming it can't be the same as birth date
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * isBeforeCurrent this functions takes in a date to check if it is before the
	 * current date
	 * 
	 * @param other: another date
	 * @return: returns true if the date entered is before the current date
	 */
	public boolean isBeforeCurrent(Date other) {
		if (other == null) {
			return false;
		} else if (other.getYear() < 2021) {
			return true;
		} else if (other.getYear() == 7) {
			if (other.getMonth() < 7) {
				return true;
			} else if (other.getMonth() == 20) {
				return other.getDay() < 20;
				// assuming it can't be the same as current date
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * setCheckUp this functions sets the check up date if it is after the birth
	 * date and before the current date
	 * 
	 * @param dateOfCheckUp: Date object of check up date PRE: check up date must be
	 *                       after birth and before current date
	 */
	public void setCheckUp(Date dateOfCheckUp) {
		if (this.isAfterBirthday(dateOfCheckUp) && this.isBeforeCurrent(dateOfCheckUp)) {
				this.lastCheckUpDate = new Date(dateOfCheckUp);
		} 
		else {
			System.out.println("Invalid checkup date entered."
					+ " checkup date can't be null and must be after the birth date and "
					+ "before the current date. No changes have been made.");
		}
	}

	/**
	 * unsetCheckUpDate this functions set the lastCheckUpDate to null
	 */
	public void unsetCheckUpDate() {
		this.lastCheckUpDate = null;
	}

	/**
	 * setBirthDate this functions sets the birth date
	 * 
	 * @param birthDate: takes in Date object of birth date PRE: birth date must be
	 *                   before or on current date (7/20/2021)
	 */
	public void setBirthDate(Date birthDate) {
		if (birthDate != null) {

			if (isBeforeCurrent(birthDate)) {
				this.birthDate = birthDate;
			}
		} else {
			System.out.println(
					"Invalid birthdate entered. Must be before " + 
			"the current day (7/20/2021) and can't be null.");
			System.out.println("Setting to default of (1/1/2014).");
			this.birthDate = new Date(1, 1, 2014);
		}
	}

	/**
	 * setWeight this functions sets the weight
	 * 
	 * @param amount: Weight object with weight
	 */
	public void setWeight(Weight amount) {
		if (amount != null) {
			this.currentWeight = new Weight(amount);
		} else {
			System.out.println("Weight can't be set to null.");
		}
	}

	/**
	 * getWeight
	 * 
	 * @return: returns a new Object of current weight
	 */
	public Weight getWeight() {
		return new Weight(this.currentWeight);
	}

	/**
	 * setName this function sets the first and last name
	 * 
	 * @param first: String representation of first name
	 * @param last:  String representation of last name PRE: first and last name
	 *               must be between 3 and 20 characters long
	 */
	public void setName(String first, String last) {
		if (first.length() >= 3 && first.length() <= 20) {
			this.firstName = first;
		} else {
			System.out.println("Name must be between 3 and 20 characters long.");
			System.out.println("Setting to default name (Default first).");
			this.firstName = "Default first";
		}

		if (last.length() >= 3 && last.length() <= 20) {
			this.lastName = last;
		} else {
			System.out.println("Name must be between 3 and 20 characters long.");
			System.out.println("Setting to default name (Default last).");
			this.lastName = "Default last";
		}

	}

	/**
	 * toString
	 * 
	 * @return: String representation of YoungHuman
	 */
	public String toString() {
		if (hasHadCheckUp()) {
			return this.firstName + " " + this.lastName + ", " + this.getWeight() + ", birth date: "
					+ this.getBirthDate().toString() + ", last check-up: " 
					+ this.getLastCheckUpDate().toString();
		}
		else {
			return this.firstName + " " + this.lastName + ", " + this.getWeight().toString() + ", birth " + "date: "
					+ this.getBirthDate().toString() + ", has not had a check-up.";
		}
	}

	/**
	 * equals
	 * 
	 * @param toCompare: other YoungHuman
	 * @return: true if they have the same values
	 */
	public boolean equals(YoungHuman other) {
		if (other == null || other.getClass() != this.getClass()) {
			  return false;
		  }
		  
		  YoungHuman that = (YoungHuman)other;
		  
		  if (!this.getName().equals(that.getName())) {
			  return false;
		  }
		  else if (!this.getWeight().equals(that.getWeight())) {
			  return false;
		  }
		  else if(!this.getBirthDate().equals(that.getBirthDate())) {
			  return false;
		  }
		  else if (!this.getLastCheckUpDate().equals(that.getLastCheckUpDate())) {
			  return false;
		  }
		  
		  return true;
	}

}
