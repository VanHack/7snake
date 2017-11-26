package org.vanhack.sevensnake.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;


public class Graph {
	
	private static final String CSV_SEPARATOR = ",";

	int dimension;
	
	int[][] matrix;
	
	
	public Graph(File csv){
		try {
			matrix = readCSV(csv);
			dimension = matrix.length;
		} catch (IOException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public Graph(int dimension) {
		this.dimension = dimension;
		matrix = new int[dimension][dimension];
	}
	
	public int getWeight(Node node){
		return matrix[node.getY()][node.getX()]; 
	}
	
	public int getDimension(){
		return dimension;
	}
	
	public boolean isValidNode(Node nodeToValidate){
		return nodeToValidate.getX() < dimension && nodeToValidate.getX() >= 0 && 
				nodeToValidate.getY() < dimension && nodeToValidate.getY() >= 0;
	}

	private int[][] readCSV(File file) throws FileNotFoundException, IOException{
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			int[][] matrix;
			String line = reader.readLine();
			int matrixSize = line.split(CSV_SEPARATOR).length;
			matrix = new int[matrixSize][matrixSize];
			int y = 0;
			do {
				String[] values = line.split(CSV_SEPARATOR);
				dimension = values.length;
				int x = 0;
				for(String value: values){
					matrix[y][x] = Integer.parseInt(value);
					x++;
				}
				y++;
			} while((line = reader.readLine())!= null);
			return matrix;
		}
	}	
	
	public Collection<Node> getMatrixNodes(){
		Collection<Node> nodes = new HashSet<>();
		for(int x = 0; x < dimension; x++){
			for(int y = 0; y < dimension; y++){
				nodes.add(new Node(x, y));
			}
		}
		return nodes;
	}
}
