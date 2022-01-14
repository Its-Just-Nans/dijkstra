package ui.Menu;

import javax.swing.*;

import ui.DrawingApp;
import ui.menu.Action.ActionMenu;
import ui.menu.FileMenu.FileMenu;

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