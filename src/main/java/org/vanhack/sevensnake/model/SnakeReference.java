package org.vanhack.sevensnake.model;

import java.util.Set;

import org.vanhack.sevensnake.seeker.Kernel;

public class SnakeReference {
	private Graph graph;
	private Node position;
	private int reference;
	
	public SnakeReference(Graph graph, Node position, int reference) {
		this.graph = graph;
		this.position = position;
		this.reference = reference;
	}

	public Set<Node> getNodes(){
		return getSnake().getNodes(); 
	}
	
	public Snake getSnake(){
		return new Snake(graph, Kernel.KERNEL.get(reference)).cloneAt(position);
	}
}
