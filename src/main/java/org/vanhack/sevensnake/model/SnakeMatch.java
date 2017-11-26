package org.vanhack.sevensnake.model;

public class SnakeMatch {

	private Snake first;
	private Snake second;
	
	public SnakeMatch(Snake first, Snake second) {
		super();
		this.first = first;
		this.second = second;
	}
	
	public Snake getSecond() {
		return second;
	}
	public Snake getFirst() {
		return first;
	}
	
	@Override
	public String toString() {
		return new StringBuilder("SnakeMatch[\n\tfirst=").append(first).append("\n\tsecond=").append(second).append("\n]").toString();
	}
}
