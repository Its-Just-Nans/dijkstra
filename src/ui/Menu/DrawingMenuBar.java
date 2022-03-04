package ui.Menu;

import javax.swing.JMenuBar;

import ui.Drawing.DrawingApp;
import ui.Menu.Dijkstra.DijkstraMenu;
import ui.Menu.FileMenu.FileMenu;
import ui.Menu.Labyrinthe.LabyrintheMenu;

public class DrawingMenuBar extends JMenuBar {
	private final FileMenu fileMenu;
	private final LabyrintheMenu labyrintheMenu;
	private final DijkstraMenu dijkstraMenu;

	public DrawingMenuBar(DrawingApp drawingApp) {
		super();

		// Create and add menus
		this.add(fileMenu = new FileMenu(drawingApp));
		this.add(labyrintheMenu = new LabyrintheMenu(drawingApp));
		this.add(dijkstraMenu = new DijkstraMenu(drawingApp));
	}

	public void changeLocale() {
		this.fileMenu.changeLocale();
		this.labyrintheMenu.changeLocale();
		this.dijkstraMenu.changeLocale();
	}
}