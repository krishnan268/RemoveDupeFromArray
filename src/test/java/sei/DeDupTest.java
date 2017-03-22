package test.java.sei;

import static org.junit.Assert.assertEquals;
import main.java.sei.DeDup;

import org.junit.BeforeClass;
import org.junit.Test;

public class DeDupTest {

	public static int[] arrayWithOutDupe = {1,2,3}; 
	public static int[] arrayWithDupe;
	
	@BeforeClass
    public static void setUpBaseClass() {
		int arraySize = arrayWithOutDupe.length * 3;
		arrayWithDupe = new int[arraySize];
		int i = 0;
		while(i < arraySize) {
			for (int num : arrayWithOutDupe) {
				arrayWithDupe[i] = num;
				i++;
		    }
		}
	}
	
	@Test
    public void testRemoveDupeAndRetainOriginalOrder() {
		DeDup deDup = new DeDup(arrayWithDupe);
		int[] testResult = deDup.removeDupeAndRetainOriginalOrder();
        assertEquals(arrayWithOutDupe.length, testResult.length);
    }
	
	@Test
    public void testRemoveDupeUsingSet() {
		DeDup deDup = new DeDup(arrayWithDupe);
		int[] testResult = deDup.removeDupeUsingSet();
        assertEquals(arrayWithOutDupe.length, testResult.length);
    }
	
	@Test
    public void testRemoveDupeWithInArray() {
		DeDup deDup = new DeDup(arrayWithDupe);
		int[] testResult = deDup.removeDupeWithInArray();
        assertEquals(arrayWithOutDupe.length, testResult.length);
    }
	
}
