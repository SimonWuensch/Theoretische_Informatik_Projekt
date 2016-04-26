package com.ssn.sim.gri.helper;

import javax.swing.JFrame;

import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphXAdapter;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.ssn.sim.gri.model.Edge;
import com.ssn.sim.gri.model.Graph;

public class GraphVisualizationHelper {
	public static void createAndShowGui(Graph graph) {
		System.out.println("Create and Show Gui ...");
		JFrame frame = new JFrame(graph.getFileName() + " Graph");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ListenableGraph<String, Edge> listenableGraph = graph.buildGraph();
		JGraphXAdapter<String, Edge> graphAdapter = new JGraphXAdapter<String, Edge>(listenableGraph);

		mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
		layout.execute(graphAdapter.getDefaultParent());

		frame.add(new mxGraphComponent(graphAdapter));

		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
}