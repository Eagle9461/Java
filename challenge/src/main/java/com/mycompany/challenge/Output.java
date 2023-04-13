/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Output implements Runnable{
    Thread t;
    Queue<Integer> fifo = new LinkedList<>();
    Stack<Integer> printed = new Stack<>();
    
    public Output(Queue ss){
        t = new Thread(this);
        fifo = ss;
        t.start();
    }

    public  void deque(Integer x){
        if(fifo.contains(x)){
            fifo.remove(x);
            printed.push(x);
            System.out.print(" "+ x+" ");
        } else {
//            x++;
            deque(x);
        }
    }
    public  boolean isOK(Stack ss, Integer x){
        if(ss.size() < 2)return true;
        Integer l = (Integer)ss.pop();
        Integer t;
        while(!ss.empty()){
            t = (Integer) ss.pop();
              if(Objects.equals(t, l) ){
                return false;
              }
            if(t > l){
                return true;
            }
        }
        return true;
    }
    public  void process(){
        Stack xx = (Stack) printed.clone();
        Queue que = new LinkedList<Integer>();
        que.addAll(fifo);
        Integer cur = getHighPriority(que);
        if(isOK(xx, cur)){
            deque(cur);
        } else{

            Integer l = printed.lastElement();
            deque(l+1);
        }
    }
    public  Integer getHighPriority(Queue que){
        Integer min = 99999;
        while(!que.isEmpty()){
            Integer m = (Integer)que.remove();
            if(m < min )min = m;
        }
        return min;
    }

    @Override
    public void run() {
        try {
            while (! fifo.isEmpty()){
                process();
                Thread.sleep(900);
            }
        }catch (InterruptedException e) {
        }

    }

}
