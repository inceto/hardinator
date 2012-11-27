/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into.evaluators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.*;

import ch.unibe.scs.into.HardnessEvaluator;
import ch.unibe.scs.into.Paragraph;

public class LogarithmicWordFrequencyHardness implements HardnessEvaluator {

	private FrequencyMap frequencyMap = new LogarythmicWordFrequencyMap(WordFrequencyMap.getInstance());
	private int maxFrequency = frequencyMap.getMaxFrequency();

	public int getComprehensionCosts(Paragraph paragraph) {
		String[] allWords = removeNonChracter(paragraph.getText().toLowerCase()).split(" ");
		int foundWordCount = 0;
		long totalFrequencySum = 0;
		for (int i = 0; i < allWords.length; i++) {
			String word = allWords[i];
			if (word.length() > 0) {
				if (frequencyMap.containsKey(word)) {
					foundWordCount++;
					totalFrequencySum += frequencyMap.get(word);
				}				
			}
		}
		int average = foundWordCount > 0 ? (int) (totalFrequencySum / foundWordCount) : maxFrequency;
		average = (int) (average*99/maxFrequency);
		int result = 100 - average;
		return result;
		
	}

	/**
	 * strips away all non letter characters
	 * @param string a lower case string
	 * @return
	 */
	private static String removeNonChracter(String string) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				buffer.append(ch);
			} else {
				buffer.append(' ');
			}
		}
		return buffer.toString();
	}

	/*
	 * // second method // returning hardness value according to the standard
	 * deviation of the paragraph public int getStandardAverage (Paragraph
	 * paragraph2) { String[] allWords = paragraph2.getText().split(" "); int
	 * foundWordCount = 1; long totalSquare =0; for (int i = 0; i <
	 * allWords.length; i++) { String word = allWords[i].toLowerCase(); if
	 * (frequencyMap.containsKey(word)) { foundWordCount++; totalSquare +=
	 * (frequencyMap.get(word))*(frequencyMap.get(word)); } } int
	 * standardDeviation = (int) sqrt(totalSquare / foundWordCount); int result
	 * = ( 100-average ) + standardDeviation; return result; }
	 * 
	 * 
	 * public int SelectionHardest (Paragraph paragraph3) { String[] allWords =
	 * paragraph3.getText().split(" "); int foundWordCount = 1; for (int i = 0;
	 * i < allWords.length; i++) { String word = allWords[i].toLowerCase(); if
	 * (frequencyMap.containsKey(word)) { foundWordCount++;
	 * 
	 * } }
	 * 
	 * for (int count=0 ; count < foundWordCount ; count++) { int startFrequency
	 * = frequencyMap.get(word) ;
	 * 
	 * for (int n=0 ; n < 10 ; n++) {
	 * 
	 * 
	 * } }
	 */

}
