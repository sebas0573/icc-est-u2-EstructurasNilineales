
import java.util.List;

import main.Ejercicio_01_insert.InsertBSTTest;
import main.Ejercicio_02_invert.InvertBinaryTree;
import main.Ejercicio_03_listLeves.ListLeves;
import main.Ejercicio_04_depth.Depth;
import main.Materia.Controllers.ArbolAVL;
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolRecorridos;
import main.Materia.Controllers.Models.Node;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        //runArbolBinario();

        Node root = new Node(7);
        root.setLeft(new Node(5));
        root.setRight(new Node(4));
        root.getLeft().setLeft(new Node(8));
        root.getLeft().setRight(new Node(3));
        
        ListLeves list = new ListLeves();
        
        
        List<List<Node>> niveles = list.listLeves(root);
        
        
        if (niveles != null) {
           
            for (List<Node> level : niveles) {
                for (Node node : level) {
                    System.out.print(node.getValue() + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("El árbol está vacío.");
        }
        runArbolAVL();

        // Ejercicio 1
        System.out.println("Ejercicio 01: Insertar en un BST");
        InsertBSTTest bstTest = new InsertBSTTest();
        //Node root = null;
        int[] values = {5, 3, 7, 2, 4, 6, 8};
        for (int value : values) {
            root = bstTest.insert(root, value);
        }
        printTree(root);
        System.out.println();

        // Ejercicio 2
        System.out.println("Ejercicio 02: Invertir un Árbol Binario");
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        root = invertBinaryTree.invertTree(root);
        printTree(root);
        System.out.println();

        // Ejercicio 4
        System.out.println("Ejercicio 04: Calcular Profundidad Máxima");
        Depth depth = new Depth();
        int maxDepth = depth.maxDepth(root);
        System.out.println("La profundidad máxima del árbol es: " + maxDepth);
    }

    private static void printTree(Node root) {
        printTreeHelper(root, "", true);
    }

    private static void printTreeHelper(Node root, String prefix, boolean isLeft) {
        if (root != null) {
            System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.value);
            printTreeHelper(root.left, prefix + (isLeft ? "│   " : "    "), true);
            printTreeHelper(root.right, prefix + (isLeft ? "│   " : "    "), false);
        }
    }

    public static void runArbolBinario(){
        ArbolBinario arbol = new ArbolBinario();
        ArbolRecorridos recorridos = new ArbolRecorridos();
        int [] valores = {40, 20, 60, 10, 30 ,50, 70, 5, 15, 55};

        for(int value : valores){
            arbol.insert(value);


        }

        arbol.printTree();

        System.out.println("Recorrido PreOrden");
        recorridos.preOrderRecursivo(arbol.getRoot());
        System.out.println("\nRecorrido PosOrden");
        recorridos.posOrdenRecursivo(arbol.getRoot());
        System.out.println("\nRecorrido InOrden");
        recorridos.inOrdenRecursivo(arbol.getRoot());
    }

    public static void runArbolAVL() {
        ArbolAVL avl = new ArbolAVL();
        int[] valores = { 10, 20, 15, 24, 9, 8, 21, 23, 50, 25 };

        for (int value : valores) {
            avl.insert(value);
        }
    }

}
