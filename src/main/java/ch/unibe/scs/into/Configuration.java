/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into;

import ch.unibe.scs.into.evaluators.SentenceLengthHardness;
import java.util.HashSet;
import java.util.Set;

/**
 * Provides static method providing the configurable bits of 
 * Hardinator's heuristics. 
 * 
 * In real life some inversion of control framework would be used
 */
public class Configuration {
	public static Set<HardnessEvaluator> getHardnessEvaluators() {
		Set<HardnessEvaluator> result = new HashSet<HardnessEvaluator>();
		result.add(new SentenceLengthHardness());
		return result;
	}
}
