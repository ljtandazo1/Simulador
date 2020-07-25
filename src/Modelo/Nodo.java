/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Davicho
 */
public class Nodo {
    
    public Nodo sig;
    public char dato;
    
    public Nodo(char x, Nodo enlace){
        sig = enlace;
        dato = x;
    }
}
