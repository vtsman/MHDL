package vtsman.mhdl;

public class OR extends Part{

	@Override
	public void exec() {
		boolean o = false;
		for(Wire w : inputs){
			o = o || w.get();
		}
		out.set(this, o);
	}

}
