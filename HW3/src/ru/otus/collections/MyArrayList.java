package ru.otus.collections;
import java.util.*;

/**
 * Created by ivan on 4/15/17.
 */
public class MyArrayList<T> implements List {

    private int maxSize;
    private int currentSize;
    private T[] data;

    public MyArrayList(){
        maxSize = 10;
        currentSize = 0;
        data =  (T[])(new Object[maxSize]);
    }

    public MyArrayList(int size){
        maxSize = size;
        currentSize = 0;
        data =  (T[])(new Object[maxSize]);
    }

    public String toString(){
        String result = "";
        for (int i = 0; i < currentSize; i++){
            if (!result.isEmpty()){
                result += ", ";
            }
            result += data[i].toString();
        }
        return result;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        return new MyIterator(this);
    }

    @Override
    public Object[] toArray() {
        Object[] objArray  = new Object[currentSize];
        for (int i = 0; i < currentSize; i++) {
            objArray[i] = data[i];
        }
        return objArray;
    }

    @Override
    public boolean add(Object o) {
        if (currentSize == maxSize){
            maxSize = maxSize*2;
            T[] newData =  (T[])(new Object[maxSize]);
            System.arraycopy(data, 0, newData, 0, currentSize);
            data = newData;
        }
        data[currentSize] = (T)o;
        currentSize++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        for (int i =0; i < currentSize; i++){
            data[i] = null;
        }
        currentSize = 0;
    }

    @Override
    public Object get(int index) {
        return data[index];
    }


    @Override
    public Object set(int index, Object element) {
        T oldValue = data[index];
        data[index] = (T)element;
        return oldValue;
    }

    @Override
    public void add(int index, Object element) {
        if (currentSize == maxSize){
            maxSize = maxSize*2;
            T[] newData =  (T[])(new Object[maxSize]);
            System.arraycopy(data, 0, newData, 0, currentSize);
            data = newData;
        }
        System.arraycopy(data, index, data, index+1, currentSize-index);
        data[index] = (T)element;
        currentSize++;
    }

    @Override
    public Object remove(int index) {
        T objToRemove = data[index];
        System.arraycopy(data, index+1, data, index, currentSize-index-1);
        data[currentSize-1] = null;
        currentSize--;
        return objToRemove;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < currentSize; i++){
            if (data[i].equals((T)o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        for (int i = 0; i < currentSize; i++){
            if (data[i].equals((T)o)){
                lastIndex =  i;
            }
        }
        return lastIndex;
    }

    @Override
    public ListIterator listIterator() {
        return new MyIterator(this);
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }
}
