/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.vne;

import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class VNE {
    static SFC graph1;
    static PhyNet graph2;
    
    
    public static void main(String[] args) {
        
        init();
        
        printPhyNet();
        System.out.println("------------------------");
        if(graph1.getAsfc() >= graph2.getAvailability(graph2.graph, graph2.nodeList)){

            System.out.println("This is possible to map.");
            graph2.Map(graph1);
            printPhyNet();
        } else {
            System.out.println("This is not possible to map.");
        }
        
        System.out.println("------------------------");

        graph2.addExtraNode(graph2.getLessReliableNode());
        
        printPhyNet();
        System.out.println("------------------------");
        
        graph2.getOptimalPath();

    }

    public static void init(){

        Node x1 = new Node(1, 0.95);
        Node x2 = new Node(2, 0.85);
        Node x3 = new Node(3, 0.98);
        
        ArrayList<Node> sfcNodes = new ArrayList();
        sfcNodes.add(x1);
        sfcNodes.add(x2);
        sfcNodes.add(x3);
        
        graph1 = new SFC(sfcNodes);
        
        int nodeGraph[][] = {
            {0,1,2,3,4},
            {0,5,6,7,4},
            {0,8,9,10,4}
        };

        double nodeListValues[] = {0.99, 0.9, 0.8, 0.9, 0.95, 0.85, 0.7, 0.8, 0.84,0.93,0.78};
        
        ArrayList<Node> nodeList = new ArrayList<>();
        
        for(int i = 0; i < nodeListValues.length; i++){
            nodeList.add(new Node(i+1, nodeListValues[i]));
        }
        graph2 = new PhyNet(nodeList, nodeGraph);
    }

    public static void printPhyNet(){
        for(int i = 0; i < graph2.graph.length; i++){
            System.out.print("Layer" + i + ": ");
            for(int j = 0 ; j < graph2.graph[i].length; j++){
                Node cur = graph2.nodeList.get(graph2.graph[i][j]);
                System.out.print(cur.name + "(" + cur.value + ")");
                System.out.print(" -> ");
            }
            System.out.println();
        }
        System.out.print("SFC: ");
        for(int i = 0 ; i < graph1.nodes.size(); i++){
            Node cur = graph1.nodes.get(i);
            System.out.print(cur.name + "(" + cur.value + ")");
            System.out.print(" -> ");
        }
        System.out.println();
    }
}
