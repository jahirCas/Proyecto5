package PktProyecto5;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ClsPrincipal {
    public static void main(String[] args) {
    	ClsCalculos g=new ClsCalculos();
        ArrayList<Integer> enAnchura=g.recorridoAnchura(0);//Nodo inicial 0
        
        System.out.println("Recorrido en anchura a partir de la matriz: ");
        for(int i=0;i<enAnchura.size();i++){
            System.out.print(""+enAnchura.get(i)+"\n");
        }
        ArrayList<Integer> enProfundidad=g.recorridoProfunidad(0);//Nodo inicial 0
        System.out.println("");
        System.out.println("Recorrido en profundidad a partir de la matriz: ");
        for(int i=0;i<enProfundidad.size();i++){
            System.out.print(""+enProfundidad.get(i)+"\n");
        }
    
    
        Arbol arbol = new Arbol();
        int valor;
        String Dato;
        
        System.out.println("Insertando los siguientes valores: ");
        
        Dato = JOptionPane.showInputDialog("Inserta el numero de nodos que desea ingresar");
        int n = Integer.parseInt(Dato);
        
        for(int i = 1; i <= n; i++ )
        {
            Dato = JOptionPane.showInputDialog("Dame el " + i + " valor para colocar en el Arbol");
            valor = Integer.parseInt(Dato);
            System.out.print(valor + " ");
            arbol.insertarNodo(valor);
        }
        
        System.out.println("\n\nRecorrido Preorden");
        arbol.recorridoPreorden();
        
        System.out.println("\n\nRecorrido Inorden");
        arbol.recorridoInorden();
        
        System.out.println("\n\nRecorrido Postorden");
        arbol.recorridoPosorden();
    }
}
