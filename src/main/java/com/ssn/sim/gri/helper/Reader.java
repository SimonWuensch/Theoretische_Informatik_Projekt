package com.ssn.sim.gri.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.ssn.sim.gri.model.Edge;
import com.ssn.sim.gri.model.Graph;
import com.ssn.sim.gri.model.Vertex;

public class Reader {
	
	public static Graph readInFromTxTDoc(String path) {
		List<Vertex> vertexes = new ArrayList<Vertex>();
		List<Edge> edges = new ArrayList<Edge>();
		Graph graph = new Graph(path, vertexes, edges);
		String fileName = new File(path).getName();
		
		System.out.println("Reading in txt doc from [" + fileName + "]...");

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			br.lines().filter(line -> {
				return !line.startsWith("#") && !line.isEmpty();
			}).forEach(line -> {
				if (line.contains(Vertex.DESCRIPTION)) {
					try {
						vertexes.add(Vertex.init(line));
					} catch (Throwable t) {
						t.printStackTrace();
					}
				}
				if (line.contains(Edge.DESCRIPTION)) {
					try {
						edges.add(Edge.init(line));
					} catch (Throwable t) {
						t.printStackTrace();
					}
				}
			});
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
		return graph;
	}

}
