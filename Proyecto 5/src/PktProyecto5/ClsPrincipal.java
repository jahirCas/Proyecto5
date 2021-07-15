package PktProyecto5;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
public class ClsPrincipal {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        int valor;
        int Dato;
        int cont=0;
        Dato = 5;
        int n = Dato;
        //Personalizacion de la ventana
    	UIManager UI=new UIManager();
    	UI.put("OptionPane.background",new Color (152, 203, 220 ));UI.put("Panel.background", new Color(106, 194, 222));
    	//Inicio
    	CalculosdeProfundidadyAnchura g=new CalculosdeProfundidadyAnchura();
        ArrayList<Integer> enAnchura=g.recorridoAnchura(0);//Nodo inicial 0
        JTextArea areaTexto = new JTextArea("");
      //Definir color del option pane
        areaTexto.setBackground(new Color(106, 194, 222));
		Font font = new Font("", Font.PLAIN, 13);
		areaTexto.setFont(font);
		areaTexto.setEditable(false);
		 areaTexto.append("Busqueda en Profundidad y Anchura\n\n");
        areaTexto.append("Recorrido en anchura a partir de la matriz:\n");
        for(int i=0;i<enAnchura.size();i++){
        	areaTexto.append(""+enAnchura.get(i)+"\n");
        	
        }
        ArrayList<Integer> enProfundidad=g.recorridoProfunidad(0);//Nodo inicial 0
        areaTexto.append("");
        areaTexto.append("Recorrido en profundidad a partir de la matriz:\n");
        for(int i=0;i<enProfundidad.size();i++){
        	areaTexto.append(""+enProfundidad.get(i)+"\n");
        }
        //Recorridos
        areaTexto.append("Con los valores de la matriz de adyacencia, se tendran los siguientes recorridos:"
        		+ "\nLos mismos se pueden ver en la consola: ");
        for(int i = 1; i <= n; i++ )
        {
            Dato = cont;
            valor = Dato;
          //  areaTexto.append(valor + " ");
            arbol.insertarNodo(valor);
            cont=cont+1;
        }
        System.out.println("Recorridos:");
        System.out.println("\nRecorrido Preorden");
        arbol.recorridoPreorden();
        
        System.out.println("\n\nRecorrido Inorden");
        arbol.recorridoInorden();
        
        System.out.println("\n\nRecorrido Postorden");
        arbol.recorridoPosorden();
        JOptionPane.showMessageDialog(null, areaTexto,"Busqueda y Recorrido",1);
    }
}
