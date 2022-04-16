package cn.web1992.leet.code.test;

/**
 * @author web1992
 * @date 2022/2/25  11:16 下午
 * @implNote 反转链表
 * @link {https://www.bilibili.com/video/BV1JS4y1Z7Lu}
 */
public class 反转链表Test003 {

    public static void main(String[] args) {

        Node node = init();
        node.print();

        // 反转
        reverse(node).print();
    }

    // [1->2->3->4->5]
    // temp
    // [1->2->3->4->5]
    // 临时节点
    private static Node reverse(Node node) {

        if (node == null || node.next == null) {
            return node;
        }
        Node temp = null;
        Node cur = node;
        Node next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = temp;
            temp = cur;
            cur = next;
        }

        return temp;
    }

    private static Node init() {
        Node node1 = new Node();
        node1.val = 1;

        Node node2 = new Node();
        node2.val = 2;
        node1.next = node2;

        Node node3 = new Node();
        node3.val = 3;
        node2.next = node3;

        Node node4 = new Node();
        node4.val = 4;
        node3.next = node4;

        Node node5 = new Node();
        node5.val = 5;
        node4.next = node5;

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
