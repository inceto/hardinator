/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into.evaluators;

import ch.unibe.scs.into.HardnessEvaluator;
import ch.unibe.scs.into.Paragraph;


public class UnknownIsBadHardness implements HardnessEvaluator{

	public int getComprehensionCosts(Paragraph paragraph) {
		return paragraph.getText().toLowerCase().contains("unknown") ? 100 : 1;
	}
	
}
