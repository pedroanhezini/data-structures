package br.com.anhezini.linked;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void shouldAddAIndexElement() {
        var myList = new LinkedList<String>();
        myList.add("foo");
        myList.add("bar");
        myList.add("zux");
        myList.add(1,"index");
        assertEquals("foo", myList.get(0));
        assertEquals("index",myList.get(1));
        assertEquals("bar",myList.get(2));
        assertEquals("zux",myList.get(3));
    }

    @Test
    void testAdd() {
    }

    @Test
    void addFirst() {
    }

    @Test
    void get() {
    }

    @Test
    void remove() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeLast() {
    }

    @Test
    void contains() {
    }

    @Test
    void size() {
    }
}