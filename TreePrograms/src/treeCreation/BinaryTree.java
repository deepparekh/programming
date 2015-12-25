package treeCreation;

import java.util.ArrayList;
import java.util.TreeMap;

import utility.UtilityPrograms;

public class BinaryTree {
	Node root;
    public void add(int key)
    {
        Node newNode = new Node(key);
        if(root==null)
        {
            root = newNode;
           
        }
       
        else
        {
        Node focusNode = root;
        Node Parent;
        while(true)
        {
            Parent = focusNode;
            if(key<focusNode.getData())
            {
            focusNode = focusNode.getLeftchild();
            if(focusNode==null)
            {
                Parent.setLeftchild(newNode);
                return;
            }
           
            }
            else
            {
                focusNode = focusNode.getRightchild();
                if(focusNode==null)
                {
                    Parent.setRightchild(newNode);
                    return;
                   
                }
            }
        }
        }
       
    }
	  public static void main(String[] args) {
	        BinaryTree theTree = new BinaryTree();
	        UtilityPrograms utility = new UtilityPrograms();
	        theTree.add(10);
	        theTree.add(50);
	        theTree.add(100);
	        theTree.add(5);
	        theTree.add(1);
	        theTree.add(40);
	        theTree.add(60);
	        System.out.println("Inorder Traversal----->>>>>");
	        utility.inorderTraversal(theTree.root);
	        System.out.println("\nPre order Traversal ------_>>>>");
	        utility.preorderTraversal(theTree.root);
	        System.out.println("\nPost Order Traversal---->>>");
	        utility.postorderTraversal(theTree.root);
	        System.out.println("\nLevel order traversal -->> ");
	        utility.levelOrderTraversal(theTree.root);
	        TreeMap<Integer, ArrayList< Integer > > map = new TreeMap<Integer, ArrayList< Integer > >();
	        System.out.println("\nPrint tree vertically--->>> ");
	        utility.printVerticalArray( theTree.root, map );
	        System.out.println( "\n\n\nTop view of the tree is ::::::" );
	        utility.topView( theTree.root );
	     System.out.println( "\n\n\nCount the number of nodes in the given range" );
	     System.out.println(" countNumberOfNodesInRange( theTree.root, 35, 222 ) -- >> " +  utility.countNumberOfNodesInRange( theTree.root, 35, 222 ));
	     System.out.println("\nAssiging neighbours");
	     utility.assignNeighbours(theTree.root);
	     System.out.println("Inward Spiral order of tree");
	     utility.printTreeInwardSpiral(theTree.root);
	     System.out.println("\nPrint the sum of left leaves -->> "+utility.sumLeftLeaves(theTree.root));
	     
	       
	    }
	}

