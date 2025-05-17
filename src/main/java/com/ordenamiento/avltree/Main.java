/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ordenamiento.avltree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVLTree arbol = new AVLTree();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese números enteros para insertar en el árbol AVL.");
        System.out.println("Escriba 'exit' o -1 para finalizar.");

        while (true) {
            System.out.print("Ingrese un número: ");
            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("exit") || entrada.equals("-1")) {
                System.out.println("Programa finalizado.");
                break;
            }

            try {
                int numero = Integer.parseInt(entrada);
                arbol.raiz = arbol.insertar(arbol.raiz, numero);
                System.out.println("\nÁrbol AVL actual:");
                arbol.printTree(arbol.raiz);
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        }

        scanner.close();
    }
}
