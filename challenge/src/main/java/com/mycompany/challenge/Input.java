/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.challenge;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class Input implements Runnable{
    Thread t;
    int x;
    Queue<Integer> fifo = new LinkedList<>();

    Input(Queue ss){
        fifo = ss;
        t = new Thread(this);
        t.start();
    }
    public void run(){
        while(true){
            Scanner input = new Scanner(System.in);
            int x = input.nextInt();
            fifo.add(x);
        }
    }
}
