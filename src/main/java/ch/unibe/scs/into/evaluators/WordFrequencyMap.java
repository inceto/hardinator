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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reto
 */
public class WordFrequencyMap extends HashMap<String, Integer> implements FrequencyMap {
    private static WordFrequencyMap instance;

    private int maxFrequency;
    
    private WordFrequencyMap() throws IOException {
        Reader reader = new InputStreamReader(
				WordFrequencyEvaluator.class
						.getResourceAsStream("wordfrequency.txt"));
		BufferedReader in = new BufferedReader(reader);
		String line = in.readLine();
		while (line != null) {
			String[] parts = line.split(" ");
			int frequency = Integer.parseInt(parts[0]);
			String word = parts[1].toLowerCase();
			//we use the first in the list
			if (!containsKey(word)) {
				if (frequency > maxFrequency) {
					maxFrequency = frequency;
				}
				put(word, frequency);
			}
			line = in.readLine();
		}
		in.close();
    }

    @Override
    public int getMaxFrequency() {
        return maxFrequency;
    }
    
    
    
    public static WordFrequencyMap getInstance() {
        if (instance == null) {
            try {
                instance = new WordFrequencyMap();
            } catch (IOException ex) {
                Logger.getLogger(WordFrequencyMap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }
    
    
}
