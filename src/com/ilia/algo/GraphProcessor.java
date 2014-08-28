package com.ilia.algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.Query;

public class GraphProcessor {
	private Graph myGraph = null;
	
	boolean visited[];
	int		path[];
	
	GraphProcessor(Graph g) {
		myGraph = g;
		int iNumOfVertexes = g.getNumVertexes();
		visited = new boolean[iNumOfVertexes];
		path 	= new int[iNumOfVertexes];
		Reset();
	}
	
	void Reset()
	{
		int iNumOfVertexes = myGraph.getNumVertexes();
		for (int i = 0; i < iNumOfVertexes; i++) {
			visited[i] = false;
			path[i] = -1;			
		}
	}
	
/*
 	boolean isConnected (int v1, int v2)
 	{
		
	}
*/
	
	private void depthFirstPath(int v)
	{
		visited[v] = true;
		for ( int vertex : myGraph.getAdjacencyListOfVertex(v))
		{
			if (visited[vertex] == false)
			{
				depthFirstPath(vertex);
				path[vertex] = v;
			}
			
		}
	}
	
	private void breadthFirstPath(int source)
	{
		MyQueue<Integer> q = new MyQueue<Integer>();
		
		q.enqueue(source);
		visited[source] = true;
		
		while (!q.isEmpty())
		{
			int v = q.dequeue().intValue();
			for (int vertex : myGraph.getAdjacencyListOfVertex(v))
			{
				if (!visited[vertex])
				{
					q.enqueue(vertex);
					visited[vertex] = true;
					path[vertex] = v;					
				}
			}
		}
	}
	
	Iterable<Integer> pathDFP (int v1, int v2)
	{
		Reset();
		depthFirstPath(v1);
		List<Integer> temp = new ArrayList<Integer>();

		int source = v2;
		int target = -1;
		
		temp.add(source);
		do
		{
			target = path[source];
			source = target;
			temp.add(source);
			if (target == -1)
				return null;
		}while (target != v1 );
		
		return temp;
	}
	Iterable<Integer> pathBFP (int v1, int v2)
	{
		Reset();
		breadthFirstPath(v1);
		List<Integer> temp = new ArrayList<Integer>();

		int source = v2;
		int target = -1;
		
		temp.add(source);
		do
		{
			target = path[source];
			source = target;
			temp.add(source);
			if (target == -1)
				return null;
		}while (target != v1 );
		
		return temp;
	}
}
