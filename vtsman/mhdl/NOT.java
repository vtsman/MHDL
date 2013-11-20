package vtsman.mhdl;

public class NOT extends Part{


	@Override
	public void exec() {
		Wire w = new Wire();
		Part or = new OR();
		or.set(w, inputs);
		or.exec();
		out.set(this, w.get());
	}

}
