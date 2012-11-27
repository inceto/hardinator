package ch.unibe.scs.into;

import java.io.File;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {
	
	final static String TEXT_DIR = "texts-en";
	
	public static void main(String... args) throws Exception {
		final SortedSet<Paragraph> sortedParagraphs = new TreeSet<Paragraph>();
		TextCollection tc = new TextCollection(new File(TEXT_DIR));
		for (TextFile tf : tc.getFiles()) {
			//System.out.println("Name of the file: "+tf.getName());
			for (Paragraph paragraph : tf.getParagraphs()) {
				//System.out.println("Paragraph:\n\n"+paragraph.getText()+"\n----\n\n");
                if (paragraph.getText().length() > 100) {
                    sortedParagraphs.add(paragraph);
                }
			}
		}
		System.out.println();
		System.out.println("Paragraphs by easyness:");
		for (Paragraph paragraph : sortedParagraphs) {
			System.out.println("Paragraph:\n\n"+paragraph.getText()+"\n"+paragraph.getComprehensionCosts()+"\n----\n\n");
		}
		
	}

}
