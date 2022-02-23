
import dijkstra.PreviousInterface;

import java.util.ArrayList;

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
		ArrayList<MBox> listFinal = new ArrayList<MBox>();
		MBox tempCase = end;
		while (tempCase != null) {
			tempCase = (MBox) chemin.getValue(tempCase);
			listFinal.add(tempCase); // this line is after to no include the final box
		}
		for (MBox oneBox : listFinal) {
			if (oneBox != null) {
				maze.setCaseWIN(oneBox.getX(), oneBox.getY());
			}
		}
		String fileName2 = "data/labyrinthe2.txt";
		maze.saveToTextFile(fileName2);
		System.out.println("DONE");
	}
}
