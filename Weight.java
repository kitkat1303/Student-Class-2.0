import java.io.Serializable;

/**
 * Weight class represents the weight of an individual in pounds and ounces.
 * for getter and setter avoid privacy leak!!!!
 * in to string to you use getPounds or just this.pounds??
 * @author katarinamcgaughy
 *
 */
public class Weight implements Cloneable, Comparable<Object>, Serializable {
	
	//pounds represents the weight in pounds
	private int pounds;
	//ounces represents the weight in ounces 
	private int ounces;
	
	/**
	 * getPounds 
	 * this returns the pounds 
	 * @return: pounds of weight 
	 */
	public int getPounds() {
		return this.pounds;
	}
	
	/**
	 * getOunces
	 * this function returns the ounces
	 * @return: ounces of weight 
	 */
	public int getOunces() {
		return this.ounces;
	}
	
	/**
	 * setPounds
	 * this function sets the pounds for weight 
	 * @param lbs: weight in lbs 
	 * PRE: lbs must be greater than or equal to 0
	 * POST: sets pounds
	 */
	public void setPounds(int lbs) {
		if (lbs >=0) {
			this.pounds = lbs;
		}
		else {
			System.out.println("Invalid weight in pounds entered. Pounds has not been changed.");
		}
	}
	
	/**
	 * setOunces 
	 * this function sets the ounces for weight 
	 * @param ounces : weight ounces
	 * PRE: ounces has to be greater than or equal to 0 and less 
	 * than 16
	 * POST: sets ounces
	 */
	public void setOunces(int ounces) {
		if (ounces >=0 && ounces<= 15) {
			this.ounces = ounces;
		}
		else {
			System.out.println("Invalid weight in ounces entered. Ounces has not been changed.");
		}
	}
	
	/**
	 * Weight
	 * @param lbs: pounds of young human 
	 * PRE: lbs has to be greater than or equal to 0 
	 * POST: initializes object 
	 */
	public Weight(int lbs) {
		
		setPounds(lbs);
		this.ounces = 0;
		
	}
	
	/**
	 * Weight
	 * @param lbs: pounds of young human
	 * @param ounces: ounces of young human 
	 * PRE: lbs has to be greater than or equal to 0 
	 * ounces has to be greater than or equal to 0 and less 
	 * than 16
	 * POST: initializes object 
	 */
	public Weight(int lbs, int ounces) {
		setPounds(lbs);
		setOunces(ounces);
	}

	/**
	 * Weight
	 * @param other: take in another weight object 
	 * PRE: other can't be null 
	 * POST: initializes object 
	 */
	public Weight(Weight other) {
		if (other!= null) {
			setPounds(other.getPounds());
			setOunces(other.getOunces()); 
		}
		else {
			System.out.println("Weight can't be null.");
		}
	}
	
	/**
	 * clone 
	 * this creates a clone of weight
	 * @return: clone of weight
	 */
	public Object clone()throws CloneNotSupportedException{  
	      return (Weight)super.clone();  
	      //or return new Date(this);
	   }
	
	/**
	 * compareTo
	 * this function compares two weights
	 * @return: 0 if they are equal, 1 if its greater than, and -1 if less than 
	 * object 
	 */
	public int compareTo(Object object) {
		 Weight that = (Weight)object;
		
		if (this.getWeight()== that.getWeight()) {
			return 0;
		}
		else if (this.getWeight()>that.getWeight()) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	/**
	 * getWeight 
	 * this function returns the total weight in pounds
	 * @return: total weight in pounds
	 */
	public double getWeight() {
		double totalWeight = 0;
		totalWeight = this.getPounds() + (this.getOunces()/16.0);
		return totalWeight;
		
	}
	
	/**
	 * setWeight
	 * this function takes in pounds and ounces and sets them
	 * @param pounds: takes in pounds and sets the weight 
	 * @param ounces: takes in ounces and sets the weight 
	 * PRE: pounds can't be negative, ounces has to be greater than or eqaul
	 * to 0 and less than 16
	 */
	public void setWeight(int pounds, int ounces) {
		setPounds(pounds);
		setOunces(ounces);
	}
	
	/**
	 * add
	 * this function takes in lbs and adds it to the weight
	 * @param lbs: lbs that should be added
	 * PRE: the total pounds can't be negative
	 * POST: weight with added pounds
	 */
	public void add(int lbs) { //could i just set pounds via setters???
		if (lbs + this.pounds<0) {
			System.out.println("Weight can't be negative. No changes"
					+ " have been made");
		}
		
		else {
			setPounds(this.pounds + lbs);
		}
	}
	
	/**
	 * add
	 * this function takes in lbs, ounces and adds it to the weight
	 * @param lbs: lbs that should be added
	 * @param ounces: ounces to be added
	 * PRE: the total pounds can't be negative and 
	 * the total ounces can't be negative or larger than 15
	 * POST: weight with added pounds and ounces
	 */
	public void add(int lbs, int ounces) {
		add(lbs);
		if (ounces + this.ounces > 15) {
			System.out.println("Ounces has to be less than or equal to 15");
		}
		else if (ounces + this.ounces < 0) {
			System.out.println("Ounces can't be negative.");
		}
		else {
			setOunces(this.ounces + ounces);
		}
	}
	
	/**
	 * add
	 * this function takes in another Weight 
	 * object and adds it to the weight
	 * @param other: other Weight object
	 * PRE: the total pounds can't be negative and 
	 * the total ounces can't be negative or larger than 15
	 * POST: weight with added pounds and ounces
	 */
	public void add(Weight other) {
		if (other == null) {
			System.out.println("Weight can't be null.");
		}
		else {
			add(other.getPounds(), other.getOunces());
		}
	}
	
	/**
	 * equals 
	 * this function compares two weight objects 
	 * @return: true if they are the same
	 */
	public boolean equals(Weight other) {
		if (other == null || other.getClass() != this.getClass()) {
			  return false;
		  }
		  
		  Weight that = (Weight)other;
		  
		  if (this.pounds != that.pounds) {
			  return false;
		  }
		  else if (this.ounces != that.ounces) {
			  return false;
		  }
		  
		  return true;
	}
	
	/**
	 * toString 
	 * @return: String representation of weight 
	 */
	public String toString() {
		return this.pounds + " lbs. " + this.ounces + " oz.";
	}

}
