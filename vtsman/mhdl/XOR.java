package vtsman.mhdl;

public class XOR extends Part{

	@Override
	public void exec() {
		boolean t = true;
		boolean i = true;
		for(Wire w : inputs){
			t = t && w.get();
			i = i && !w.get();
		}
		out.set(this, t || i);
	}

}
