package com.ssn.sim.gri.model;

import com.google.gson.Gson;

public class Vertex {
	
	public static String DESCRIPTION = "knoten";
	
	private String name;
	private int color = 100000000;
	
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
	
	public int getData(){
		return color;
	}
	
	@Override
	public String toString(){
		return new Gson().toJson(this);
	}

}
