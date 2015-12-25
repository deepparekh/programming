package utility;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import treeCreation.Node;

public class UtilityPrograms {
	/*Print tree in inorder traversal. 
	 * For input: 
	 *         10
	          /    \
	        5       50
	       /       /  \
	     1       40   100
	     
	     output: 1	5	10	40	50	100
	 * */
	
	   public void inorderTraversal(Node focusNode)
	    {
	    if(focusNode!=null)
	    {
	        inorderTraversal(focusNode.getLeftchild());
	        System.out.print(focusNode.getData() + "\t");
	        inorderTraversal(focusNode.getRightchild());
	    }
	    }
	    public void preorderTraversal(Node focusNode)
	    {
	    if(focusNode!=null)
	    {
	        System.out.print(focusNode.getData() + "\t");
	        inorderTraversal(focusNode.getLeftchild());
	        inorderTraversal(focusNode.getRightchild());
	    }
	    }public void postorderTraversal(Node focusNode)
	    {
	    if(focusNode!=null)
	    {
	        inorderTraversal(focusNode.getLeftchild());
	        inorderTraversal(focusNode.getRightchild());
	        System.out.print(focusNode.getData() + "\t");
	    }
	    }
	    public void levelOrderTraversal(Node focusNode)
	    {
	        Queue<Node> queue = new LinkedList<Node>();
	       // System.out.println("root-->>>" + focusNode.getData());
	       
	        int count = 0;
	        queue.add(focusNode);
	        while(queue.size()!=0)
	        {
	            count++;
	            if(count>=10)
	                break;
	           
	            if(focusNode.getLeftchild()!=null)
	            {
	               
	                queue.add(focusNode.getLeftchild());
	            }
	            if(focusNode.getRightchild()!=null)
	            {
	                queue.add(focusNode.getRightchild());
	            }
	           
	           
	            }
	           
	           
	        }
	   
	    /*
	     * Print a Binary Tree in Vertical Order | Set 2 (Hashmap based Method)
	Given a binary tree, print it vertically. The following example illustrates vertical order traversal.

	           1
	        /    \
	       2      3
	      / \    / \
	     4   5  6   7
	             \   \
	              8   9
	              
	             
	The output of print this tree vertically will be:
	4
	2
	1 5 6
	3 8
	7
	9
	     * */
	   
	    public static void verticalPrint(Node root, int hd,TreeMap<Integer, ArrayList< Integer > > map)
	    {
	        if(root==null)
	        {
	        return;   
	        }
	        else
	        {
	        verticalPrint( root.getLeftchild(), hd-1, map );
	        if(map.containsKey( hd ))
	        {
	            map.get( hd ).add( root.getData() );
	        }
	        else
	        {
	            ArrayList< Integer > a = new ArrayList<>();
	            a.add( root.getData());
	            map.put( hd, a );
	        }
	        verticalPrint( root.getRightchild(), hd+1, map );
	        }
	    }
	    public static void printVerticalArray(Node root,TreeMap<Integer, ArrayList< Integer > > map)
	    {
	        verticalPrint( root, 0,  map);
	        for(int key : map.keySet())
	        {
	        System.out.println( "HD :  " + key + " and array: "  +map.get( key ).toString() );
	        }
	    }
	       
	 
	   
	   
	    /*
	     *
	     * Print Nodes in Top View of Binary Tree
	Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree, print the top view of it. The output nodes can be printed in any order. Expected time complexity is O(n)

	A node x is there in output if x is the topmost node at its horizontal distance. Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

	       1
	    /     \
	   2       3
	  /  \    / \
	 4    5  6   7
	Top view of the above binary tree is
	4 2 1 3 7

	        1
	      /   \
	    2       3
	      \  
	        4 
	          \
	            5
	             \
	               6
	Top view of the above binary tree is
	2 1 3 6
	     *
	     * */
	       
	   
	    public static void topView(Node focusNode)
	    {
	        Queue< Node > q = new LinkedList<Node>();
	        focusNode.setHd(0);
	        q.add( focusNode );
	        Node temp;
	        TreeMap< Integer, Node > map = new TreeMap< Integer, Node >();
	        while(q.size()>0)
	        {
	            temp = q.remove();
	            if(!map.containsKey( temp.getHd() ))
	            {
	                map.put( temp.getHd(), temp );
	            }
	            if(temp.getLeftchild()!=null)
	            {
	                temp.getLeftchild().setHd(temp.getHd()-1);
	                q.add( temp.getLeftchild() );
	            }
	            if(temp.getRightchild()!=null)
	            {
	                temp.getRightchild().setHd(temp.getHd()+1);
	                q.add( temp.getRightchild() );
	            }
	        }
	        for(int key : map.keySet())
	        {
	            System.out.print( "  " + map.get( key ).getData() );
	        }
	          
	           
	    }
	   
