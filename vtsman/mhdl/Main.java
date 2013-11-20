package vtsman.mhdl;

import java.util.HashMap;

public class Main {
	static String lines[] = {"WIRE w", "OR (w FALSE)", "OR (out w FALSE)"};//, "PART test {", "}"};
	public static void main(String[] args) {
		Wire w = new Wire();
		Wire[] ws = {new Wire()};
		Program p = Compiler.compile(lines, w, ws);
		p.exec();
		System.out.println(p.out.get());
	}

}
