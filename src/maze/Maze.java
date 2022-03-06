package maze;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dijkstra.GraphInterface;
import dijkstra.VertexInterface;
import ui.Utils.Modal;

public class Maze implements GraphInterface {
	private List<ArrayList<MBox>> laby;
	private int maxX;
	private int maxY;

	public Maze() {
		this.laby = new ArrayList<ArrayList<MBox>>();
	}

	/**
	 * Create a maze from a already existing list
	 * 
	 * @param allBoxes
	 */
	public Maze(ArrayList<ArrayList<MBox>> allBoxes) {
		this.laby = allBoxes;
		this.maxX = allBoxes.get(0).size();
		this.maxY = allBoxes.size();
	}

	/**
	 * @param newMaxX
	 */
	public void setMaxX(int newMaxX) {
		this.maxX = newMaxX;
	}

	/**
	 * @return int
	 */
	public int getMaxX() {
		return this.maxX;
	}

	/**
	 * @param newMaxY
	 */
	public void setMaxY(int newMaxY) {
		this.maxY = newMaxY;
	}

	/**
	 * @return int
	 */
	public int getMaxY() {
		return this.maxY;
	}

	/**
	 * @param type
	 * @return MBox
	 */
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

	/**
	 * @return List<VertexInterface>
	 */
	public List<VertexInterface> getSommets() {
		List<VertexInterface> list = new ArrayList<VertexInterface>();
		for (int i = 0; i < this.maxY; i++) {
			for (int z = 0; z < this.maxX; z++) {
				list.add(this.laby.get(i).get(z));
			}
		}
		return list;
	}

	/**
	 * @return List<MBox>
	 */
	public List<MBox> getAllMBox() {
		List<MBox> list = new ArrayList<MBox>();
		for (int i = 0; i < this.maxY; i++) {
			for (int z = 0; z < this.maxX; z++) {
				list.add(this.laby.get(i).get(z));
			}
		}
		return list;
	}

	/**
	 * @param vertex
	 * @return List<VertexInterface>
	 */
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

	/**
	 * @param src
	 * @param dst
	 * @return int
	 */
	@Override
	public int getWeight(VertexInterface src, VertexInterface dst) {
		return 1;
	}

	/**
	 * @param x
	 * @param y
	 */
	public void setCaseWIN(int x, int y) {
		this.laby.get(y).get(x).setType("O");
	}

	/**
	 * @param fileName
	 */
	public final void initFromTextFile(String fileName) {
		BufferedReader objReader = null;
		int countChecker = 0;
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
						case 'F':
							line.add(new FBox(i, counter));
							break;
						default:
							throw new MazeReadingException("ERROR_CHAR_LINE", String.valueOf(counter + 1),
									Thread.currentThread().getStackTrace().toString());
					}
				}
				this.maxX = line.size();
				this.laby.add(line);
				if (counter != 0) {
					if (line.size() != countChecker) {
						throw new MazeReadingException("ERROR_LINE_LEN", String.valueOf(counter + 1),
								Thread.currentThread().getStackTrace().toString());
					}
				}
				countChecker = line.size();
				counter++;
			}
			this.maxY = this.laby.size();
		} catch (MazeReadingException ex) {
			Modal.Error(ex.getInfos(), ex.getMessage());
			this.createVoidMaze();
		} catch (FileNotFoundException fe) {
			Modal.ErrorCode("FILE_NOT_FOUND", fe.getMessage());
			this.createVoidMaze();
		} catch (IOException e) {
			Modal.ErrorCode("IO_ERROR", e.getMessage());
			this.createVoidMaze();
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

	private void createVoidMaze() {
		this.maxX = 10;
		this.maxY = 10;
		laby.clear();
		for (int i = 0; i < this.maxY; i++) {
			ArrayList<MBox> list = new ArrayList<MBox>();
			for (int z = 0; z < this.maxX; z++) {
				list.add(new EBox(i, z));
			}
			this.laby.add(list);
		}
	}

	/**
	 * @param fileName
	 */
	public final void saveToTextFile(String fileName) {
		File file = new File(fileName);
		try {
			file.createNewFile();
		} catch (IOException e) {

		}
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
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
			Modal.ErrorCode("NOT_SAVED", e.getMessage());
		} catch (Exception e) {
			Modal.ErrorCode("IO_ERROR", e.getMessage());
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
