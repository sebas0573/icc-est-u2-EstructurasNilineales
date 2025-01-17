package main.Materia.Controllers.Models;

import java.util.LinkedList;
import java.util.List;

public class NodeGraph {

    private int value;
    private List<NodeGraph> neighbors;

    public NodeGraph(int value) {
        this.value = value;
        this.neighbors = new LinkedList<>();
    }

    public int getValue() {
        return value;
    }

    public List<NodeGraph> getNeighbors() {
       return neighbors;
    }

    
    public void addNeighbor(NodeGraph neighbor) {
        this.neighbors.add(neighbor);
    }


    
}
