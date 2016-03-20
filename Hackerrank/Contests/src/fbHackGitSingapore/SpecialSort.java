package fbHackGitSingapore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SpecialSort {

    static void sort(int[] arr) {
    	Map<Integer, Integer> numberToFrequencyMap = new HashMap<Integer, Integer>();
    	List<Integer> uniqueNumbers = new ArrayList<Integer>();
    	for (int num:arr) {
    		if (numberToFrequencyMap.containsKey(num)) {
    			int frequency = numberToFrequencyMap.get(num);
    			numberToFrequencyMap.put(num, frequency + 1);
    		} else {
    			numberToFrequencyMap.put(num, 1);
    			uniqueNumbers.add(num);
    		}
    	}
    	
    	Map<Integer, List<Integer>> frequencyToNumberMap = new HashMap<Integer, List<Integer>>();
    	List<Integer> frequencies = new ArrayList<Integer>();
    	for (int num:uniqueNumbers) {
    		int freq = numberToFrequencyMap.get(num);
    		if (frequencyToNumberMap.containsKey(freq)) {
    			frequencyToNumberMap.get(freq).add(num);
    		} else {
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(num);
    			frequencyToNumberMap.put(freq, list);
    			frequencies.add(freq);
    		}
    	}
    	
    	numberToFrequencyMap = null;
    	uniqueNumbers = null;
    	Collections.sort(frequencies);
    	for (int frequency:frequencies) {
    		List<Integer> numbersWithSameFrequency = frequencyToNumberMap.get(frequency);
    		Collections.sort(numbersWithSameFrequency);
    		for (int number:numbersWithSameFrequency) {
    			for (int i=0; i<frequency; i++) {
    				System.out.println(number);
    			}
    		}
    	}
    }
	
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }
        sort(_arr);
        in.close();
    }

}