	    /*
	    Count BST nodes that lie in a given range
	    Given a Binary Search Tree (BST) and a range, count number of nodes that lie in the given range.

	    Examples:

	    Input:
	            10
	          /    \
	        5       50
	       /       /  \
	     1       40   100
	    Range: [5, 45]

	    Output:  3
	    There are three nodes in range, 5, 10 and 40
	   */
	   
	    public static int countNumberOfNodesInRange(Node root,int low,int high)
	    {
	        if(root==null)
	        {
	            return 0;
	        }
	        else if(root.getData()<high && root.getData()>low)
	        {
	            return 1 +countNumberOfNodesInRange(root.getLeftchild(),low,high) + countNumberOfNodesInRange( root.getRightchild(), low, high );
	        }
	        else
	        {
	            return countNumberOfNodesInRange(root.getLeftchild(),low,high) + countNumberOfNodesInRange( root.getRightchild(), low, high );
	        }
	    }

	    
	    /*
	     *  
You have a BST and you need to assign an appropriate value to neighbor of all nodes 
(Explained in below example)
Node Structure

node {
                     node leftChild,
                     node rightChild,
                     T data,
                      node neighbor
                     }

A
/ \
B C
/ \ \
D E F

Based on above tree,

Node: Neighbor
A: NULL
B: C
D: E
E: F
	     * 
	     * */
	    public static void assignNeighbours(Node root)
	    {
	    	Map<Integer,List<Node>> map = levelToListMap(root);
	    	List<Node> list; 
	    	for(int key : map.keySet())
	    	{
	    		System.out.print("\nLevel -->> " + key);
	    		System.out.print("------>> ");
	    		for(Node node : map.get(key))
	    		{
	    			System.out.print("\t" + node.getData());
	    		}
	    	}
	    	System.out.println("\nAssiging neighbours");
	    	for(int key:map.keySet())
	    	{
	    		list = map.get(key);
	    		if(list.size()==1)
	    		{
	    			list.get(0).setNeighbour(null);
	    			System.out.println(list.get(0).getData() +"\t"+"null");
	    		}
	    		else
	    		{
	    			for(int i=0;i<list.size()-1;i++)
	    			{
	    				list.get(i).setNeighbour(list.get(i+1));
	    				System.out.println(list.get(i).getData() + "\t" + list.get(i+1).getData());
	    			}
	    			System.out.println(list.get(list.size()-1).getData() + "\t" + "null");
	    		}
	    	}
	    }
	    /*
	     * Utility function for returning map corresponds to <level,list_of_nodes> */
public static Map<Integer,List<Node>> levelToListMap(Node root)
{
	Queue<Node> q = new LinkedList<Node>();
	Map<Integer,List<Node>> map = new HashMap<Integer,List<Node>>();
	List<Node> list; 
	root.setLevel(0);
	q.add(root);
	while(!q.isEmpty())
	{
		Node temp = q.remove();
		if(map.get(temp.getLevel())==null)
		{
			list = new ArrayList<Node>();
			list.add(temp);
			map.put(temp.getLevel(), list);
		}
		else
		{
			map.get(temp.getLevel()).add(temp);
		}
		if(temp.getLeftchild()!=null)
		{
			temp.getLeftchild().setLevel(temp.getLevel()+1);
			q.add(temp.getLeftchild());
		}
		if(temp.getRightchild()!=null)
		{
			temp.getRightchild().setLevel(temp.getLevel()+1);
			q.add(temp.getRightchild());
		}
	}
	q.clear();
	return map;
}
/*
Given a binary tree print it in inward spiral order i.e first print level 1, 
then level n, then level 2, then n-1 and so on.

For Ex -
1
2 3
4 5 6 7
8 9 10 11 12 13 14 15

Print- 1 15 14 13 12 11 10 9 8 2 3 7 6 5 4 */
public static void printTreeInwardSpiral(Node root)
{
	Map<Integer,List<Node>> map = levelToListMap(root);
	int n = map.keySet().size();
	List<Node> list;
	for(int i=0,j=n-1;i<=j;i++,j--)
	{
		list = map.get(i);
		for(int k=0;k<list.size();k++)
		{
			System.out.println("\t" + list.get(k).getData());
		}
		list.clear();
		list = map.get(j);
		for(int k=0;k<list.size();k++)
		{
			System.out.println("\t" + list.get(k).getData());
		}
		list.clear();
	}
	
}
}
