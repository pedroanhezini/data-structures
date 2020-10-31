package br.com.anhezini.linked;

import br.com.anhezini.shared.List;

import static br.com.anhezini.linked.Node.*;

public class LinkedList<T> implements List<T> {

    private Node first;

    private Node last;

    private int total = 0;

    private boolean hasNode(int index) {
        return index > 0 && index < this.total;
    }

    private void validIndex(int index) {
        if (hasNode(index)) {
            throw new IllegalArgumentException("Invalid index");
        }
    }


    private Node getNode(int index) {
        validIndex(index);
        var node = this.first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public void add(int index, T t) {
        if (index == 0) {
            addFirst(t);
        } else if (index == total) {
            var newLast = createWithPrevious(this.last, t);
            this.last.setNext(newLast);
            this.last = newLast;
            this.total++;
        } else {
            var indexNode = getNode(index);
            var previousNode = indexNode.getPrevious();
            var newNode = createWithPreviousAndNext(previousNode, indexNode, t);
            previousNode.setNext(newNode);
            indexNode.setPrevious(newNode);
            this.total++;
        }
    }

    @Override
    public void add(T t) {
        add(this.total, t);
    }

    public void addFirst(T t) {
        var newFirst = creatWithNext(this.first, t);
        this.first = newFirst;
        if (total == 0) {
            this.last = newFirst;
        }
        total++;
    }


    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) getNode(index);
    }

    @Override
    public void remove(int index) {
        validIndex(index);
        if(index == 0){
            removeFirst();
        }else if(index == this.total){
            removeLast();
        }else{
           var indexNode = getNode(index);
           var previousNode = indexNode.getPrevious();
           var nextNode = indexNode.getNext();
           previousNode.setNext(nextNode);
           nextNode.setPrevious(previousNode);
           this.total--;
        }
    }

    public void removeFirst() {
        validIndex(0);
        this.first = this.first.getNext();
        total--;
        if (this.total == 0) {
            this.last = null;
        }
    }

    public void removeLast() {
        validIndex(this.total - 1);
        if (this.total == 1) {
            removeFirst();
        } else {
            this.last = this.last.getPrevious();
            this.last.setNext(null);
            total--;
        }
    }

    @Override
    public boolean contains(T t) {
        var hasNode = false;
        var node = this.first;
        while (node != null) {
            if (node.getElement().equals(t)) {
                hasNode = true;
                break;
            }
            node = node.getNext();
        }
        return hasNode;
    }

    @Override
    public int size() {
        return this.total;
    }


}
