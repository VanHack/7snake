package org.vanhack.sevensnake.model;

import java.util.Objects;
import java.util.stream.Stream;

public class Node {
	
	private Integer x; 
	private Integer y;
	
	public Node(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}
	
	public Integer getX() {
		return x;
	}
	public Integer getY() {
		return y;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(x,y);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof Node) ){
			return false;
		}
		Node other = (Node) obj;
		return Objects.equals(x, other.x) && 
				Objects.equals(y, other.y);
	}
	
	public Node add(Node node){
		return new Node(x + node.x, y + node.y);
	}
	
	public Node atLeft() {
		return new Node(x-1, y);
	}
	
	public Node atRight() {
		return new Node(x+1, y);
	}
	
	public Node atTop(){
		return new Node(x, y - 1);
	}
	
	public Node atBottom(){
		return new Node(x, y + 1);
	}
	
	public Stream<Node> getAdjacent(){
		return Stream.of( atTop(), atLeft(), atRight(), atBottom() );
	}
	
	@Override
	public String toString() {
		return new StringBuilder("[ x=").append(x).append(",y=").append(y).append("]").toString();
	}
}
