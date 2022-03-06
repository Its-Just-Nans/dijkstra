package maze;

import ui.Utils.Constant;

public class MazeReadingException extends Exception {
	private String correctMsg;

	public MazeReadingException(String code, String addInfos, String stack) {
		super(stack);
		this.correctMsg = Constant.t(code);
		this.correctMsg = correctMsg + " " + addInfos;
		System.out.print(correctMsg);
	}

	/**
	 * @return String
	 */
	public String getInfos() {
		return this.correctMsg;
	}
}
