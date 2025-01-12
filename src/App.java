
import main.Materia.Controllers.ArbolBinario;
import main.Materia.Controllers.ArbolRecorridos;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        runArbolBinario();
       

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
