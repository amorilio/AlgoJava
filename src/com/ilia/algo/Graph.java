package com.ilia.algo;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private int iNumVertexes;
	private List<Integer>[] adjacencyList;
	
	public Graph(int iVertexes)
	{
		this.iNumVertexes = iVertexes;
		adjacencyList = new ArrayList[iVertexes];
		for ( int i = 0; i < iNumVertexes; i++ )
		{	
			adjacencyList[i] = new ArrayList<Integer>();
		}
	}

	public void addEdge(int v, int w)
	{
		adjacencyList[v].add(w);
		adjacencyList[w].add(v);
	}
	
	public Iterable<Integer> getAdjacencyListOfVertex(int v)
	{
		return adjacencyList[v];
	}
	
	public int getNumVertexes() {
		return iNumVertexes;
	}

	public int vertexDegree(int v)
	{
		int degree = 0;
		for (int w : adjacencyList[v]) degree++;
		return degree;
	}
	
	public int numGraphEdges()
	{		
		int iEdges = 0;
		for(int v = 0; v < adjacencyList.length; v++ )
		{
			int degree=0;
			for (int w : adjacencyList[v]) degree++;
			iEdges += degree;
		}
		return iEdges;
	}
	
	public int maxGraphDegree(int iVertex, int iMaxDegree)
	{		
		iVertex = 0;
		iMaxDegree = 0;
		for(int v = 0; v < adjacencyList.length; v++ )
		{
			int degree=0;
			for (int w : adjacencyList[v]) degree++;
			if (degree > iMaxDegree)
			{
				iMaxDegree = degree;
				iVertex = v; 
			}
		}
		return iMaxDegree;
	}
	
	public int avgGraphDegree()
	{
		return 2 * numGraphEdges() / getNumVertexes();
	}
}
