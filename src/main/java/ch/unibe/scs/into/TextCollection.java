package ch.unibe.scs.into;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TextCollection {

	Set<TextFile> files = new HashSet<TextFile>();
	
	public TextCollection(File dir) throws IOException {
		for (File f : dir.listFiles()) {
			TextFile textFile = new TextFile(f);
		}
	}

}
