package ui.Menu;

import javax.swing.JMenuBar;

import ui.Drawing.DrawingApp;
import ui.Menu.Dijkstra.DijkstraMenu;
import ui.Menu.FileMenu.FileMenu;
import ui.Menu.Labyrinthe.LabyrintheMenu;

public class DrawingMenuBar extends JMenuBar {

	private final LabyrintheMenu labyrintheMenu;
	private final FileMenu fileMenu;
	private final DijkstraMenu parametersMenu;

	public DrawingMenuBar(DrawingApp drawingApp) {
		super();

		// Create and add menus
		this.fileMenu = new FileMenu(drawingApp);
		this.add(fileMenu);
		this.labyrintheMenu = new LabyrintheMenu(drawingApp);
		this.add(labyrintheMenu);
		this.parametersMenu = new DijkstraMenu(drawingApp);
		this.add(parametersMenu);
	}
}