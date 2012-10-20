/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into;

/**
 * Classes implementing this interface evaluate the hardness of paragraph.
 * They indicate the hardness of a paragraph in term of comprehension costs,
 * the higher this value is the harder the text is assumed to be
 */
public interface HardnessEvaluator {
	
	public int getComprehensionCosts(Paragraph paragraph);
	
}
