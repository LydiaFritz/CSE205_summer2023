package bst;

public class BST_Driver {
	public static void main(String[] args) {
		BinSearchTree <Integer> tree = new BinSearchTree();
		int [] arr = {5,2,8,1,0,7,5,3,6};
		for(Integer i : arr) {
			if(tree.add(i)) {
				System.out.println(i + " added to the tree");
			}
			else {
				System.out.println(i + " is already in the tree");
			}
		}
		System.out.println();
		tree.print1();
		System.out.println();
		tree.print2();
		System.out.println();
		tree.print3();
		
		tree.remove(0);
		System.out.println();
		tree.print3();
	}
}
