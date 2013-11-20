package vtsman.mhdl;

public class NAND extends Part{

	@Override
	public void exec() {
		Wire w = new Wire();
		Part xor = new XOR();
		xor.set(w, inputs);
		xor.exec();
		out.set(this, !w.get());
	}

}
