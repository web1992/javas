package cn.web1992.tree;

/**
 * @author web1992
 * @date 2022/1/13  5:51 下午
 */
public class TreeSearch {

    private Node root;

    public Node find(int val) {

        Node p = root;
        while (p != null) {
            int v = p.data;
            if (val > v) {
                p = p.right;
            } else if (val < v) {
                p = p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    static class Node {
        int data;
        Node left;
        Node right;
    }
}
