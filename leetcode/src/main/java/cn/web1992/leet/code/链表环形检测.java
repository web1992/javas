package cn.web1992.leet.code;


/**
 * @author web1992
 * @date 2022/4/16  22:12
 */
public class 链表环形检测 {
    public static void main(String[] args) {

        Node init = init();

        System.out.println(check(init));

    }


    public static boolean check(Node node) {

        if (null == node || node.next == null) {
            return false;
        }

        Node fast = node;
        Node slow = node;
        boolean rs = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow.val == fast.val) {
                rs = true;
                break;
            }
        }

        return rs;
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

        // create loop
        node5.next = node3;

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
