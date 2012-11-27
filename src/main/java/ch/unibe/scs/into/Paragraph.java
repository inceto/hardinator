/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into;

/**
 *
 */
public class Paragraph implements Comparable<Paragraph> {
	private final String text;
    private int costs = -1;

	public Paragraph(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public int getComprehensionCosts() {
		if (costs == -1) {
            computeCosts();
        }
        return costs;
	}
    
    private void computeCosts() {
		int totalCosts = 0;
		for (ComprehensibilityEvaluator he :Configuration.getHardnessEvaluators()) {
			totalCosts += he.getComprehensionCosts(this);
		}
		costs = totalCosts;
	}

	public int compareTo(Paragraph other) {
		int costsHere = getComprehensionCosts();
		int costsThere = other.getComprehensionCosts();
		if (costsHere == costsThere) {
			return getText().compareTo(other.getText());
		}
		return costsHere - costsThere;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!other.getClass().equals(this.getClass())) {
			return false;
		}
		return getText().equals(((Paragraph)other).getText());
	}
	
	@Override
	public int hashCode() {
		return getText().hashCode();
	}
}

