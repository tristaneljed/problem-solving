/*
 * Alien Numbers
 * https://code.google.com/codejam/contest/dashboard?c=32003#s=p0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class AlienNumbers {

	private static int numOfTestCases;
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		if (args.length != 2) {
			System.out.println("Usage: java AlienNumbers <input-file> <output-file>");
			System.exit(-1);
		}
		
		Scanner s = new Scanner(new File(args[0]));
		PrintWriter outputFile = new PrintWriter(args[1], "UTF-8");
		char [] alienNumber;
		char [] alienLanguage;
		String targetNumber = "";
		char [] targetLanguage;
		
		numOfTestCases = s.nextInt();
		for (int i=1; i<numOfTestCases+1; i++) {
			alienNumber = s.next().toCharArray();
			alienLanguage = s.next().toCharArray();
			targetLanguage = s.next().toCharArray();
			targetNumber = numberConversion(alienNumber, alienLanguage, targetLanguage);
			outputFile.println("Case #" + i + ": " + targetNumber);
		}
		
		outputFile.close();
		s.close();
	}

	private static String numberConversion(char[] alienNumber,
			char[] alienLanguage, char[] targetLanguage) {
		Map<Character, Integer> alienMap = new HashMap<>();
		Map<Character, Integer> targetMap = new HashMap<>();
		
		charToIndexMapping(alienLanguage, alienMap);
		charToIndexMapping(targetLanguage, targetMap);
		
		if (alienLanguage.length == targetLanguage.length) {
			char [] targetNumber = new char[alienNumber.length];
			for (int i=0; i<alienNumber.length; i++) {
				targetNumber[i] = targetLanguage[alienMap.get(alienNumber[i])];
			}
			return new String(targetNumber);
		}
		
		int decNum = toDecimal(alienNumber, alienLanguage, alienMap);
		return decimalTo(decNum, targetLanguage);
	}

	private static String decimalTo(int decNum, char[] language) {
		int base = language.length;
		Stack<Character> targetNumberStack = new Stack<>();
		char [] targetNumber;
		while (decNum >= base) {
			int remainder = decNum % base;
			decNum /= base;
			targetNumberStack.push(language[remainder]); 
		}
		if (decNum != 0) {
			targetNumberStack.push(language[decNum]);
		}
		targetNumber = new char[targetNumberStack.size()];
		int count = 0;
		while (!targetNumberStack.empty()) {
			targetNumber[count] = targetNumberStack.pop();
			count++;
		}
		
		return new String(targetNumber);
	}

	private static int toDecimal(char[] number, char[] language, Map<Character, Integer> map) {
		int base = language.length;
		int power = number.length - 1;
		int targetNumber = 0;
		
		while (power >= 0) {
			targetNumber += Math.pow(base, power) * map.get(number[number.length -1 - power]);
			power--;
		}
		return targetNumber;
	}

	private static void charToIndexMapping(char[] language,
			Map<Character, Integer> map) {
		for (int i=0; i<language.length; i++) {
			map.put(language[i], i);
		}
	}

}
