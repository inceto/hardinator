/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into.evaluators;

import ch.unibe.scs.into.ComprehensibilityEvaluator;
import ch.unibe.scs.into.Paragraph;


public class MircaeHeuristicsEvaluator implements ComprehensibilityEvaluator{

	public int getComprehensionCosts(Paragraph paragraph) {
		return paragraph.getText().toLowerCase().contains("portentous") ? 100 : 1;
	}
	
}
