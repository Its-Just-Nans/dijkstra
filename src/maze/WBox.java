package maze;

public class WBox extends MBox {
	public WBox() {
		super("W");
	}

	public WBox(int x, int y) {
		super("W", x, y);
	}

	/**
	 * @return boolean
	 */
	@Override
	public boolean isTraversable() {
		return false;
	}
}
