package main.java.sei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeDup {

    public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

	public static void main(String[] args) {
		DeDup deDup = new DeDup();
		
		int[] result = deDup.removeDupeAndRetainOriginalOrder();
		printList(result);
		
		result = deDup.removeDupeUsingSet();
		printList(result);
		
		result = deDup.removeDupeWithInArray();
		printList(result);
	}
	
	/**
	 * Removing duplicated from array using list to maintain the order from the original array
	 * @return array without dupe values
	 */
	private int[] removeDupeAndRetainOriginalOrder() {
		List<Integer> listWithOutDupe = new ArrayList<Integer>();

		for(int i=0; i<randomIntegers.length; i++) {
	        boolean match = false;
	        for(int j=0; j<listWithOutDupe.size(); j++) {
	            if(listWithOutDupe.get(j) == randomIntegers[i])
	                match = true;
	        }
	        if(!match)
	            listWithOutDupe.add(randomIntegers[i]);
	    }
		int[] arrayWithOutDupe = new int[listWithOutDupe.size()];
		for(int i = 0; i < listWithOutDupe.size(); i++) {
			arrayWithOutDupe[i] = listWithOutDupe.get(i);
		}
	    return arrayWithOutDupe;
	}
	
	/**
	 * Removing duplicated from array using set
	 * @return array without dupe values
	 */
	private int[] removeDupeUsingSet() {
		Set<Integer> numSet = new HashSet<Integer>();		
		for (int num : randomIntegers) {
			if (!numSet.contains(num)) {
				numSet.add(num);
			}
		}
		int[] arrayWithOutDupe = new int[numSet.size()];
		int count = 0;
		for (Integer num : numSet) {
			arrayWithOutDupe[count] = num;
			count++;
		}
		return arrayWithOutDupe;
	}
	
	/**
	 * Removing duplicated from array within the array by switching values 
	 * @return array without dupe values
	 */
	private int[] removeDupeWithInArray() {
		int[] arrayWithDupe = randomIntegers;
		int length = arrayWithDupe.length;         
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
            	if(arrayWithDupe[i] == arrayWithDupe[j]) {
                    arrayWithDupe[j] = arrayWithDupe[length-1];
                    length--;
                    j--;
                }
            }
        }
        int[] arrayWithOutDupe = Arrays.copyOf(arrayWithDupe, length);
		return arrayWithOutDupe;
	}
	
	private static void printList(int[] result) {
		int lastValue = result[result.length-1];
		for (int b : result) {
			System.out.print(b);
			if (lastValue != b)
				System.out.print(",");
			else
				System.out.println();
		}
	}
}
