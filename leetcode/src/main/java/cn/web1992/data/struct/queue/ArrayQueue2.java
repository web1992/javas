package cn.web1992.data.struct.queue;

/**
 * @author web1992
 * @date 2022/1/25  11:24 上午
 * 循环队列,避免数据搬移(数组重复利用)
 */
public class ArrayQueue2<E> implements Queue<E> {


    Object[] elements;
    int length;
    int tail;
    int head;

    public ArrayQueue2(int max) {
        this.length = max;
        this.elements = new Object[max];
    }

    /**
     * 入队
     *
     * @param e
     * @return
     */
    @Override
    public boolean enqueue(E e) {

        if ((tail + 1) % length == head) {
            return false;
        }
        elements[tail] = e;
        tail = (tail + 1) % length;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    @Override
    public E dequeue() {

        if (head == tail) {
            return null;
        }
        Object obj = elements[head];
        head = (head + 1) % length;

        return (E) obj;
    }


}
