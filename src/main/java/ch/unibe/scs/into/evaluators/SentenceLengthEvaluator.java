/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into.evaluators;

import ch.unibe.scs.into.ComprehensibilityEvaluator;
import ch.unibe.scs.into.Paragraph;


public class SentenceLengthEvaluator implements ComprehensibilityEvaluator{

	public int getComprehensionCosts(Paragraph paragraph) {
		final String sentences[] = paragraph.getText().split("\\.");
		int longestSentenceLength = 0;
		for (String sentence : sentences) {
			if (sentence.length() > longestSentenceLength) {
				longestSentenceLength = sentence.length();
			}
		}
		//lets define 4000 character senetences to be very hard
		int costs = longestSentenceLength / 40;
		return costs > 100? 100 : costs;
	}
	
}
