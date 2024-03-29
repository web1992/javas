package cn.web1992.leet.code;

/**
 * @author web1992
 * @date 2022/2/25  11:16 下午
 * @implNote 反转链表
 * @link {https://www.bilibili.com/video/BV1JS4y1Z7Lu}
 * @link {https://www.bilibili.com/video/BV1VL411u7TK}
 */
public class 反转链表 {

    public static void main(String[] args) {

        Node node = init();
        node.print();


        // 反转
        reverse(node).print();
    }

    // [1->2->3->4->5]
    private static Node reverse(Node node) {

        if (node == null || node.next == null) {
            return null;
        }

        Node temp = null;
        Node cur = node;
        Node next = node;

        while (cur != null) {
            next = cur.next;
            cur.next = temp;// 反转链表的时候需要，修改Next,因此上面先把Next存储在next变量中，temp 是要被Next指向的值
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
