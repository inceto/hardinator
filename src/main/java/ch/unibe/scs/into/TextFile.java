package ch.unibe.scs.into;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TextFile {

	final private Set<Paragraph> paragraphs = new HashSet<Paragraph>();
	final private String name;
	
	public TextFile(File f) throws IOException {
		final Reader reader = new FileReader(f);
		for (String paragraph = getNextParagraph(reader); 
				paragraph != null; paragraph = getNextParagraph(reader)) {
			paragraphs.add(new Paragraph(paragraph));
		}
		name = f.getName();
	}

	public Set<Paragraph> getParagraphs() {
		return Collections.unmodifiableSet(paragraphs);
	}
	/**
	 * 
	 * @param reader
	 * @return the next paragraph or null if there's no
	 * @throws IOException 
	 */
	private String getNextParagraph(Reader reader) throws IOException {
		final StringWriter resultWriter = new StringWriter();
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

	String getName() {
		return name;
	}

}
