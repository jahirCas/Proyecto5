package PktProyecto5;

public class CalculosdeRecorrido {
    CalculosdeRecorrido nodoizquierdo;
    int datos;
    CalculosdeRecorrido nododerecho;
    public CalculosdeRecorrido(int datosNodo)
    {
        datos = datosNodo;
        nodoizquierdo = nododerecho = null; 
    }
    
    public synchronized void insertar(int valorInsertar)
    {
        if(valorInsertar < datos)
        {
            if(nodoizquierdo == null)
                nodoizquierdo = new CalculosdeRecorrido(valorInsertar);
            else    
                nodoizquierdo.insertar(valorInsertar);
        }
        
        else if(valorInsertar > datos)
        {
            if(nododerecho == null)
                nododerecho = new CalculosdeRecorrido(valorInsertar);
            else
                nododerecho.insertar(valorInsertar);
        }
    } 
}

class Arbol
{
    private CalculosdeRecorrido raiz;
    public Arbol()
    {
        raiz = null;
    }

    public synchronized void insertarNodo(int valorInsertar)
    {
        if(raiz == null)
            raiz = new CalculosdeRecorrido(valorInsertar); 
        else
            raiz.insertar(valorInsertar);     
    }

    public synchronized void recorridoPreorden()
    {
        ayudantePreorden(raiz);
    }
  
    
    private void ayudantePreorden(CalculosdeRecorrido nodo)
    {
        if(nodo == null)
            return;
        
        System.out.print(nodo.datos + " ");     
        ayudantePreorden(nodo.nodoizquierdo);   
        ayudantePreorden(nodo.nododerecho);     
    }
    
    //EMPEZAR RECORRIDO INORDEN
    public synchronized void recorridoInorden()
    {
        ayudanteInorden(raiz);
    }
    private void ayudanteInorden( CalculosdeRecorrido nodo)
    {
        if(nodo == null)
            return;
        
        ayudanteInorden(nodo.nodoizquierdo);
        System.out.print(nodo.datos + " ");
        ayudanteInorden(nodo.nododerecho);
    }
    public synchronized void recorridoPosorden()
    {
        ayudantePosorden(raiz);        
    }

    private void ayudantePosorden(CalculosdeRecorrido nodo)
    {
        if( nodo == null )
            return;
        
        ayudantePosorden(nodo.nodoizquierdo);
        ayudantePosorden(nodo.nododerecho);
        System.out.print(nodo.datos + " ");
    }
}
