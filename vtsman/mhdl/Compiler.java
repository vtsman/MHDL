package vtsman.mhdl;

import vtsman.mhdl.handlers.*;
public class Compiler {
	public static Program compile(String program, Wire output, Wire[] inputs){
		return compile(split(program), output, inputs);
	}
	public static Program compile(String[] lines, Wire output, Wire[] inputs){
		
		Program p = new Program();
		p.set(output, inputs);
		p.init();
		int l = 0;
		//checking for part and wire definitions
		for(String s : lines){
			if(p.marked.contains(l)){
				l++;
				continue;
			}
			
			if(WireDeclarationHandler.declare(s, p, l)){
				System.out.println("Wire declared");
			}
			else if(PartDeclarationHandler.declare(lines, p, l)){
				System.out.println("Part declared");
			}
			l++;
		}
		//adding in parts
		l = 0;
		for(String s : lines){
			if(p.marked.contains(l)){
				l++;
				continue;
			}
			System.out.println(s);
			if(PartAdderHandler.addPart(s, p, l)){
				System.out.println("Added part");
			}
			l++;
		}
		return p;
	}
	private static String[] split(String in){
		return in.split("\\r?\\n");
	}
}
