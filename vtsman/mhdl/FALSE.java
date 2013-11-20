package vtsman.mhdl;

public class FALSE extends Wire{
	@Override
	public boolean set(Part p, boolean b){
		return false;
	}
	 
	@Override
	public boolean get(){
		return false;
	}
}
