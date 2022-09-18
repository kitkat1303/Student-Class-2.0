/**
 * Driver
 * @author katarinamcgaughy
 *
 */
public class Driver {
	
	public static void main(String[] args) {
		
		try {
		System.out.println("Testing Date Clone: ");
		Date d1 = new Date(3,13,2015);
		System.out.println("Should print 3/13/2015: " + d1.clone());
		
		}
		catch (Exception e){
			e.getMessage();
		}
		System.out.println();
		
		System.out.println("Testing Date compareTo()");
		Date d2 = new Date(3,14,2015); 
		Date d3 = new Date(3,17,2015); 
		Date d4 = new Date(3,14,2015);
		test(1, d3, d2);
		test(0, d2, d4);
		test(-1, d2, d3);
		System.out.println();
		
		try {
			System.out.println("Testing Weight Clone: ");
			Weight w1 = new Weight(8);
			System.out.println("Should print 8lbs. 0oz.: " + w1.clone());
			
			}
			catch (Exception e){
				e.getMessage();
			}
			System.out.println();
			
			System.out.println("Testing Weight compareTo()");
			Weight w2 = new Weight(5);
			Weight w3 = new Weight(5);
			Weight w4 = new Weight(9);
			test(1, w4, w3);
			test(0, w2, w3);
			test(-1, w2, w4);
			System.out.println();
		
			try {
			System.out.println("Testing Younghuman Clone: ");
			YoungHuman y1 = new YoungHuman(w4, d3, "Mark" , "McDonald");
			System.out.println("Should print Mark McDonald, 9 lbs. 0 oz., "
					+ "birth date: 3/17/2015, has not had a check-up.: " + y1.clone());
				
				}
				catch (Exception e){
					e.getMessage();
				}
			System.out.println();
			
			System.out.println("Testing YoungHuman compareTo():");
			YoungHuman y1 = new YoungHuman(w4, d3, "Mark" , "McDonald");
			YoungHuman y2 = new YoungHuman(w4, d3, "Mark" , "McDonald");
			//y3 has smaller weight and smaller date.. d2
			YoungHuman y3 = new YoungHuman(w2, d2, "Cylvia" , "King");
			 test(1, y1, y3);
			 test(0, y1, y2);
			 test(-1, y3, y1);
			 System.out.println();
			
			System.out.println("Testing ChildCohort: ");
			ChildCohort c1 = new ChildCohort();
			c1.insert(y3, 0);
			c1.insert(y1, 1);
			c1.insert(y2, 0);
			System.out.println(c1.toString());
			System.out.println("Should print 3: " + c1.size());
			System.out.println("Should print: Cylvia King, 5 lbs. 0 oz., birth date: 3/14/2015, "
					+ "has not had a check-up. " + c1.oldest());
			System.out.println("Should print: Mark McDonald, 9 lbs. 0 oz., birth date: 3/17/2015, "
					+ "has not had a check-up. " + c1.youngest());
	
	}
	
	/**
	 * test
	 * this function runs the compareTo method and tests if it works correctly
	 * @param <T>: generic 
	 * @param expectedResult: the result excpected
	 * @param example1: the first object
	 * @param example2: the second object
	 */
	public static <T extends Comparable> void test(int expectedResult, T example1, T example2) {
		if (example1.compareTo(example2) == expectedResult) {
          System.out.println("Test Succeeded: " + example1 + ", " + example2);
        } else {
          System.out.println("Test Failed: " + example1 + ", " + example2);
        }
	}

}
