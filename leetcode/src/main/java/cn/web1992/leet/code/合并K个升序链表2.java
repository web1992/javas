package cn.web1992.leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author web1992
 * @date 2022/3/8  11:16 下午
 * @link {https://www.bilibili.com/video/BV19r4y167Ap}
 */
public class 合并K个升序链表2 {
    public static void main(String[] args) {


        List<Node> nodeList = new ArrayList<>();

        nodeList.add(init());// 2->6
        nodeList.add(init2());// 1->4->5
        nodeList.add(init3());// 1->3->4

        merge(nodeList).print();
    }

    private static Node merge(List<Node> nodeList) {


        return null;
    }


    private static Node init3() {
        Node node1 = new Node();
        node1.val = 1;

        Node node2 = new Node();
        node2.val = 3;
        node1.next = node2;

        Node node3 = new Node();
        node3.val = 4;
        node2.next = node3;

        return node1;
    }

    private static Node init2() {
        Node node1 = new Node();
        node1.val = 1;

        Node node2 = new Node();
        node2.val = 4;
        node1.next = node2;

        Node node3 = new Node();
        node3.val = 5;
        node2.next = node3;


        return node1;
    }

    private static Node init() {
        Node node1 = new Node();
        node1.val = 2;

        Node node2 = new Node();
        node2.val = 6;
        node1.next = node2;

        return node1;
    }

    static public class Node {
        int val;
        Node next;

        public void print() {
            Node n = this;
            StringBuilder sb = new StringBuilder("[");
            while (n != null) {
                sb.append(n.val);
                n = n.next;
                if (n != null) {
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb);
        }
    }

}
