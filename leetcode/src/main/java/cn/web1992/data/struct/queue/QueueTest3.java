package cn.web1992.data.struct.queue;

/**
 * @author web1992
 * @date 2022/1/24  11:57 上午
 */
public class QueueTest3 {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());


    }

}
