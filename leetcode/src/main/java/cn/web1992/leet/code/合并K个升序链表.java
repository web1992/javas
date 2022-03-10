package cn.web1992.leet.code;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author web1992
 * @date 2022/3/8  11:16 下午
 * @link {https://www.bilibili.com/video/BV19r4y167Ap}
 */
public class 合并K个升序链表 {
    public static void main(String[] args) {


        List<Node> nodeList = new ArrayList<>();

        nodeList.add(init());// 2->6
        nodeList.add(init2());// 1->4->5
        nodeList.add(init3());// 1->3->4

        merge(nodeList).print();
    }

    // 采用分治的思想
    // 先写整体的思路，再写具体的实现
    private static Node merge(List<Node> nodeList) {

        Queue<Node> queue = new ArrayDeque<>(nodeList);

        while (queue.size() >= 2) {
            Node node1 = queue.poll();
            Node node2 = queue.poll();
            Node mergeNode = merge0(node1, node2);
            queue.offer(mergeNode);
        }

        return queue.poll();
    }


    private static Node merge0(Node n1, Node n2) {
        // 虚节点
        Node dummy = new Node();
        // 头指针，用于返回使用
        Node head = dummy;

        while (n1 != null && n2 != null) {
            if (n2.val > n1.val) {
                dummy.next = n1;
                dummy = n1;
                n1 = n1.next;

            } else {
                dummy.next = n2;
                dummy = n2;
                n2 = n2.next;
            }

        }
        if (null != n2) {
            dummy.next = n2;
        }

        if (null != n1) {
            dummy.next = n1;
        }

        return head.next;
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
