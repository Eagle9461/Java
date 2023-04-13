/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.challenge;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Administrator
 */
public class Challenge{
    static Integer arr[] = {4,1, 3, 2, 1, 4, 2, 3, 2, 4, 1, 3, 3, 5, 2, 1, 3, 6, 1, 2, 4, 2, 4, 1, 3, 2, 1, 5, 2, 1, 1, 2, 3, 1, 1};
   // static Integer arr[] = {4,1, 3, 2, 2};
    static Queue<Integer> fifo = new LinkedList<>();

    public static void main(String[] args) {

        for (int i = 0; i < arr.length; i++){
            System.out.print(" " + arr[i]);
            fifo.add(arr[i]);
        }
        System.out.println();
        Output out = new Output(fifo);
        Input in = new Input(fifo);
    }
}
