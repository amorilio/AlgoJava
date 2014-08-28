package com.ilia.algo;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Graph myGraph = new Graph (5);
		
		myGraph.addEdge(0, 2);
		myGraph.addEdge(0, 3);
		myGraph.addEdge(0, 1);
		myGraph.addEdge(1, 2);
		myGraph.addEdge(1, 3);
		myGraph.addEdge(1, 4);
		myGraph.addEdge(2, 3);
		myGraph.addEdge(2, 4);
		
		for (int v = 0; v < myGraph.getNumVertexes(); v++)
			for (int w : myGraph.getAdjacencyListOfVertex(v))
				System.out.println(v + "-" + w);

		int iMaxDegree = 0;
		int iVert = 0;
		myGraph.maxGraphDegree(iVert, iMaxDegree);
		System.out.println("Max Degree :" + iMaxDegree + " vertex : "+ iVert);
		
		System.out.println("Vertex 3 degree is :" + myGraph.vertexDegree(3));
		
		
		GraphProcessor myGraphProcessor = new GraphProcessor(myGraph);
		
        Iterator<Integer> iterator;
        System.out.println("=== Path from 0 to 4 using Depth First Path   ===");
        iterator = myGraphProcessor.pathDFP(0, 4).iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        System.out.println("=== Path from 0 to 4 using Breadth First Path ===");
        iterator = myGraphProcessor.pathBFP(0, 4).iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        
	}

}
