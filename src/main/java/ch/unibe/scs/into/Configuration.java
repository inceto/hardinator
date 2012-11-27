/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into;

import java.util.HashSet;
import java.util.Set;

import ch.unibe.scs.into.evaluators.LogarithmicUnknownIsBadWordFrequencyHardness;
import ch.unibe.scs.into.evaluators.LogarithmicWordFrequencyHardness;
import ch.unibe.scs.into.evaluators.SentenceLengthHardness;
import ch.unibe.scs.into.evaluators.UnknownIsBadHardness;
import ch.unibe.scs.into.evaluators.WordFrequencyHardness;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Provides static method providing the configurable bits of Hardinator's
 * heuristics.
 *
 * In real life some inversion of control framework would be used
 */
public class Configuration {

    private static Set<HardnessEvaluator> evaluators = new HashSet<HardnessEvaluator>();

    static {
        Map<HardnessEvaluator, Integer> evaluatorWeightMap = new HashMap<HardnessEvaluator, Integer>();
        evaluatorWeightMap.put(new SentenceLengthHardness(),400);
        evaluatorWeightMap.put(new UnknownIsBadHardness(),50);
        evaluatorWeightMap.put(new WordFrequencyHardness(),20);
        evaluatorWeightMap.put(new LogarithmicWordFrequencyHardness(), 100);
        evaluatorWeightMap.put(new LogarithmicUnknownIsBadWordFrequencyHardness(), 900);
        evaluators = getCalibratedEvaluators(evaluatorWeightMap);
    }

    public static Set<HardnessEvaluator> getHardnessEvaluators() {
        return evaluators;
    }

    private static Set<HardnessEvaluator> getCalibratedEvaluators(Map<HardnessEvaluator, Integer> evaluatorWeightMap) {
        long totalWeight = 0;
        for (Entry<HardnessEvaluator, Integer> entry : evaluatorWeightMap.entrySet()) {
            totalWeight += entry.getValue();
        }
        Set<HardnessEvaluator> result = new HashSet<HardnessEvaluator>();
        for (Entry<HardnessEvaluator, Integer> entry : evaluatorWeightMap.entrySet()) {
            result.add(new CalibratedEvaluator(entry.getKey(), ((double)entry.getValue()) / totalWeight));
        }
        return result;
    }

    private static class CalibratedEvaluator implements HardnessEvaluator {
        private final HardnessEvaluator wrapped;
        private final double factor;

        public CalibratedEvaluator(HardnessEvaluator wrapped, double factor) {
            this.wrapped = wrapped;
            this.factor = factor;
        }

        public int getComprehensionCosts(Paragraph paragraph) {
            return (int) (factor * wrapped.getComprehensionCosts(paragraph));
        }
    }

}