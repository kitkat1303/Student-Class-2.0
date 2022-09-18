/**
 * This class is meant to represent an arrayList.
 * 
 * @author Katarina McGaughy
 *
 */
public class ArrayList<T> {

	//ArayList is an array of Objects 
	protected T [] arrayList;
	//count keeps track of how many Objects are in the array
	private int count = 0;
	
	/**
	 * getCount
	 * @return: returns the number of elements in the array
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * arrayList Constructor that initializes the arrayList
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		arrayList = (T[]) new Object[0];
	}

	/**
	 * insert This function adds an object to the index entered
	 * 
	 * @param o:     some type of Object
	 * @param index: must be positive and less than or equal to the arrayList length
	 *               PRE: arrayList without Object entered POST: Object Added to the
	 *               arrayList after arrayList has been resized and elements moved
	 */
	public void insert(T o, int index) {
		resizeArray();
		if (index >= 0 && index < this.arrayList.length) {
			shiftElementsAdded(index);
			arrayList[index] = o;
			this.count++;
		} 
		else {
			System.out.println("Invalid index entered. Index must be positive and less then or equal "
					+ "to the number of elements in the array.");
		}
	}

	/**
	 * shiftElementsAdded This function shifts the elements back by 1 starting from
	 * where the new element was added
	 * 
	 * @param index: index of element added PRE: none POST: reorganized elements in
	 *               arrayList
	 */
	public void shiftElementsAdded(int index) {
		for (int i = (this.arrayList.length - 1); i > index; i--) {
			arrayList[i] = arrayList[i - 1];
		}
	}


	/**
	 * resizeArray This function increases the size of the arrayList by 1 PRE: none
	 * POST: increased size of arrayList by 1
	 */
	@SuppressWarnings("unchecked")
	public void resizeArray() {
		Object[] biggerArray = new Object[this.arrayList.length + 1];
		for (int i = 0; i < this.arrayList.length; i++) {
			biggerArray[i] = arrayList[i];
		}
		this.arrayList = (T[]) biggerArray;
	}

	/**
	 * remove This function removes an object at the index entered
	 * 
	 * @param index: must be positive and less than or equal to the arrayList length
	 *               PRE: arrayList with Object at index entered POST: arrayList
	 *               without Object at index entered and resized with elements moved
	 */
	public T remove(int index) {
		T elementRemoved = null;
		if (index >=0 && index < this.arrayList.length-1) {
			elementRemoved = arrayList[index];
			arrayList[index] = null;
			shiftElementsRemoved(index);
			decreaseArray();
			this.count--;
			System.out.println(elementRemoved + " succesfully removed.");
			
		} else if (index == this.arrayList.length-1){
			elementRemoved = arrayList[index];
			arrayList[index] = null;
			decreaseArray();
			this.count--;
			System.out.println(elementRemoved + " succesfully removed.");
		}
		
		else {
			System.out.println("Invalid index entered. Index must be positive and less then or equal "
					+ "to the number of elements in the array.");
		}
		return elementRemoved;

	}

	/**
	 * decreaseArray This function decreases the size of the arrayList by 1 PRE:
	 * none POST: decreased size of arrayList by 1
	 */
	@SuppressWarnings("unchecked")
	public void decreaseArray() {
		Object[] smallerArray = new Object[this.arrayList.length - 1];
		for (int i = 0; i < smallerArray.length; i++) {
			smallerArray[i] = arrayList[i];
		}
		this.arrayList = (T[]) smallerArray;
	}

	/**
	 * shiftElementsRemoved This function shifts the elements forward by 1 where the
	 * element was removed
	 * 
	 * @param index: index of element removed PRE: none POST: reorganized elements
	 *               in arrayList
	 
	*/
	@SuppressWarnings("unchecked")
	public void shiftElementsRemoved(int index) {
		Object [] temp = new Object[this.count];
		 for (int i = 0; i < this.count; i++) {
			 for(int j = i; j < this.count - 1; j++){
				 temp[j] = arrayList[j+1];
			 }
		 }
		 arrayList = (T[]) temp;
	}
	
	/**
	 * size
	 * 
	 * @return: the number of elements in the array
	 */
	public int size() {
		return this.count;
	}

	/**
	 * toString
	 * 
	 * @return: a String representation of each element in the arrayList
	 */
	public String toString() {
		String array = "";
		for (int i = 0; i < this.arrayList.length; i++) {
			if (arrayList[i] != null) {
				array = array + " [" + arrayList[i].toString() + "] ";
			}
		}
		return array;
	}

	/**
	 * isEmpty
	 * 
	 * @return: true if the number of elements in the array is 0
	 */
	public boolean isEmpty() {
		//return this.arrayList.length == 0;
		return this.count == 0;
	}

	/**
	 * indexOf This function takes in an Object and returns the index where the
	 * Object is located in the array
	 * 
	 * @param o: Object user would like to find in the array
	 * @return: index where Object is located
	 */
	public int indexOf(T o) {
		if (o == null) {
			System.out.println("Object can't be null.");
		} else {
			for (int i = 0; i < this.arrayList.length; i++) {
				if (arrayList[i].equals(o)) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	 * equals this function compares two arrayLists
	 * 
	 * @return : true if they are the same and false if not
	 */
	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}

		@SuppressWarnings("unchecked")
		ArrayList<T> that = (ArrayList<T>) other;

		if (this.count != that.count) {
			return false;
		}
		for (int i = 0; i < this.arrayList.length; i++) {

			if (!(this.arrayList[i].equals(that.arrayList[i]))) {
				return false;
			}
		}

		return true;

	}

	/**
	 * get This function takes in an index and returns the Object located at that
	 * index
	 * 
	 * @param index: index of array
	 * @return: Object located at the index entered
	 */
	public T get(int index) {
		if (index >= 0 && index < size()) {
			return arrayList[index];
		} else {
			System.out.println("Invalid index entered. Index must be positive and less then or equal "
					+ "to the number of elements in the array.");
		}
		return null;
	}

}
