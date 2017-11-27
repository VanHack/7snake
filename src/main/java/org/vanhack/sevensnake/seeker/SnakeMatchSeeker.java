package org.vanhack.sevensnake.seeker;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.vanhack.sevensnake.model.Graph;
import org.vanhack.sevensnake.model.Node;
import org.vanhack.sevensnake.model.Snake;
import org.vanhack.sevensnake.model.SnakeMatch;
import org.vanhack.sevensnake.model.SnakeReference;

public class SnakeMatchSeeker {
	private Graph graph;
	private Map<Integer, Set<SnakeReference>> generatedSnakes;
	
	public SnakeMatchSeeker(Graph graph) {
		this.graph = graph;
		generatedSnakes = new ConcurrentHashMap<>();
	}

	public SnakeMatch findMatch(){
		return graph.getMatrixNodes().parallelStream()
				.map(this::checkForMatch)
				.filter(Objects::nonNull)
				.findAny()
				.orElseThrow(NoSuchElementException::new);
	}
	
	private SnakeMatch checkForMatch(Node node){
		for(int reference = 0; reference < Kernel.KERNEL.size(); reference++){
			SnakeMatch match = checkForMatch(node, reference);
			if(match != null){
				return match;
			}
		}
		return null;
	}
	
	private SnakeMatch checkForMatch(Node position, Integer reference) {
		try {
			Snake generatedSnake = new SnakeReference(graph, position, reference).getSnake();
			synchronized(generatedSnake.getWeight()){
				Set<SnakeReference> otherSnakesWithSameWeight = generatedSnakes.get(generatedSnake.getWeight());
				if(otherSnakesWithSameWeight == null){
					otherSnakesWithSameWeight = Collections.synchronizedSet(new HashSet<>());
					otherSnakesWithSameWeight.add(new SnakeReference(graph, position, reference));
					generatedSnakes.put(generatedSnake.getWeight(), otherSnakesWithSameWeight);
				} else {
					otherSnakesWithSameWeight.add(new SnakeReference(graph, position, reference));
					Optional<SnakeReference> matchingSnake = 
					otherSnakesWithSameWeight.stream().filter(snakeReference -> Collections.disjoint(snakeReference.getNodes(), generatedSnake.getNodes())).findAny();
					if(matchingSnake.isPresent()){
						return new SnakeMatch(generatedSnake, matchingSnake.get().getSnake());
					} 
				}
			}
			return null;
		} catch(ArrayIndexOutOfBoundsException e){
			return null;
		}
	}
}
