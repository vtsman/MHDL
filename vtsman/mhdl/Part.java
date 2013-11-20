package vtsman.mhdl;

public abstract class Part {
	protected Wire out;
	protected Wire[] inputs;
	private boolean wasSet = false;

	public void set(Wire out, Wire... inputs) {
		if (!wasSet) {
			this.out = out;
			this.inputs = inputs;
		}
	}

	public abstract void exec();
}
