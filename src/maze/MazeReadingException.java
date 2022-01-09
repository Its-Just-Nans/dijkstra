package maze;

public class MazeReadingException extends Exception {
	public MazeReadingException(String name, int num, String message) {
		super(message);
		System.out.print(name + " " + num);
	}
}
