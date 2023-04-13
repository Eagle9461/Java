/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vne;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class SFC {
    public ArrayList<Node> nodes = new ArrayList<Node>();

    public SFC(ArrayList<Node> nodes){
        this.nodes = nodes;
    }
    
    public double getAsfc(){
        double Asfc = 1;
        for(int i = 0; i < nodes.size(); i++){
            Asfc *= nodes.get(i).value;
        }
        return Asfc;
    }
}