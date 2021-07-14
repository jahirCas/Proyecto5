package PktProyecto5;
import java.util.ArrayList;
public class ClsCalculos {

    public int[][] g = 
    	{{0, 1, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0}};
    private boolean[] visitiadoAnchura = new boolean[5];
    private boolean[] visitiadoProfunidad = new boolean[5];

    public ClsCalculos() {
    }

    public int[][] getG() {
        return g;
    }

public ArrayList<Integer> recorridoAnchura(int nodoI) {
//Lista donde guardo los nodos recorridos
        ArrayList<Integer> recorridos = new ArrayList<Integer>();
//El nodo inicial ya está visitado
        visitiadoAnchura[nodoI] = true;
//Cola de visitas de los nodos adyacentes
        ArrayList<Integer> cola = new ArrayList<Integer>();
//Se lista el nodo como ya recorrido
        recorridos.add(nodoI);
//Se agrega el nodo a la cola de visitas
        cola.add(nodoI);
//Hasta que visite todos los nodos
        while (!cola.isEmpty()) {
            int j = cola.remove(0); //Se saca el primero nodo de la cola
//Se busca en la matriz que representa el grafo los nodos adyacentes
            for (int i = 0; i < g.length; i++) {
//Si es un nodo adyacente y no está visitado entonces
                if (g[j][i] == 1 && !visitiadoAnchura[i]) {
                    cola.add(i);//Se agrega a la cola de visitas
                    recorridos.add(i);//Se marca como recorrido
                    visitiadoAnchura[i] = true;//Se marca como visitado
                }
            }
        }
        return recorridos;//Devuelvo el recorrido del grafo en anchura
    }

    public ArrayList<Integer> recorridoProfunidad(int nodoI) {
//Lista donde guardo los nodos recorridos
        ArrayList<Integer> recorridos = new ArrayList<Integer>();
        visitiadoProfunidad[nodoI] = true;//El nodo inicial ya está visitado
//Cola de visitas de los nodos adyacentes
        ArrayList<Integer> cola = new ArrayList<Integer>();
        recorridos.add(nodoI);//Listo el nodo como ya recorrido
        cola.add(nodoI);//Se agrega el nodo a la cola de visitas
        while (!cola.isEmpty()) {//Hasta que visite todos los nodos
            int j = cola.remove(0);//Se saca el primer nodo de la cola
    //Se busca en la matriz que representa el grafo los nodos adyacentes
            for (int i = 0; i < g.length; i++) {
//Si es un nodo adyacente y no está visitado entonces
                if (g[j][i] == 1 && !visitiadoProfunidad[i]) {
                    cola.add(i);//Se agrega a la cola de visita
//Se recorren los hijos del nodo actual de visita y se agrega el recorrido al la lista
                    recorridos.addAll(recorridoProfunidad(i));
                    visitiadoProfunidad[i] = true;//Se marca como visitado
                }
            }
        }
        return recorridos;//Se devuelve el recorrido del grafo en profundidad
    }
    
    
    
    
    
    
}