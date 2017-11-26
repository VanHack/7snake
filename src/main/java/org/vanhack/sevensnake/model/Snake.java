package org.vanhack.sevensnake.model;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Snake {
	private Graph graph;
	private Set<Node> nodes;
	private int weight;

	public Snake(Graph graph, Set<Node> nodes) {
		this.graph = graph;
		this.nodes = nodes;
		weight = calculateWeight();
	}

	private int calculateWeight() {
		return nodes.parallelStream().mapToInt(graph::getWeight).sum();
	}

	public boolean disjoint(Snake other) {
		return Collections.disjoint(nodes, other.nodes);
	}

	public int getWeight() {
		return weight;
	}
	
	public Snake cloneAt(Node node){
		Set<Node> newNodes = Collections.synchronizedSet(nodes.parallelStream().map(node::add).collect(Collectors.toSet()));
		return new Snake(graph, newNodes);
	}
	
	@Override
	public String toString() {
		return new StringBuilder("Snake[nodes=").append(nodes).append(", weight=").append(weight).append("]").toString();
	}

	public Set<Node> getNodes() {
		return nodes;
	}
}
