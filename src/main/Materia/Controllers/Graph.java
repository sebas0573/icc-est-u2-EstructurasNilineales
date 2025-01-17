package main.Materia.Controllers;

import java.util.LinkedList;
import java.util.List;
//import java.util.Map;
import java.util.Queue;


import main.Materia.Controllers.Models.NodeGraph;

public class Graph {

    private List<NodeGraph> nodes;

    public Graph(){
        this.nodes = new LinkedList<>();

    }

    //metodo para añadir un nodo
    public NodeGraph addNode(int value){
        NodeGraph nodeGraph = new NodeGraph(value);
        nodes.add(nodeGraph);
        return nodeGraph;
    }

    //metodo para añadir una arista
    public void addEdge(NodeGraph src, NodeGraph dest){
        src.addNeighbor(dest);
        dest.addNeighbor(src);
    }

    //metodo para imprimir el grafo
    public void printGraph(){
        for (NodeGraph nodeGraph : nodes) {
            System.out.print("Vertice: "+nodeGraph.getValue() + " : ");
            for (NodeGraph neighbor : nodeGraph.getNeighbors()) {
                System.out.print(neighbor.getValue() + " - ");
            }
            System.out.println();
        }
    }

    public void getDFS(NodeGraph starNode){
        boolean[] visited = new boolean[nodes.size()];
        getDFSUtil(starNode, visited);
        
    }

    private void getDFSUtil(NodeGraph node, boolean[] visited){
        visited[node.getValue() - 1] = true; 
        System.out.print(node.getValue() + " "); 
        
        
        for (NodeGraph neighbor : node.getNeighbors()) {
            if (!visited[neighbor.getValue() - 1]) { 
                getDFSUtil(neighbor, visited); 
            }
        }
    

    }

    public void getBFS(NodeGraph starNode){
        boolean[] visited = new boolean[nodes.size()];
        Queue<NodeGraph> queue = new LinkedList<>();
        
        queue.add(starNode);
        visited[starNode.getValue() - 1] = true; 
        
        while (!queue.isEmpty()) {
            NodeGraph node = queue.poll();
            System.out.print(node.getValue() + " ");
            
            for (NodeGraph neighbor : node.getNeighbors()) {
                if (!visited[neighbor.getValue() - 1]) { 
                    visited[neighbor.getValue() - 1] = true;
                    queue.add(neighbor);
                }
            }
        }

    }

    public int[] getAdjacencyMatrix(){
        int[][] adjacencyMatrix = new int[nodes.size()][nodes.size()];
        
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                adjacencyMatrix[i][j] = nodes.get(i).getNeighbors().contains(nodes.get(j))? 1 : 0;
            }
        }
        
        return adjacencyMatrix[0]; 

    }

    public void printAdyacencyMatrix(){
        int n = nodes.size(); 
        int[][] adjMatrix = new int[n][n]; 

        
        for (int i = 0; i < n; i++) {
            NodeGraph node = nodes.get(i);
            for (NodeGraph neighbor : node.getNeighbors()) {
                int j = neighbor.getValue() - 1; 
                adjMatrix[i][j] = 1; 
            }
        }

       
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        
    }



    
}
