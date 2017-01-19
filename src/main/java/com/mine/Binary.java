package com.mine;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Binary {

	public static void main(String[] args) {
		int[] arrys = { 56, 23, 57, 79, 34, 23, 57, 67, 22, 89 };
		BinaryTree binaryTree = new BinaryTree();
		for (int i = 0; i < arrys.length; i++) {
			binaryTree.insert(arrys[i]);
		}
		binaryTree.printTree();
	}
	
	private static String getResult(String ques, List<String> engines){
		AtomicReference<String> result = new AtomicReference<String>();
		for(String base : engines){
			String url = base + ques;
			new Thread(() -> {
				result.compareAndSet(null, null);
				System.out.println("===");
			}).start();
		}
		
		
		return null;
	}

}

class Node {
	Node left;
	Node right;
	int data;

	public Node(int data) {
		this.data = data;
	}
}

class BinaryTree {
	Node root;

	public void insert(int data) {
		root = insert(root, data);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node;
	}

	public void printTree() {
		this.printTree(root);
	}

	private void printTree(Node node) {
		if (node == null) {
			return;
		}
		printTree(node.left);
		System.out.println(node.data);
		printTree(node.right);
	}
}
