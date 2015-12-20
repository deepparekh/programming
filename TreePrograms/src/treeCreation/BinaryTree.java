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
	        theTree.add(40);
	        theTree.add(35);
	        theTree.add(222);
	        theTree.add(2);
	        theTree.add(245);
	        theTree.add(29);
	        theTree.add(38);
	        System.out.println("Inorder Traversal----->>>>>");
	        utility.inorderTraversal(theTree.root);
	        System.out.println("Pre order Traversal ------_>>>>");
	        utility.preorderTraversal(theTree.root);
	        System.out.println("Post Order Traversal---->>>");
	        utility.postorderTraversal(theTree.root);
	        utility.levelOrderTraversal(theTree.root);
	        TreeMap<Integer, ArrayList< Integer > > map = new TreeMap<Integer, ArrayList< Integer > >();
	        utility.printVerticalArray( theTree.root, map );
	        System.out.println( "\n\n\nTop view of the tree is ::::::" );
	        utility.topView( theTree.root );
	     System.out.println( "\n\n\nCount the number of nodes in the given range" );
	     System.out.println(" countNumberOfNodesInRange( theTree.root, 35, 222 ) -- >> " +  utility.countNumberOfNodesInRange( theTree.root, 35, 222 ));
	       
	    }
	}

