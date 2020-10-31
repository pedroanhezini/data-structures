package br.com.anhezini.linked;

public class Node {

    private Node next;

    private Node previous;

    private Object element;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public static Node creatWithNext(Node next,
                                     Object element) {
        var node = new Node();
        node.setNext(next);
        node.setElement(element);
        return node;
    }

    public static Node createWithPrevious(Node previous,
                                          Object element) {
        var node = new Node();
        node.setPrevious(previous);
        node.setElement(element);
        return node;
    }

    public static Node createWithPreviousAndNext(Node previous,
                                                 Node next,
                                                 Object element) {
        var node = new Node();
        node.setPrevious(previous);
        node.setNext(next);
        node.setElement(element);
        return node;
    }
}
