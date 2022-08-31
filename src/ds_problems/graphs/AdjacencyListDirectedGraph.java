package ds_problems.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdjacencyListDirectedGraph<T> {
	private List<List<T>> adjacencyList;
	private HashMap<T,Integer> verticesIndexMap;

	public AdjacencyListDirectedGraph() {
		// TODO Auto-generated constructor stub
		adjacencyList = new ArrayList<>();
		verticesIndexMap = new HashMap<>();
	}
	
	public void addVertex(T vertex) {
		List<T> innerList = new ArrayList<>();
		innerList.add(vertex);
		adjacencyList.add(innerList);
		verticesIndexMap.put(vertex, adjacencyList.size() - 1);
	}
	
	public void addEdge(int indexOfVertex1, int indexOfVertex2) {
		adjacencyList.get(indexOfVertex1).add(adjacencyList.get(indexOfVertex2).get(0));
	}
	
	public List<List<T>> getAdjacencyList() {
		return adjacencyList;
	}
	
	public int getIndexOfVertex(T vertex) {
		return verticesIndexMap.get(vertex);
	}

	public void display() {
		for(List<T> listOfConnectedVertices : adjacencyList) {
			boolean firstIndex = true;
			for(T vertex : listOfConnectedVertices) {
				if(firstIndex) {
					System.out.print(vertex + " -> ");
					firstIndex = false;
				}else
					System.out.print(vertex + " , ");
			}
			System.out.println();
		}
	}
	
	public int getNumberOfVertices() {
		return adjacencyList.size();
	}
	
}
