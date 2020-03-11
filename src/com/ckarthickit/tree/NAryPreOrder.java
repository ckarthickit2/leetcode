package com.ckarthickit.tree;

import java.util.ArrayList;
import java.util.List;



public class NAryPreOrder {
    static class Node {
        public int val;
        public List<Node> children = new ArrayList<>();

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> retVal = new ArrayList<>();
        preorder(root, retVal);
        return retVal;
    }

    public static void preorder(Node root, List<Integer> preOrderList) {
        if(root == null) {
            return;
        }
        preOrderList.add(root.val);
        if (root.children != null) {
            for (Node child : root.children) {
                preorder(child, preOrderList);
            }
        }
    }

    public static void main(String... args) {
        Node root = new Node(1);
        Node nodeWithVal3 = new Node(3);
        Node nodeWithVal2 = new Node(2);
        Node nodeWithVal4 = new Node(4);
        root.children.add(nodeWithVal3);
        root.children.add(nodeWithVal2);
        root.children.add(nodeWithVal4);
        nodeWithVal3.children.add(new Node(5));
        nodeWithVal3.children.add(new Node(6));
        List<Integer> result = preorder(root);
        System.out.println(result.toString());
    }
}
