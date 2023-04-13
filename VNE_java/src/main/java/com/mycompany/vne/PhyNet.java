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
public class PhyNet {
    public int[][] graph;
    public ArrayList<Node> nodeList = new ArrayList<>();
    
    public PhyNet(ArrayList<Node> list, int[][] phyNet){
        nodeList = list;
        graph = phyNet;
    }
    
    public void Map(SFC sfc){
        ArrayList<Node> list = new ArrayList<>();
        double ava = getAvailability(graph,nodeList);
        int[][] bufGraph = graph;
        int mapName = 0;
        int no = 0;
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length - sfc.nodes.size(); j++){
                list.clear();
                list.addAll(nodeList);
                bufGraph = graph;
                for(int k = 0; k < sfc.nodes.size(); k++)   {
                    list.set(bufGraph[i][j+k], new Node(nodeList.get(bufGraph[i][j+k]).name, sfc.nodes.get(k).value));
                }
                double x = getAvailability(graph, list);
                if(ava < x){
                    ava = x;
                    mapName = nodeList.get(graph[i][j+1]).name;
                    no = graph[i][j+1];
                }
            }
        }
        System.out.println("Map:" +nodeList.get(no-1).name + ", "+ mapName+", "+nodeList.get(no+1).name);
        if(mapName!=0){
            nodeList.set(no-1, new Node(nodeList.get(no-1).name, sfc.nodes.get(0).value));
            nodeList.set(no, new Node(nodeList.get(no).name, sfc.nodes.get(1).value));
            nodeList.set(no+1, new Node(nodeList.get(no+1).name, sfc.nodes.get(2).value));
        }
    }
    
    public Node getLessReliableNode(){
        Node nd = new Node(0, 1);
        for(int i = 0; i < graph.length; i++){
            
            for(int j = 0; j < graph[i].length; j++){
                Node cur = nodeList.get(graph[i][j]);
                if(cur.value < nd.value)
                    nd = cur;
            }
        }
        return nd;
    }
    
    public void addExtraNode(Node pos){
        System.out.println("AddExtraNode: " + pos.name + ": its value is" + pos.value);
    }
    
    public void getOptimalPath(){
        System.out.print("Step 3: Path => ");
        for(int i = 0; i < graph[0].length; i++){
            double max = 0;
            Node temp = null;
            for(int j = 0; j < graph.length; j++){
                Node x = nodeList.get(graph[j][i]);
                if(max < x.value){
                    temp = x;
                    max = x.value;
                }
            }
            System.out.print(temp.name + " -> ");
        }
    }

    public static double getAvailability(int[][] graph, ArrayList<Node> valueList){
        double total = 1;
        for(int i = 0; i < graph.length; i++){
            double subtotal = 1;
            for(int j = 0; j < graph[i].length; j++){
                subtotal *= valueList.get(graph[i][j]).value;
            }
            total *= (1 - subtotal);
        }
        return 1 - total;
    }
}
