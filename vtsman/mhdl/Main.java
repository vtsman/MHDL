package vtsman.mhdl;

import java.util.HashMap;

public class Main {
	static String lines[] = {"OR (w FALSE)", "AND (q w FALSE)", "WIRE w", "WIRE q", "XOR (out w q)"};
	public static void main(String[] args) {
		Wire w = new Wire();
		Wire[] ws = {new Wire()};
		Program p = Compiler.compile(lines, w, ws);
		p.exec();
		System.out.println(w.get());
	}

}
