package tree;

public class Tree {
	
	public static void buildTree(Node pNode,int data){
		if (pNode == null) {
			return;
		}
		
		if (data < pNode.getValue()) {
			if (pNode.getLeftNode() == null) {
				Node newNode = new Node();
				newNode.setValue(data);
				newNode.setLeftNode(null);
				newNode.setRightNode(null);
				pNode.setLeftNode(newNode);
			} else {
				buildTree(pNode.getLeftNode(), data);
			}
		} else if (data >= pNode.getValue()){
			if (pNode.getRightNode() == null) {
				Node newNode = new Node();
				newNode.setValue(data);
				newNode.setLeftNode(null);
				newNode.setRightNode(null);
				pNode.setRightNode(newNode);
			} else {
				buildTree(pNode.getRightNode(), data);
			}
		} 
	}
	/**
	 * 中序遍历
	 * @param node
	 */
	public static void middleSearch(Node node){
		if (node == null) {
			return;
		}
		
		middleSearch(node.getLeftNode());
		System.out.print(node.getValue() + "\t");
		middleSearch(node.getRightNode());
	}
	/**
	 * 前序遍历
	 * @param node
	 */
	public static void beforeSearch(Node node){
		if (node == null) {
			return;
		}
		
		System.out.print(node.getValue() + "\t");
		beforeSearch(node.getLeftNode());
		beforeSearch(node.getRightNode());
	}
	/**
	 * 后续遍历
	 * @param node
	 */
	public static void afterSearch(Node node){
		if (node == null) {
			return;
		}
		
		afterSearch(node.getLeftNode());
		afterSearch(node.getRightNode());
		System.out.print(node.getValue() + "\t");
	}
	
	public static void main(String[] args) {
		int[] values = new int[]{10,8,9,3,10,45,25,64,35,4,46};
		Node root  = new Node();
		root.setValue(18);
		for (int tmp:values) {
			 Tree.buildTree(root, tmp);
		}
		
		Tree.middleSearch(root);
		System.out.println();
        Tree.beforeSearch(root);
    	System.out.println();
        Tree.afterSearch(root);
	}

}
