package main;

import java.util.*;

public class FindingPath {
    // Create a model for each Node in graph
    static class Edge {
        int from, to;
        public Edge(int f, int t) {
            from = f;
            to = t;
        }
    }

    private static Map<Integer, Integer> initilizeValueForVertice(int numNodes, Map<Integer, Integer> valueMap) {
        for (int i = 0; i < numNodes; i++) {
            valueMap.put(i, i+1);
        }
        return valueMap;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
    	// user select 2 dag to test
        Scanner sc = new Scanner(System.in); 
        System.out.print("please select dag for test (5 nodes or 8 nodes): ");
        int numNodes = sc.nextInt();
        if (numNodes != 5 && numNodes != 8) {
        	System.out.println("Wrong value");
        	sc.close();
        	return;
        }
        // Graph setup
        Map<Integer, List<Edge>> graph = buildDAG(numNodes);
        Map<Integer, Integer> valueMap = new HashMap<Integer, Integer>();
        initilizeValueForVertice(numNodes, valueMap);

        // find the shortest path from 0 -> 7
        Integer[] dists = dagShortestPath(graph, 0, numNodes, valueMap);
        System.out.println(java.util.Arrays.toString(dists));
        sc.close();
    }
    
    /**
     * Function add edge to map
     * @param numNodes
     * @return
     */
    public static Map<Integer, List<Edge>> buildDAG(int numNodes) {
		Map<Integer, List<Edge>> graph = new HashMap<Integer, List<Edge>>();
		for (int i = 0; i < numNodes; i++) {
			graph.put(i, new ArrayList<>());
		}
		if (numNodes == 5) {
			graph.get(0).add(new Edge(0, 1));
			graph.get(0).add(new Edge(0, 2));
			graph.get(1).add(new Edge(1, 2));
			graph.get(2).add(new Edge(2, 3));
			graph.get(2).add(new Edge(2, 4));
			graph.get(3).add(new Edge(3, 4));
		} else {
			graph.get(0).add(new Edge(0, 1));
		    graph.get(0).add(new Edge(0, 2));
		    graph.get(1).add(new Edge(1, 2));
			graph.get(1).add(new Edge(1, 3));
			graph.get(1).add(new Edge(1, 4));
			graph.get(2).add(new Edge(2, 3));
			graph.get(2).add(new Edge(2, 6));
			graph.get(3).add(new Edge(3, 4));
			graph.get(3).add(new Edge(3, 5));
			graph.get(3).add(new Edge(3, 6));
			graph.get(4).add(new Edge(4, 7));
			graph.get(5).add(new Edge(5, 7));
			graph.get(6).add(new Edge(6, 7));
		}
		return graph;
    }

    // Finds a topological ordering of the nodes in a Directed Acyclic Graph (DAG)
    public static int[] topologicalSort(Map<Integer, List<Edge>> graph, int numNodes) {
        int[] ordering = new int[numNodes];
        boolean[] visited = new boolean[numNodes];
        int i = numNodes - 1;
        for (int at = 0; at < numNodes; at++)
            if (!visited[at])
                i = dfs(i, at, visited, ordering, graph);
        return ordering;
    }

    // deepth first search
    private static int dfs(int i, int at, boolean[] visited, int[] ordering, Map<Integer, List<Edge>> graph) {
        visited[at] = true;
        List<Edge> edges = graph.get(at);
        if (edges != null)
            for (Edge edge : edges)
                if (!visited[edge.to])
                    i = dfs(i, edge.to, visited, ordering, graph);
        ordering[i] = at;
        return i - 1;
    }

    // find shortest path for each node
    public static Integer[] dagShortestPath(Map<Integer, List<Edge>> graph, int start, int numNodes, Map<Integer, Integer> valueMap) {
        int[] topsort = topologicalSort(graph, numNodes);
        Integer[] dist = new Integer[numNodes];
        dist[start] = valueMap.get(0);
        for (int i = 0; i < numNodes; i++) {
            int nodeIndex = topsort[i];
            if (dist[nodeIndex] != null) {
                List<Edge> adjacentEdges = graph.get(nodeIndex);
                if (adjacentEdges != null) {
                    for (Edge edge : adjacentEdges) {
                        int newDist = dist[nodeIndex] + valueMap.get(edge.to);
                        if (dist[edge.to] == null)
                            dist[edge.to] = newDist;
                        else {
                            dist[edge.to] = Math.max(dist[edge.to], newDist);
                        }
                    }
                }
            }
        }
        return dist;
    }
}