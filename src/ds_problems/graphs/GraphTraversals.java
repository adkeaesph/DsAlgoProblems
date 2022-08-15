package ds_problems.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GraphTraversals {

	public static <T> List<T> dfsTraversal(AdjacencyListGraph<T> graph) {
		boolean[] visited = new boolean[graph.getNumberOfVertices()];
		List<T> outputList = new ArrayList<>();
        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(graph, 0, visited, outputList);
        return outputList;
	}
	
	

	private static <T> void DFSUtil(AdjacencyListGraph<T> graph, int indexOfCurrentVertex, boolean[] visited, List<T> outputList) {
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



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
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
		
		AdjacencyListGraph<Character> graph2 = new AdjacencyListGraph<>();
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
