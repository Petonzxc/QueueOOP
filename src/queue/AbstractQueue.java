package queue;

import java.util.Objects;

public abstract class AbstractQueue implements Queue {
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    protected abstract Object dequeueImpl();

    @Override
    public Object dequeue() {
        assert size >= 1;
        Object result = dequeueImpl();
        size--;
        return result;
    }

    protected abstract Object elementImpl();

    @Override
    public Object element() {
        assert size >= 1;
        return elementImpl();
    }

    protected abstract void enqueueImpl(Object element);

    @Override
    public void enqueue(final Object element) {
        Objects.requireNonNull(element);
        enqueueImpl(element);
        size++;
    }

    protected abstract void clearImpl();

    @Override
    public void clear() {
        clearImpl();
        size = 0;
    }
}
