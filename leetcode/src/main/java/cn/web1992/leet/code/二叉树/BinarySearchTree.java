package cn.web1992.leet.code.二叉树;

public class BinarySearchTree {
    private Node tree;

    // 查找功能
    public Node find(int data) {

        if (null == tree) {
            return null;
        }

        Node node = tree;

        while (node != null) {
            if (data > node.data) {
                node = node.right;
            } else if (data < node.data) {
                node = node.left;
            } else {
                return node;
            }
        }

        return null;
    }


    public void insert(int data) {

        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node node = tree;
        while (node != null) {
            if (data > node.data) {
                if (node.right == null) {
                    node.right = new Node(data);
                    return;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new Node(data);
                    return;
                }
                node = node.left;
            }
        }

    }


    public void delete(int data) {
        Node p = tree; // 指向要删除的节点，初始化指向根节点
        Node pp = null; // 记录的是p的父节点

        // 找节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.left;
            } else {
                p = p.right;
            }
        }

        // 没有找到节点
        if (null == p) {
            return;
        }

        // 有两个左右节点
        if (p.left != null && p.right != null) {

            Node minP = p.right;
            Node minPP = p;
            while (p.left != null) {
                minPP = minP;
                minP = p.left;
            }

            p.data = minP.data;
            p = minP;
            pp = minPP;

        }

        // 只有一个左右节点
        Node child = null;
        if (p.left == null) {
            child = p.right;
        } else if (p.right == null) {
            child = p.left;
        } else {
            child = null;
        }

        if (pp == null) {
            // 根节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}