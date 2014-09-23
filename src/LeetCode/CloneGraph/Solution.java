package LeetCode.CloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import LeetCode.Helper.UndirectedGraphNode;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        //cloneGraph breadth first
        HashMap<Integer, UndirectedGraphNode> nodeMap = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> nodeQueue = new LinkedList<UndirectedGraphNode>();
        nodeQueue.add(node);
        UndirectedGraphNode newRoot = new UndirectedGraphNode(node.label);
        nodeMap.put(newRoot.label, newRoot);
        
        while(!nodeQueue.isEmpty())
        {
            UndirectedGraphNode nnode = nodeQueue.poll();
            //clone node
            UndirectedGraphNode newNode = nodeMap.get(nnode.label);
            if(newNode == null)
            {
                newNode = new UndirectedGraphNode(nnode.label);
            }
            
            if(nnode.neighbors == null) newNode.neighbors = null;
            else{
                for(int i =0; i< nnode.neighbors.size(); i++)
                {
                    UndirectedGraphNode neighbor = nnode.neighbors.get(i);
                    UndirectedGraphNode existNode = nodeMap.get(neighbor.label);
                    if(existNode== null)
                    {
                        existNode = new UndirectedGraphNode(neighbor.label);
                        nodeMap.put(existNode.label, existNode);
                        nodeQueue.add(neighbor);
                    }
                    newNode.neighbors.add(existNode);

                }
            }
        }
        return newRoot;
    }
}
