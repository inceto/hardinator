/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into;

import ch.unibe.scs.into.evaluators.LogarithmicUnknownIsBadWordFrequencyEvaluator;
import java.util.HashSet;
import java.util.Set;

import ch.unibe.scs.into.evaluators.LogarithmicWordFrequencyEvaluator;
import ch.unibe.scs.into.evaluators.SentenceLengthEvaluator;
import ch.unibe.scs.into.evaluators.MircaeHeuristicsEvaluator;
import ch.unibe.scs.into.evaluators.WordFrequencyEvaluator;
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

    private static Set<ComprehensibilityEvaluator> evaluators = new HashSet<ComprehensibilityEvaluator>();

    static {
        Map<ComprehensibilityEvaluator, Integer> evaluatorWeightMap = new HashMap<ComprehensibilityEvaluator, Integer>();
        evaluatorWeightMap.put(new SentenceLengthEvaluator(),400);
        evaluatorWeightMap.put(new MircaeHeuristicsEvaluator(),50);
        evaluatorWeightMap.put(new WordFrequencyEvaluator(),20);
        evaluatorWeightMap.put(new LogarithmicWordFrequencyEvaluator(), 100);
        evaluatorWeightMap.put(new LogarithmicUnknownIsBadWordFrequencyEvaluator(), 900);
        evaluators = getCalibratedEvaluators(evaluatorWeightMap);
    }

    public static Set<ComprehensibilityEvaluator> getHardnessEvaluators() {
        return evaluators;
    }

    private static Set<ComprehensibilityEvaluator> getCalibratedEvaluators(Map<ComprehensibilityEvaluator, Integer> evaluatorWeightMap) {
        long totalWeight = 0;
        for (Entry<ComprehensibilityEvaluator, Integer> entry : evaluatorWeightMap.entrySet()) {
            totalWeight += entry.getValue();
        }
        Set<ComprehensibilityEvaluator> result = new HashSet<ComprehensibilityEvaluator>();
        for (Entry<ComprehensibilityEvaluator, Integer> entry : evaluatorWeightMap.entrySet()) {
            result.add(new CalibratedEvaluator(entry.getKey(), ((double)entry.getValue()) / totalWeight));
        }
        return result;
    }

    private static class CalibratedEvaluator implements ComprehensibilityEvaluator {
        private final ComprehensibilityEvaluator wrapped;
        private final double factor;

        public CalibratedEvaluator(ComprehensibilityEvaluator wrapped, double factor) {
            this.wrapped = wrapped;
            this.factor = factor;
        }

        public int getComprehensionCosts(Paragraph paragraph) {
            return (int) (factor * wrapped.getComprehensionCosts(paragraph));
        }
    }

}