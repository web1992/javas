package cn.web1992.leet.code;


/**
 * @author web1992
 * @date 2022/4/17  17:38
 * @implNote 循环队列
 */
public class CircularQueue<E> {

    private Object[] elements;
    private int length;
    private int tail;
    private int head;

    public CircularQueue() {
        this.length = 16;
        elements = new Object[16];
    }


    public CircularQueue(int count) {
        this.length = count;
        elements = new Object[count];
    }

    public boolean offer(E e) {

        if ((tail + 1) % length == head) {
            return false;
        }

        elements[tail] = e;
        tail = (tail + 1) % length;
        return true;
    }

    public E poll() {

        if (tail == head) {
            return null;
        }
        E e = (E) elements[head];
        head = (head + 1) % length;

        return e;
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        Integer e = null;
        while ((e = queue.poll()) != null) {
            System.out.println("e -> " + e);
        }

    }
}
