package ch.unibe.scs.into;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;

public class TextFile {

	public TextFile(File f) throws IOException {
		Reader reader = new FileReader(f);
		for (String paragraph = getNextParagraph(reader); 
				paragraph != null; paragraph = getNextParagraph(reader)) {
			System.out.println("Paragraph:\n\n"+paragraph+"\n----\n\n");
		}

	}

	/**
	 * 
	 * @param reader
	 * @return the next paragraph or null if there's no
	 * @throws IOException 
	 */
	private String getNextParagraph(Reader reader) throws IOException {
		StringWriter resultWriter = new StringWriter();
		int lastCharNewLine = 0;
		for (int ch = reader.read(); ch != -1; ch = reader.read()) {
			if ((ch == '\n') || (ch == '\r') ) {
				if (lastCharNewLine == 3) {
					return resultWriter.toString();
				} else  { 
					lastCharNewLine++;
				}
			} else {
				lastCharNewLine = 0;
			}
			resultWriter.write(ch);
		}
		String restOfBook = resultWriter.toString();
		if (restOfBook.length() > 0) {
			return restOfBook;
			
		} else {
			
			return null;
			
		} 
		
		
 
	}

}
