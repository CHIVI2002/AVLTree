/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ekt
 */
package com.ordenamiento.avltree;

public class Node {
    int valor;
    Node izquierda, derecha;
    int altura;

    public Node(int valor) {
        this.valor = valor;
        this.altura = 1;
    }
}
