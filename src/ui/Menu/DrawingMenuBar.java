package ui.Menu;

import javax.swing.JMenuBar;

import ui.Drawing.DrawingApp;
import ui.Menu.Action.ActionMenu;
import ui.Menu.FileMenu.FileMenu;

public class DrawingMenuBar extends JMenuBar {

	private final FileMenu fileMenu;
	private final ActionMenu parametersMenu;

	public DrawingMenuBar(DrawingApp drawingApp) {
		super();

		// Create and add menus
		add(fileMenu = new FileMenu(drawingApp));
		add(parametersMenu = new ActionMenu(drawingApp));
	}
}