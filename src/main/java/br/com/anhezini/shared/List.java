package br.com.anhezini.shared;

public interface List<T> {

    void add(T t);

    void add(int index, T t);

    T get(int index);

    void remove(int index);

    boolean contains(T t);

    int size();

}
