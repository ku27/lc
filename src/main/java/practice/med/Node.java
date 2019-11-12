package practice.med;

public class Node {

	  public Node(Integer value){
	    super();
	    this.value = value;
	  }

	  static boolean bst = true;
	  private Integer value;
	  private Node left;
	  private Node right;
	  
	  public void addChildren(Integer left, Integer right) {
		  this.left = new Node(left);
		  this.right = new Node (right);
	  }
	  
	  public Node left() {
		  return this.left;
	  }
	  public Node right() {
		  return this.left;
	  }
	  
	  
	  public boolean inOrderTraversal(Node node){
	    if (null != node && bst){

	    	if(null != node.left) {
		    	 if( node.left.value > node.value) {
		    		 bst=false;
		    	 }
		      }
		      if(null != node.right) {
			    	 if( node.right.value < node.value) {
			    		 bst=false;
			    	 }
			      }
	    	
	      inOrderTraversal(node.left);
	      System.out.println(node.value);
	      
	      inOrderTraversal(node.right);
	    }
	    return bst;

	  }

	  public void preOrder(Node node){
		  if (null != node){
			  
			  System.out.println(node.value);
			  preOrder(node.left);
			  preOrder(node.right);
		    } 

	  }
	  
	  public void postOrder(Node node){
		  if (null != node){  
			  postOrder(node.left);
			  postOrder(node.right);
			  System.out.println(node.value);
		    } 
	  }

	  public int treeSum(Node node, int sum) {
		  
		  if(node==null) {
			  return 0;
			  
		  }
		  	  sum = sum*10+node.value;
		  	 System.out.println( node.value + " " +  sum);
		  	  return sum + treeSum(node.left, sum) + treeSum(node.right, sum);
		  	 
		  	  
		  
	  }
	  

	  public static void main(String[]args){
		  Node root = new Node(10);
		  root.addChildren(20, 30);
		  root.left.addChildren(40, 60);
		 // root.left.left.addChildren(1, 4);
		  //root.right.addChildren(9, 10);
		  //root.right.right.addChildren(13,17);
		 //root.right.left.addChildren(8, 10);
		 
		  
		  
		  
		  
	    root.preOrder(root);
	    
	    System.out.println(root.treeSum(root, 0));
	    
	  }
	}
