/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import ch.unibe.scs.into.evaluators.WordFrequencyHardness;

/**
 * Provides static method providing the configurable bits of 
 * Hardinator's heuristics. 
 * 
 * In real life some inversion of control framework would be used
 */
public class Configuration {
	private static Set<HardnessEvaluator> evaluators = new HashSet<HardnessEvaluator>();
	static {
		//evaluators.add(new SentenceLengthHardness());
		try {
			evaluators.add(new WordFrequencyHardness());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Set<HardnessEvaluator> getHardnessEvaluators(){
		return evaluators;
	}
}