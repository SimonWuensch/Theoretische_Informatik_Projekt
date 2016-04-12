package com.ssn.sim.gri;

import javax.swing.SwingUtilities;

import com.ssn.sim.gri.helper.GraphVisualizationHelper;
import com.ssn.sim.gri.model.Graph;

public class test {
	
	private static String path = "E:/Benutzer/Simon/Dropbox/Studium/Master/Semester/2. Semester/Theoretische Informatik/Übungsblätter/01_Übungsblatt/Graphen/";
	
	public static void main (String [] args){
		test.doIt(path, "Euler1.txt");
		test.doIt(path, "Euler2.txt");
		test.doIt(path, "Dijkstra.txt");
	}
	
	public static void doIt(String path, String fileName){
		Graph graph = new Graph();
		graph.readInFromTxTDoc(path + fileName);
		System.out.println(fileName + ": " + graph.getNodes().size() + " - " + graph.getEdges().size());
		
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                GraphVisualizationHelper.createAndShowGui(graph);
	            }
	        });
	}

}
