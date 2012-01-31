package jsaf.test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

import jsaf.ast.fighter.Fighter;
import jsaf.syntax.JSAF;

public abstract class Load {
	protected Fighter load(String name) {
		String subPath = "jsaf" + File.separator + "test" + File.separator +  name;
		InputStream input = getClass().getClassLoader().getResourceAsStream(subPath);
		return JSAF.parse(new InputStreamReader(input));
	}
}