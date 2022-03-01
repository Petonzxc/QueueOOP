package queue;

public class ArrayQueue extends AbstractQueue {
    private Object[] elements;
    private int head;

    public ArrayQueue() {
        this.elements = new Object[2];
        this.head = 0;
    }

    @Override
    protected void clearImpl() {
        head = 0;
        elements = new Object[2];
    }

    @Override
    protected void enqueueImpl(final Object element) {
        this.ensureCapacity(size + 1);
        elements[getTail()] = element;
    }

    @Override
    protected Object elementImpl() {
        return elements[head];
    }

    @Override
    protected Object dequeueImpl() {
        Object result = elements[head];
        elements[head] = null;
        head = this.getId(head + 1);
        return result;
    }

    private int getId(final int id) {
        return (id + elements.length) % elements.length;
    }

    private void ensureCapacity(final int capacity) {
        if (elements.length < capacity) {
            Object[] newElements = new Object[capacity * 2];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[this.getId(head + i)];
            }
            head = 0;
            elements = newElements;
        }
    }

    private int getTail() {
        return getId(head + size);
    }
}
