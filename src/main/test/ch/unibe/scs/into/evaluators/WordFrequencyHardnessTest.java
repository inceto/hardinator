/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into.evaluators;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ch.unibe.scs.into.Paragraph;

public class WordFrequencyHardnessTest {

	WordFrequencyHardness evaluator;
	
	@Before
	public void setUp() throws IOException {
		evaluator = new WordFrequencyHardness();
	}
	
	@Test
	public void someTest() {
		evaluator.getComprehensionCosts(new Paragraph("_Later_."));
	}
	@Test
	public void verzHardTextsTest() {
		Assert.assertEquals(1,evaluator.getComprehensionCosts(new Paragraph("")));
	}
}
