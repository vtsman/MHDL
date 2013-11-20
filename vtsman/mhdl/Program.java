package vtsman.mhdl;

import java.util.ArrayList;
import java.util.HashMap;

public class Program extends Part {
	public HashMap<String, Wire> wires = new HashMap<String, Wire>();
	public HashMap<String, Part> partString = new HashMap<String, Part>();
	public ArrayList<Integer> marked = new ArrayList<Integer>();
	public ArrayList<Part> parts = new ArrayList<Part>();

	public void init() {
		if(!(this.inputs == null || this.out == null))
		{
			for (int i = 0; i < this.inputs.length; i++) {
				wires.put("in" + Integer.toString(i), this.inputs[i]);
			}
			wires.put("out", this.out);
		}
		wires.put("FALSE", new FALSE());
		wires.put("TRUE", new TRUE());
		partString.put("OR", new OR());
		partString.put("XOR", new XOR());
		partString.put("AND", new AND());
		partString.put("NOT", new NOT());
		partString.put("NAND", new NAND());
	}

	private Wire getWire(String s){
		if(wires.containsKey(s)){
			return wires.get(s);
		}
		return wires.get("FALSE");
	}
	
	public Part newPart(String part, String out, String[] inputs){
		Part p = null;
		Wire o = getWire(out);
		Wire[] args = new Wire[inputs.length];
		int i = 0;
		for(String s : inputs){
			args[i] = getWire(s);
			i++;
		}
		try {
			p = partString.get(part).getClass().newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.set(o, args);
		return p;
	}
	
	@Override
	public void exec() {
		for(Part p : parts){
			p.exec();
		}
	}
}
