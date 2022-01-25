package cn.web1992.data.struct.stack;

public class ArrayStack<E> implements Stack<E> {

    private Object[] element;
    private int count;
    private int ptr;


    public ArrayStack(int maxCount) {
        this.element = new Object[maxCount];
        this.count = maxCount;
    }

    public boolean push(E e) {
        if (ptr == count) {
            return false;
        }
        element[ptr++] = e;
        return true;
    }


    public E pop() {
        if (ptr == 0) {
            return null;
        }
        Object obj = element[ptr - 1];
        ptr--;
        return (E) obj;
    }
}