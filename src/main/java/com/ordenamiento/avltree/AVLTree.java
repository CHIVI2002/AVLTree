/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.ordenamiento.avltree;

/**
 *
 * @author ekt
 */
public class AVLTree {

    Node raiz;

    // Obtener altura
    int getAltura(Node nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    // Obtener factor de balance
    int getFactorBalance(Node nodo) {
        return (nodo == null) ? 0 : getAltura(nodo.izquierda) - getAltura(nodo.derecha);
    }

    // Rotación derecha
    Node rotarDerecha(Node y) {
        Node x = y.izquierda;
        Node T2 = x.derecha;

        x.derecha = y;
        y.izquierda = T2;

        y.altura = Math.max(getAltura(y.izquierda), getAltura(y.derecha)) + 1;
        x.altura = Math.max(getAltura(x.izquierda), getAltura(x.derecha)) + 1;

        return x;
    }

    // Rotación izquierda
    Node rotarIzquierda(Node x) {
        Node y = x.derecha;
        Node T2 = y.izquierda;

        y.izquierda = x;
        x.derecha = T2;

        x.altura = Math.max(getAltura(x.izquierda), getAltura(x.derecha)) + 1;
        y.altura = Math.max(getAltura(y.izquierda), getAltura(y.derecha)) + 1;

        return y;
    }

    // Método principal de inserción con rotaciones AVL
    Node insertar(Node nodo, int valor) {
        if (nodo == null)
            return new Node(valor);

        if (valor < nodo.valor)
            nodo.izquierda = insertar(nodo.izquierda, valor);
        else if (valor > nodo.valor)
            nodo.derecha = insertar(nodo.derecha, valor);
        else
            return nodo; // duplicados no permitidos

        nodo.altura = 1 + Math.max(getAltura(nodo.izquierda), getAltura(nodo.derecha));
        int balance = getFactorBalance(nodo);

        // LL
        if (balance > 1 && valor < nodo.izquierda.valor)
            return rotarDerecha(nodo);

        // RR
        if (balance < -1 && valor > nodo.derecha.valor)
            return rotarIzquierda(nodo);

        // LR
        if (balance > 1 && valor > nodo.izquierda.valor) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }

        // RL
        if (balance < -1 && valor < nodo.derecha.valor) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }

        return nodo;
    }

    // Método para imprimir el árbol
    void printTree(Node nodo) {
        imprimir(nodo, 0);
    }

    // Recorrido en orden: derecha -> nodo -> izquierda (para visualización)
    void imprimir(Node nodo, int nivel) {
        if (nodo == null)
            return;

        imprimir(nodo.derecha, nivel + 1);

        for (int i = 0; i < nivel; i++)
            System.out.print("    ");
        System.out.println(nodo.valor);

        imprimir(nodo.izquierda, nivel + 1);
    }
}
