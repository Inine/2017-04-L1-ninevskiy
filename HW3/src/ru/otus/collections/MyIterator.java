package ru.otus.collections;

import java.util.ListIterator;

/**
 * Created by Ivan on 20.04.2017.
 */
public class MyIterator<T> implements ListIterator {
    private T current;
    private int position; //position left to
    private MyArrayList<T> myList;

    public MyIterator(MyArrayList<T> tMyArrayList) {
        myList = tMyArrayList;
        position = -1; //current must be left to current object
        current = (T)myList.get(position+1); //current object
    }

    @Override
    public boolean hasNext() {
        return (position + 1) < myList.size();
    }


    @Override
    public Object next() {
        position++;
        current = (T)myList.get(position+1);
        return current;
    }

    @Override
    public boolean hasPrevious() {
        return position > -1;
    }

    @Override
    public Object previous() {
        position--;
        current = (T)myList.get(position+1);
        return current;
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void set(Object o) {
        myList.set(position, (T)o);
    }

    @Override
    public void add(Object o) {
        throw new UnsupportedOperationException();
    }
}
