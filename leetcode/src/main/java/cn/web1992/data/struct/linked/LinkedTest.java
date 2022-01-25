package cn.web1992.data.struct.linked;

/**
 * @author web1992
 * @date 2022/1/24  11:57 上午
 */
public class LinkedTest {

    public static void main(String[] args) {

        NodeList<String> nodeList = new NodeList<>();

        Node<String> node1 = new Node<>("11");
        Node<String> node2 = new Node<>("22");
        Node<String> node3 = new Node<>("33");
        Node<String> node4 = new Node<>("44");

        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);

        nodeList.forEach();

        nodeList.delete(node2);
        nodeList.delete(node2);
        nodeList.delete(node3);
        nodeList.delete(node4);
        nodeList.delete(node1);
        nodeList.forEach();

    }

    static class NodeList<T> {

        Node<T> tail;

        Node<T> head;

        public NodeList() {
        }

        // head -> node -> node
        public void add(Node<T> node) {
            if (null == node) {
                return;
            }
            if (head == null) {
                head = node;
                tail = head;
            }
            node.pre = tail;
            tail.next = node;
            tail = node;
        }

        public void delete(Node<T> node) {
            System.out.println("delete=" + node.val);
            if (null == node) {
                return;
            }

            node.pre.next = node.next;
            node.next.pre = node.pre;

        }

        public void forEach() {
            Node<T> node = head;
            while (node != null) {
                System.out.println(node.val);
                node = node.next;
            }
        }

    }


    static class Node<T> {
        Node<T> pre;
        Node<T> next;
        T val;

        public Node(T val) {
            this.val = val;
        }
    }

}
