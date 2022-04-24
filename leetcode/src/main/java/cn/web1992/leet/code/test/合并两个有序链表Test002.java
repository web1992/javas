package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @date 2022/3/3  10:23 下午
 * @link {https://www.bilibili.com/video/BV1eS4y1j78K}
 */
public class 合并两个有序链表Test002 {

    public static void main(String[] args) {


        Node node1 = init1();
        Node node2 = init2();

        node1.print();
        node2.print();

        merge(node1, node2).print();
    }


    // 1->3->5
    // 2->3->4->6
    public static Node merge(Node node1, Node node2) {

        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }

        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        } else {
            node2.next = merge(node1, node2.next);
            return node2;
        }

    }

    private static Node init2() {
        Node node1 = new Node();
        node1.val = 2;

        Node node2 = new Node();
        node2.val = 3;

        Node node3 = new Node();
        node3.val = 4;

        Node node4 = new Node();
        node4.val = 6;

        node3.next = node4;
        node2.next = node3;
        node1.next = node2;

        return node1;
    }

    private static Node init1() {
        Node node1 = new Node();
        node1.val = 1;

        Node node2 = new Node();
        node2.val = 3;

        Node node3 = new Node();
        node3.val = 5;

        node2.next = node3;
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
