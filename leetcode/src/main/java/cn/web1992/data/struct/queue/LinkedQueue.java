package cn.web1992.data.struct.queue;

/**
 * @author web1992
 * @date 2022/1/25  11:24 上午
 */
public class LinkedQueue<E> implements Queue<E> {

    Node<E> tail;
    Node<E> head;

    public LinkedQueue() {
        this.tail = new Node<>(null, null);
        this.head = this.tail;
    }

    @Override
    public boolean enqueue(E e) {
        Node<E> newNode = new Node<>(e, null);
        tail.next = newNode;
        tail = tail.next;
        return true;
    }

    @Override
    public E dequeue() {

        Node<E> h = head.next;
        head = head.next;
        return h.e;
    }

    private static class Node<E> {
        E e;
        Node<E> next;

        public Node(E e, Node<E> next) {
            this.e = e;
            this.next = next;
        }
    }

}
