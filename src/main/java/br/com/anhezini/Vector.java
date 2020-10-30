package br.com.anhezini;

import java.util.ArrayList;

import static java.lang.System.arraycopy;

public class Vector<T> {

    public static void main(String[] args) {
        var myVector = new Vector<String>();
        myVector.add("foo");
        myVector.add("bar");
        myVector.add("zux");
        myVector.remove(0);
        System.out.println(myVector);
    }

    public Object[] items = new Object[3];

    private int total = 0;

    public void add(T t) {
        add(this.total, t);
    }

    public void add(int index, T t) {
        validAddIndex(index);
        increaseSize();
        shiftRight(index);
        this.items[index] = t;
        this.total++;
    }

    private void shiftRight(int index) {
        if ((this.total - index) >= 0) {
            arraycopy(this.items, index, this.items, index + 1, total - index);
        }
    }

    private void validAddIndex(int index) {
        if (!(index >= 0 && index <= this.total)) {
            throw new IllegalArgumentException("Invalid index");
        }
    }

    private void increaseSize() {
        if (this.total == this.items.length) {
            var newItems = new Object[2 * this.items.length];
            arraycopy(this.items, 0, newItems, 0, this.items.length);
            this.items = newItems;
        }
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        validFilledIndex(index);
        return (T) this.items[index];
    }


    public void remove(int index) {
        validFilledIndex(index);
        for (int i = index; i < this.total; i++) {
            if (i == (this.total - 1)) {
                this.items[i] = null;
            } else {
                this.items[i] = this.items[i + 1];
            }
        }
        this.total--;
    }

    private void validFilledIndex(int index) {
        if (!(index >= 0 && index < this.total)) {
            throw new IllegalArgumentException("Invalid index");
        }
    }

    public boolean contains(T t) {
        var hasItem = false;
        for (int i = 0; i < this.total; i++) {
            if (this.items[i].equals(t)) {
                hasItem = true;
                break;
            }
        }
        return hasItem;
    }

    public int size() {
        return this.total;
    }

}

