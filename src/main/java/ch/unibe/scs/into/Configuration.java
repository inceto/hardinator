/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import ch.unibe.scs.into.evaluators.LogarithmicUnknownIsBadWordFrequencyHardness;
import ch.unibe.scs.into.evaluators.LogarithmicWordFrequencyHardness;
import ch.unibe.scs.into.evaluators.SentenceLengthHardness;
import ch.unibe.scs.into.evaluators.UnknownIsBadHardness;
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
            evaluators.add(new UnknownIsBadHardness());
                //evaluators.add(new WordFrequencyHardness());
                //evaluators.add(new LogarithmicWordFrequencyHardness());
                //evaluators.add(new LogarithmicUnknownIsBadWordFrequencyHardness());
	}

	public static Set<HardnessEvaluator> getHardnessEvaluators(){
		return evaluators;
	}
}