package br.com.anhezini.vector;

import br.com.anhezini.shared.List;

import static java.lang.System.arraycopy;

public class Vector<T> implements List<T> {

    public Object[] items = new Object[3];

    private int total = 0;

    @Override
    public void add(T t) {
        add(this.total, t);
    }

    @Override
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

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        validFilledIndex(index);
        return (T) this.items[index];
    }

    @Override
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

    @Override
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

    @Override
    public int size() {
        return this.total;
    }

}

