package queue;

public class LinkedQueue extends AbstractQueue {
    private Node head, tail;

    @Override
    protected void clearImpl() {
        head = null;
        tail = null;
    }

    protected void enqueueImpl(final Object element) {
        if(size == 0) {
            head = new Node(element, null);
            tail = head;
        } else {
            tail.next = new Node(element, null);
            tail = tail.next;
        }
    }

    @Override
    protected Object elementImpl() {
        return head.element;
    }

    @Override
    protected Object dequeueImpl() {
        Object result = head.element;
        head = head.next;
        return result;
    }

    private static class Node {
        private final Object element;
        private Node next;

        public Node(Object element, Node prev) {
            this.element = element;
            this.next = prev;
        }
    }
}
