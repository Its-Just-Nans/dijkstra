
import dijkstra.ASet;
import dijkstra.PreviousInterface;
import dijkstra.Dijkstra;
import maze.MBox;
import maze.Maze;
import ui.DrawingApp;

public class MainTest {
	public static void main(String[] args) {
		DrawingApp a = new DrawingApp();
		Maze maze = new Maze();
		String fileName = "data/labyrinthe.txt";
		maze.initFromTextFile(fileName);
		ASet set = new ASet();
		MBox start = maze.findByType("D");
		MBox end = maze.findByType("A");
		PreviousInterface chemin = Dijkstra.dijkstra(maze, start, set);
		// System.out.println(chemin);
		MBox endCase = end;
		while (endCase.getLabel() != start.getLabel()) {
			endCase = (MBox) chemin.getValue(endCase);
			maze.setCaseWIN(endCase.getX(), endCase.getY());
		}
		String fileName2 = "data/labyrinthe2.txt";
		maze.saveToTextFile(fileName2);
		System.out.println("DONE");
	}
}
