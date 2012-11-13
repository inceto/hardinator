/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.unibe.scs.into.evaluators;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import ch.unibe.scs.into.HardnessEvaluator;
import ch.unibe.scs.into.Paragraph;


public class WordFrequencyHardness implements HardnessEvaluator{

	public int getComprehensionCosts(Paragraph paragraph) {
		//TODO implement
		return 0;
	}
	
	public static void main (String[] args) throws IOException
	{
		//System.out.println("wordfrequency.txt");
		Reader reader = new InputStreamReader(
				WordFrequencyHardness.class.getResourceAsStream("wordfrequency.txt"));
		BufferedReader in = new BufferedReader(reader);
		String line = in.readLine();
		while ( line != null)
		{
			String[] parts = line.split(" ");
			System.out.println(parts[0]);
			System.out.println(parts[1]);
			
			System.out.println(line);
			line = in.readLine();
			
			
		}
		in.close();
		
	}
}
