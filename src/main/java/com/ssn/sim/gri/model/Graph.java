package com.ssn.sim.gri.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.ListenableGraph;
import org.jgrapht.graph.ListenableDirectedWeightedGraph;

public class Graph {
	
	public String path;
	
	public List<Vertex> vertexes;
	public List<Edge> edges;
	
	public List<Vertex> getNodes() {
		return vertexes;
	}

	public List<Edge> getEdges() {
		return edges;
	}
	
	public String getPath(){
		return path;
	}
	
	public String getFileName(){
		return new File(path).getName();
	}
	
	public ListenableGraph<String, Edge> buildGraph() {
        ListenableDirectedWeightedGraph<String, Edge> graph = 
            new ListenableDirectedWeightedGraph<String, Edge>(Edge.class);
        for(Vertex vertex : vertexes){
        	graph.addVertex(vertex.getName());
        }
        
        for(Edge edge : edges){
        	Edge e = graph.addEdge(edge.getStart(), edge.getEnd());
        	graph.setEdgeWeight(e, edge.getWeight());
        }
        return graph;
    }
	
	public void readInFromTxTDoc(String path){
		this.path = path;
		vertexes = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
		
	    try(BufferedReader br = new BufferedReader(new FileReader(path))) {
	    	br.lines()
	    	.filter(line -> {
	            return !line.startsWith("#") && !line.isEmpty();
	        })
	        .forEach(line -> {
	        	if(line.contains(Vertex.DESCRIPTION)){
	    			try {
	    				vertexes.add(Vertex.init(line));
					} catch (Throwable t) {
						t.printStackTrace();
					}
	    		}
	    		if(line.contains(Edge.DESCRIPTION)){
	    			try{
	    				edges.add(Edge.init(line));
		    		} catch (Throwable t) {
						t.printStackTrace();
					}
	    		}
	        });
	    }catch(Throwable t){
	    	t.printStackTrace();
	    }
	}
}
