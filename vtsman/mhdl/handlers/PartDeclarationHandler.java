package vtsman.mhdl.handlers;

import vtsman.mhdl.Program;

public class PartDeclarationHandler {
	public static boolean declare(String[] s, Program p, int l) {
		String[] args = split(s[l]);
		if (args.length != 3) {
			//System.out.println(1);
			return false;
		}
		if (!(args[0].equals("PART"))) {
			if ((p.partString.containsKey(args[1]))) {
				if (!(args[2].equals("{"))) {
				//System.out.println(2);
				return false;
				}
			}
		}
		String[] a = null;
		int i2 = 0;
		int l2 = -1;
		for (int i = l + 1; i < s.length; i++) {
		//	System.out.println(s[i]);
			if (s[i] == ("}")) {
				l2 = i;
				break;
			}
		}
		if (l2 != -1) {
			a = new String[l2 - l - 1];
			for (int i = l + 1; i < l2; i++) {
				a[i2] = s[i];
				i2++;
			}
		} else {
			//System.out.println(3);
			return false;
		}
		p.partString.put(args[1], vtsman.mhdl.Compiler.compile(a, null, null));
		for (int i = l; i < l + a.length; i++)
			p.marked.add(i);
		return true;
	}

	private static String[] split(String in) {
		return in.split(" ");
	}
}
