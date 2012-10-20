package ch.unibe.scs.into;

import java.io.File;

public class Main {
	
	final static String TEXT_DIR = "texts-en";
	
	public static void main(String... args) throws Exception {
		TextCollection tc = new TextCollection(new File(TEXT_DIR));
		for (TextFile tf : tc.getFiles()) {
			System.out.println("Name of the file: "+tf.getName());
			for (Paragraph paragraph : tf.getParagraphs()) {
				System.out.println("Paragraph:\n\n"+paragraph.getText()+"\n----\n\n");
			}
		}
		//
		//while (Text = tc.listTexts()) 
	}

}
