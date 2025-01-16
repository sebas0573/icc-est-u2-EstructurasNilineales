package main.Ejercicio_01_insert;

import main.Materia.Controllers.Models.Node;

public class InsertBSTTest {
    public Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        }

        return root;
    }
}

