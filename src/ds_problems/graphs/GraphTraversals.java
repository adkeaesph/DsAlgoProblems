package ds_problems.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GraphTraversals {

	private static <T> List<T> dfsTraversal(AdjacencyListDirectedGraph<T> graph) {
		boolean[] visited = new boolean[graph.getNumberOfVertices()];
		List<T> outputList = new ArrayList<>();
        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(graph, 0, visited, outputList);
        return outputList;
	}

	private static <T> void DFSUtil(AdjacencyListDirectedGraph<T> graph, int indexOfCurrentVertex, boolean[] visited, List<T> outputList) {
		visited[indexOfCurrentVertex] = true;
		
		List<List<T>> adjacencyList = graph.getAdjacencyList();
		List<T> connectedVertices = adjacencyList.get(indexOfCurrentVertex);
		outputList.add(connectedVertices.get(0));
 
        Iterator<T> i = adjacencyList.get(indexOfCurrentVertex).listIterator();
        while (i.hasNext()) {
            T nextVertex = i.next();
            if (!visited[(int)graph.getIndexOfVertex(nextVertex)])
            	DFSUtil(graph, (int)graph.getIndexOfVertex(nextVertex), visited, outputList);
        }
	}


	private static <T> List<T> bfsTraversal(AdjacencyListDirectedGraph<T> graph, int startingNodeIndex) {
		boolean[] visited = new boolean[graph.getNumberOfVertices()];
		List<List<T>> adjacencyList = graph.getAdjacencyList();
		
		List<T> outputList = new ArrayList<>();
		LinkedList<T> queue = new LinkedList<>();
		T startNode = adjacencyList.get(startingNodeIndex).get(0);
		queue.add(startNode);
		visited[(int)graph.getIndexOfVertex(startNode)] = true;
		while(!queue.isEmpty()) {
			T currentNode = queue.pop();
			outputList.add(currentNode);
			int indexOfCurrentNode = graph.getIndexOfVertex(currentNode);
			Iterator<T> i = adjacencyList.get(indexOfCurrentNode).listIterator();
			while(i.hasNext()) {
				T node = i.next();
				if (!visited[(int)graph.getIndexOfVertex(node)]) {
					visited[(int)graph.getIndexOfVertex(node)] = true;
					queue.add(node);
				}
			}
		}
		return outputList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyListDirectedGraph<Integer> graph = new AdjacencyListDirectedGraph<>();
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(2, 4);
		graph.display();
		List<Integer> outputList = dfsTraversal(graph);
		for(Integer vertex : outputList) {
			System.out.print(vertex + " ");
		}
		System.out.println("\n---------------------------");
		
		graph = new AdjacencyListDirectedGraph<>();
		graph.addVertex(0);
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.display();
		
		outputList = bfsTraversal(graph, 2);
		for(Integer vertex : outputList) {
			System.out.print(vertex + " ");
		}
		System.out.println("\n---------------------------");
		
		AdjacencyListDirectedGraph<Character> graph2 = new AdjacencyListDirectedGraph<>();
		graph2.addVertex('a');
		graph2.addVertex('b');
		graph2.addVertex('c');
		graph2.addVertex('d');
		graph2.addVertex('e');
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(0, 3);
		graph2.addEdge(2, 4);
		graph2.display();
		List<Character> outputList2 = dfsTraversal(graph2);
		for(Character vertex : outputList2) {
			System.out.print(vertex + " ");
		}
		System.out.println("\n---------------------------");
	}

}
