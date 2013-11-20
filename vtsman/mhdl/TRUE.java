package vtsman.mhdl;

public class TRUE extends Wire{
	@Override
	public boolean set(Part p, boolean b){
		return false;
	}
	 
	@Override
	public boolean get(){
		return true;
	}
}
