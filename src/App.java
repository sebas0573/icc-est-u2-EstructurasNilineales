
import java.util.List;

import main.Ejercicio_03_listLeves.ListLeves;
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

}
