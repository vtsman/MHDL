package vtsman.mhdl;

public class AND extends Part{


	@Override
	public void exec() {
		boolean o = true;
		for(Wire w : inputs){
			o = o && w.get();
		}
		out.set(this, o);
	}

}
