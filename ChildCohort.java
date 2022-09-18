import java.util.Arrays;

public class ChildCohort extends ArrayList<YoungHuman>{
	
	/*
	 * ChildCohort 
	 * Constructor that initializes ArrayList childCohort
	 */
	public ChildCohort() {
		super();
	}
	
	//need another method that could be useful...
	
	/**
	 * insert This function adds an object to the index entered
	 * 
	 * @param o:     some type of Object
	 * @param index: must be positive and less than or equal to the ArrayList length
	 *               PRE: ArrayList without Object entered POST: Object Added to the
	 *               ArrayList after ArrayList has been resized and elements moved
	 */
	@SuppressWarnings("unchecked")
	public void insert(YoungHuman o, int index) {
		//dont think i need this????
		if (o instanceof YoungHuman) {
			super.insert(o, index);
		}
		else {
			System.out.println("Can only add a YoungHuman to list.");
		}
	}
	
	/**
	 * printList 
	 * this function prints the list of children
	 */
	public void printList() {
		System.out.println(toString());
	}
	
	public void sortArray() {
		Arrays.sort(super.arrayList);
	}
	
	/**
	 * oldest
	 * @return: the oldest child in the cohort
	 */
	public YoungHuman oldest() {
		sortArray();
		if (super.size() >= 1) {
		return super.get(0);
		}
		else {
			System.out.println("No children in cohort.");
			return null;
		}
	}
	
	/**
	 * youngest
	 * @return: returns the youngest child in the cohort
	 */
	public YoungHuman youngest() {
		sortArray();
		if (super.size() >= 1) {
			return super.get(size()-1);
			}
			else {
				System.out.println("No children in cohort.");
				return null;
			}
	}
		
}
