package vtsman.mhdl;

public class Wire {
	private boolean bool = false;
	private Part input;
	
	public boolean set(Part p, boolean b){
		if(input == null){
			bool = b;
			input = p;
			return true;
		}
		if(p == input){
			bool = b;
			return true;
		}
		return false;
	}
	
	public boolean get(){
		return bool;
	}
}
