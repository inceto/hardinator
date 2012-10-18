package ch.unibe.scs.into;

import java.io.File;
import java.io.IOException;

public class Main {
	
	final static String TEXT_DIR = "texts-en";
	
	public static void main(String... args) throws Exception {
		TextCollection tc = new TextCollection(new File(TEXT_DIR));
		//while (Text = tc.listTexts()) 
	}

}
