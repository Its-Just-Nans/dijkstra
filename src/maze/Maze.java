package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;

public class Maze implements GraphInterface {
	private List<ArrayList<MBox>> laby;
	private int maxX;
	private int maxY;

	public Maze() {
		this.laby = new ArrayList<ArrayList<MBox>>();
	}

	public void setMaxX(int newMaxX) {
		this.maxX = newMaxX;
	}

	public int getMaxX() {
		return this.maxX;
	}

	public void setMaxY(int newMaxY) {
		this.maxY = newMaxY;
	}

	public int getMaxY() {
		return this.maxY;
	}

	public MBox findByType(String type) {
		MBox start = null;
		for (int i = 0; i < this.maxY; i++) {
			for (int z = 0; z < this.maxX; z++) {
				if (this.laby.get(i).get(z).getType().equals(type)) {
					start = this.laby.get(i).get(z);
				}
			}
		}
		return start;
	}

	public List<VertexInterface> getSommets() {
		List<VertexInterface> list = new ArrayList<VertexInterface>();
		for (int i = 0; i < this.maxY; i++) {
			for (int z = 0; z < this.maxX; z++) {
				list.add(this.laby.get(i).get(z));
			}
		}
		return list;
	}

	public List<VertexInterface> getSuccessorOf(VertexInterface vertex) {
		MBox box = (MBox) vertex;
		int x = box.getX();
		int y = box.getY();
		List<VertexInterface> listSuccessor = new ArrayList<VertexInterface>();
		if (y > 0) {
			// get the upper
			MBox boxToAdd = this.laby.get(y - 1).get(x);
			if (boxToAdd.isTraversable()) {
				listSuccessor.add(boxToAdd);
			}
		}
		if (y < (maxY - 1)) {
			// get the down
			MBox boxToAdd = this.laby.get(y + 1).get(x);
			if (boxToAdd.isTraversable()) {
				listSuccessor.add(boxToAdd);
			}
		}
		if (x > 0) {
			// get the left
			MBox boxToAdd = this.laby.get(y).get(x - 1);
			if (boxToAdd.isTraversable()) {
				listSuccessor.add(boxToAdd);
			}
		}
		if (x < (maxX - 1)) {
			// get the right
			MBox boxToAdd = this.laby.get(y).get(x + 1);
			if (boxToAdd.isTraversable()) {
				listSuccessor.add(boxToAdd);
			}
		}
		return listSuccessor;
	}

	@Override
	public int getWeight(VertexInterface src, VertexInterface dst) {
		return 1;
	}

	public void setCaseWIN(int x, int y) {
		this.laby.get(y).get(x).setType("O");
	}

	public final void initFromTextFile(String fileName) {
		BufferedReader objReader = null;
		try {
			String strCurrentLine;
			objReader = new BufferedReader(new FileReader(fileName));
			int counter = 0;
			while ((strCurrentLine = objReader.readLine()) != null) {
				ArrayList<MBox> line = new ArrayList<MBox>();
				for (int i = 0; i < strCurrentLine.length(); i++) {
					switch (strCurrentLine.charAt(i)) {
						case 'A':
							line.add(new ABox(i, counter));
							break;
						case 'D':
							line.add(new DBox(i, counter));
							break;
						case 'W':
							line.add(new WBox(i, counter));
							break;
						case 'E':
							line.add(new EBox(i, counter));
							break;
						default:
							new MazeReadingException("file", counter, "error in line");
					}
				}
				this.maxX = line.size();
				this.laby.add(line);
				counter++;
			}
			this.maxY = this.laby.size();
		} catch (IOException e) {
			e.printStackTrace();
			new MazeReadingException("file", 0, e.getMessage());
		} finally {
			try {
				if (objReader != null) {
					objReader.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public final void saveToTextFile(String fileName) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(fileName);
			String text = "";
			for (int y = 0; y < this.maxY; y++) {
				for (int x = 0; x < this.maxX; x++) {
					text += this.laby.get(y).get(x).getType();
				}
				text += "\n";
			}
			writer.write(text);
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
