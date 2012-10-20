/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into.evaluators;

import ch.unibe.scs.into.HardnessEvaluator;
import ch.unibe.scs.into.Paragraph;


public class SentenceLengthHardness implements HardnessEvaluator{

	public int getComprehensionCosts(Paragraph paragraph) {
		final String sentences[] = paragraph.getText().split("\\.");
		int longestSentenceLength = 0;
		for (String sentence : sentences) {
			if (sentence.length() > longestSentenceLength) {
				longestSentenceLength = sentence.length();
			}
		}
		return longestSentenceLength;
	}
	
}
