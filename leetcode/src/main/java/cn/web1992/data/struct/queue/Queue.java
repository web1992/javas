package cn.web1992.data.struct.queue;

/**
 * @author web1992
 * @date 2022/1/25  11:23 上午
 */
public interface Queue<E> {

    boolean enqueue(E e);

    E dequeue();

}
