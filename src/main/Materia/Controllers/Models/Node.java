package main.Materia.Controllers.Models;



public class Node {
    public int value;
    public Node left;
    public Node right;
    private int height;
   

    public Node(int value) {
        this.value = value;
        this.height = 1;
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    
}

