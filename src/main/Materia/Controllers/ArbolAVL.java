package main.Materia.Controllers;

import main.Materia.Controllers.Models.Node;

public class ArbolAVL {
    private Node root;

    public void insert(int value) {
        System.out.println("Nodo a insertar: " + value);
        root = insert(root, value);
        printTree();
    }
    private Node insert(Node node, int value){

        if (node == null) {
            Node newNode= new Node(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado: " + newNode.getValue() + ", Altura: " + newNode.getHeight());
            return newNode;
            
        }
        if(value < node.getValue()){
            node.setLeft(insert(node.getLeft(), value));

        }
        else if(value > node.getValue()){
            node.setRight(insert(node.getRight(), value));
        }
        else{
            return node;
        }
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        //Obtener el factor de balance
        int balance = getBalance(node);
        System.out.println("Balance nodo " + node.getValue() + ": " + balance);
        System.out.println("Altura nodo " + node.getValue() + ": " + node.getHeight());

        //Caso Izquierda Izquierda  
        if (balance > 1 && value < node.getLeft().getValue()) {
            System.out.println("Rotación derecha en el nodo " + node.getValue() + " (Caso Izquierda Izquierda)");
            return rightRotate(node);
                        
                        
        }
        //Caso Derecha Derecha  
        if (balance < -1 && value > node.getRight().getValue()) {
            System.out.println("Rotación izquierda en el nodo " + node.getValue() + " (Caso Derecha Derecha)");
            return leftRotate(node);
                        
        }
        //Caso Izquierda Derecha
        if (balance > 1 && value > node.getLeft().getValue()) {
            System.out.println("Rotación izquierda en el nodo " + node.getLeft().getValue() + " (Caso Izquierda Derecha)");
            node.setLeft(leftRotate(node.getLeft()));
            return rightRotate(node);

                        
        }
        //Caso Derecha Izquierda
        if (balance < -1 && value < node.getRight().getValue()) {
            System.out.println("Rotación derecha en el nodo " + node.getRight().getValue() + " (Caso Derecha Izquierda)");
            node.setRight(rightRotate(node.getRight()));
            return leftRotate(node);
                        
        }
            
        return node;
    }
    private Node rightRotate(Node y) {
        Node x = y.getLeft();   
        Node temp = x.getRight();

        //System.out.println("Rotacion a la derecha: " + y.getValue());

        //Realizar la rotacion
        x.setRight(y);  
        y.setLeft(temp);

        //Actualizar las alturas
        System.out.println("Altura del nodo: "+ y.getHeight());
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight()))+1);
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight()))+1);

        

        System.out.println("Nueva raiz despues de la rotacion: "+ x.getValue());

        return x;



    }
    private Node leftRotate(Node x) {
        Node y = x.getRight();   
        Node temp = y.getLeft();

        System.out.println("Rotacion a la derecha: " + x.getValue()+ " Balance: "+ y.getValue());

        //Realizar la rotacion
        x.setLeft(x);  
        y.setRight(temp);

        //Actualizar las alturas
        x.setHeight(Math.max(height(x.getLeft()), height(x.getRight()))+1);
        y.setHeight(Math.max(height(y.getLeft()), height(y.getRight()))+1);

        System.out.println("Nueva raiz despues de la rotacion izquierda: "+ y.getValue());

        return y;



    }
    
    public int height(Node node){
        if(node == null){
            return 0;
        }
        return node.getHeight();
    }
    public int getBalance(Node node){
        if(node == null){
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());

    }

 
   public void printTree() {
    printTree(root, "", true);
}


public void printTree(Node root, String prefix, boolean isLeft) {
    if (root != null) {
        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.getValue());
        if (root.getLeft() != null || root.getRight() != null) {
            if (root.getLeft() != null) {
                printTree(root.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
            } else {
                System.out.println(prefix + (isLeft ? "│   " : "    ") + "├── null");
            }
            if (root.getRight() != null) {
                printTree(root.getRight(), prefix + (isLeft ? "│   " : "    "), false);
            } else {
                System.out.println(prefix + (isLeft ? "│   " : "    ") + "└── null");
            }
        }
    }
}
    
}
