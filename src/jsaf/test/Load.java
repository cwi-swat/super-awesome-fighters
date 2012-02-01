package jsaf.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import jsaf.ast.fighter.Fighter;
import jsaf.syntax.JSAF;

public abstract class Load {
	protected Fighter load(String name) {
		return JSAF.parse(loadAsReader(name));
	}
	
	protected Fighter loadString(String src) {
		return JSAF.parse(new StringReader(src));
	}

	protected String loadSource(String name) {
		BufferedReader reader = new BufferedReader(loadAsReader(name));
		try {
			String str = reader.readLine();
			StringBuilder builder = new StringBuilder();
			while (str != null) {
				builder.append(str + "\n");
				str = reader.readLine();
			}
			reader.close();
			return builder.toString();
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private InputStreamReader loadAsReader(String name) {
		String subPath = "jsaf" + File.separator + "test" + File.separator +  name;
		InputStream input = getClass().getClassLoader().getResourceAsStream(subPath);
		return new InputStreamReader(input);
	}
	
}