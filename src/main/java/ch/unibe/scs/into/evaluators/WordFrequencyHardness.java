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

import ch.unibe.scs.into.HardnessEvaluator;
import ch.unibe.scs.into.Paragraph;


public class WordFrequencyHardness implements HardnessEvaluator{

	Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
	
	public WordFrequencyHardness() throws IOException {
		Reader reader = new InputStreamReader(
				WordFrequencyHardness.class.getResourceAsStream("wordfrequency.txt"));
		BufferedReader in = new BufferedReader(reader);
		String line = in.readLine();
		while ( line != null)
		{
			String[] parts = line.split(" ");
			int frequency = Integer.parseInt(parts[0]);
			String word = parts[1].toLowerCase();
			frequencyMap.put(word, frequency);
			line = in.readLine();
		}
		in.close();
	}
	
	public int getComprehensionCosts(Paragraph paragraph) {
		String[] allWords = paragraph.getText().split(" ");
		int foundWordCount = 1;
		long totalFrequencySum = 0;
		for (int i = 0; i < allWords.length; i++) {
			String word = allWords[i].toLowerCase();
			if (frequencyMap.containsKey(word)) {
				foundWordCount++;
				totalFrequencySum += frequencyMap.get(word);
			}
		}
		int average = (int) (totalFrequencySum / foundWordCount);
		//FIXME normalize this to be a well distributed value between 1 and 100
		return 100-average;
	}
	
}
