package com.ssn.sim.gri.model;

import org.jgrapht.graph.DefaultWeightedEdge;

public class Edge extends DefaultWeightedEdge{
	private static final long serialVersionUID = -7401434638914369819L;

	public static String DESCRIPTION = "kante";
	
	private String start;
	private String end;
	private int weight = 1;
	
	public Edge(){
		super();
	}
	
	public Edge(String start, String end){
		this.start = start;
		this.end = end;
	}
	
	public Edge(String start, String end, int weigth){
		this.start = start;
		this.end = end;
		this.weight = weigth;
	}
	
	public static Edge init(String line) throws Exception{
		String [] splitted = line.split(" ");
		if(splitted.length == 3){
			return new Edge(splitted[1], splitted[2]);
		}else if(splitted.length >= 4){
			return new Edge(splitted[1], splitted[2], Integer.parseInt(splitted[3]));
		}else{
			throw new Exception("Edge formation is not correct. Edge [" + line + "]");
		}
	}
	
	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString(){
		return String.valueOf(getWeight());
	}
}
