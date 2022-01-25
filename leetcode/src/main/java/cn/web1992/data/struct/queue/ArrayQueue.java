package cn.web1992.data.struct.queue;

/**
 * @author web1992
 * @date 2022/1/25  11:24 上午
 */
public class ArrayQueue<E> implements Queue<E> {

    Object element[];
    int length;
    int tail;
    int head;

    //
    // 队列头 .................. 队列尾
    public ArrayQueue(int max) {
        this.length = max;
        this.element = new Object[max];
    }

    /**
     * 入队
     *
     * @param e
     * @return
     */
    @Override
    public boolean enqueue(E e) {
        if (tail == length) {
            // 满了
            return false;
        }
        element[tail++] = e;
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
        Object obj = element[head++];
        return (E) obj;
    }


}
