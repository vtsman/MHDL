package vtsman.mhdl.handlers;

import vtsman.mhdl.Program;
import vtsman.mhdl.Wire;
public class WireDeclarationHandler {
	public static boolean declare(String s, Program p, int l){
		String[] args = split(s);
		if(args.length != 2){
			return false;
		}
		if(args[1].matches("WIRE")){
			return false;
		}
		if(p.wires.containsKey(args[1])){
			return false;
		}
		p.marked.add(l);
		p.wires.put(args[1], new Wire());
		return true;
	}
	private static String[] split(String in){
		return in.split(" ");
	}
}
