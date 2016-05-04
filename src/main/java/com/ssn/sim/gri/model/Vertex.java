package com.ssn.sim.gri.model;

import java.util.HashSet;
import java.util.Set;

public class Vertex {
	
	public static int INFINITY = 1000000000;
	public static String DESCRIPTION = "knoten";
	
	private String name;
	private Set<Vertex> neighbors = new HashSet<Vertex>();
	private int color = INFINITY;
	
	public Vertex(String name){
		this.name = name;
	}
	
	public Vertex(String name, int color){
		this.name = name;
		this.color = color;
	}
	
	public static Vertex init(String line) throws Exception{
		String [] splitted = line.split(" ");
		if(splitted.length == 2){
			return new Vertex(splitted[1]);
		}else if(splitted.length >= 3){
			return new Vertex(splitted[1], Integer.valueOf(splitted[2]));
		}else{
			throw new Exception("Vertex formation is not correct. Vertex [" + line + "]");
		}
	}
	
	public String getName(){
		return name;
	}
	
	public int getColor(){
		return color;
	}
	
	public void setColor(int color){
		this.color = color;
	}
		
	public Set<Vertex> getNeighbors() {
		return neighbors;
	}
	
	public Set<Integer> getNeighborColors(){
		Set<Integer> colors = new HashSet<Integer>();
		for(Vertex vertex : getNeighbors()){
			colors.add(vertex.getColor());
		}
		return colors;
	}
	
	public void addNeighbor(Vertex vertex){
		neighbors.add(vertex);
	}
	
	@Override
	public String toString(){
		return new StringBuilder().append("[")//
				.append("Name:").append(getName()).append(", ")//
				.append("Color:").append(getColor())//
				.append("]").toString();
	}

}
