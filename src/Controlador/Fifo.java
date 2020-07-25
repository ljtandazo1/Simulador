/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Nodo;

/**
 *
 * @author Davicho
 */
public class Fifo {
    
    public Nodo sig, frente, ultimo;
    public String dato;
    public char matriz[];
    public int marco;
    public int contador = 0;
    public String cadena = "";
    
    public Fifo(int x){
        marco = x;
        matriz = new char[x];
        
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = ' ';
        }
        frente = ultimo = null;
    }
    
    public void Insertar (char x){
        Nodo nuevo;
        if(frente == null){
            nuevo = new Nodo(x, null);
            frente = ultimo = nuevo;
            InsertarM(x);
            cadena = cadena + "fallo";
        }else{
            if(Existe(x)){
                cadena = cadena + "continua";
            }else{
                if(Tamanio()){
                    cadena = cadena + "fallo";
                    InsertarM(x);
                    nuevo = new Nodo(x, null);
                    ultimo.sig = nuevo;
                    ultimo = nuevo;
                }else{
                    cadena = cadena + "fallo";
                    SacarM(Sacar());
                    InsertarM(x);
                    nuevo = new Nodo(x, null);
                    ultimo.sig = nuevo;
                    ultimo = nuevo;
                    contador++;
                }
            }
        }
    }
    
    void InsertarM(char x){
        boolean a = true;
        int i = 0;
        
        while(a){
            if(matriz[i] == ' '){
                matriz[i] = x;
                a = false;
            }
            i++;
        }
    }

    boolean Existe(char x) {
        Nodo aux = frente;
        while(aux != null){
            if(aux.dato == x){
                return true;
            }
            aux = aux.sig;
        }
        return false;
    }

    private boolean Tamanio() {
        boolean a = true;
        int i = 0;
        while(a && i<marco){
            if(matriz[i] == ' '){
                return true;
            }
            i++;
        }
        return false;
    }
    
    void SacarM (char x){
        boolean a = true;
        int i = 0;
        while(a){
            if(matriz[i] == x){
                matriz[i] = ' ';
                a = false;
            }
            i++;
        }
    }

    public char Sacar() {
        Nodo aux = frente;
        frente = frente.sig;
        
        return aux.dato;
    }

    public String [] Imprimir(String [] array) {
        String [] salida = new String [array.length];
        String numero;
        for (int i = 0; i < array.length; i++) {
            if(matriz[i] != ' '){
                //salida = String.valueOf(matriz[i]);
                numero = String.valueOf(matriz[i]);
                salida[i] = numero;
            }
        }
        /*for (int i = 0; i < matriz.length; i++) {
            System.out.println(salida[i]);
        }
        System.out.println("-------");
        */
        return salida;
    }
    
    public int fallos(){
        return contador;
    }
    
    
}
