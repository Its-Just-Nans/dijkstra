
import dijkstra.PreviousInterface;
import dijkstra.Dijkstra;
import maze.MBox;
import maze.Maze;
import ui.Drawing.DrawingApp;

public class MainTest {
	public static void main(String[] args) {
		DrawingApp drawingApp = new DrawingApp();
		Maze maze = new Maze();
		String fileName = "data/labyrinthe.txt";
		maze.initFromTextFile(fileName);
		MBox start = maze.findByType("D");
		MBox end = maze.findByType("A");
		PreviousInterface chemin = Dijkstra.dijkstra(maze, start);
		// System.out.println(chemin);
		MBox endCase = end;
		while (!endCase.getLabel().equals(start.getLabel())) {
			endCase = (MBox) chemin.getValue(endCase);
			maze.setCaseWIN(endCase.getX(), endCase.getY());
		}
		String fileName2 = "data/labyrinthe2.txt";
		maze.saveToTextFile(fileName2);
		System.out.println("DONE");
	}
}
