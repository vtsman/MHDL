package vtsman.mhdl.handlers;

import vtsman.mhdl.Program;

public class PartAdderHandler {
	public static boolean addPart(String s, Program p, int l){
		String[] a = split(s);
		if(!(a.length > 2)){
			return false;
		}
		if(!p.partString.containsKey(a[0])){
			return false;
		}
		if(!(a[1].startsWith("(") && a[a.length - 1].endsWith(")"))){
			return false;
		}
		String[] args = new String[a.length - 2];
		String out = a[1].substring(1);
		String temp = a[a.length - 1];
		args[args.length - 1] = temp.substring(0, temp.length() - 1);
		for(int i = 2; i < a.length - 1; i++){
			args[i - 2] = a[i];
		}
		for(String st : args){
			System.out.println(st);
		}
		p.marked.add(l);
		p.parts.add(p.newPart(a[0], out, args));
		System.out.println("Added part " + a[0] + " with output " + out);
		return true;
	}
	
	private static String[] split(String in){
		return in.split(" ");
	}
}
