package by.it.group251005.ivanov.lesson09;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class ListA<E> implements List<E> {
    public class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }

        Node() {
            this.value = null;
            this.next = null;
        }
    }
    private Node<E> head;
    private int size;

    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public String toString() {
        String sb = new String();
        //StringBuilder sb = new StringBuilder();
        sb += "[";
        //sb.append('[');

        Node<E> ptr = head;
        if(ptr != null){
            //sb.append(ptr.value);
            sb += ptr.value;
            ptr = ptr.next;
        }

        while(ptr != null){
            //sb.append(", ").append(ptr.value);
            sb += ", " + ptr.value;
            ptr = ptr.next;
        }

        /*

        for (Node ptr = head; ptr != null; ptr = ptr.next) {
            sb.append(ptr.value);
            if (ptr.next != null) {
                sb.append(", ");
            }
        }

         */

        //sb.append(']');
        sb += "]";
        return sb;
    }

    @Override
    public boolean add(E e) {
        Node<E> second = new Node<>(e);

        if(this.size == 0){
            this.head = second;
            this.size = this.size + 1;
            return true;
        }
        Node<E> ptr = this.head;
        while (ptr.next != null){           //!!!
            ptr = ptr.next;
        }
        ptr.next = second;
        this.size = this.size + 1;

        return true;
    }

    @Override
    public E remove(int index) {

        if (index < 0 || index >= this.size) {
            return null;
        }


        int oldSize = this.size--;

        if (index == 0) {
            E result = this.head.value;
            if (oldSize == 1) {
                this.head = null;
            } else {
                this.head = this.head.next;
            }
            return result;
        }


        Node<E> ptr = this.head;
        for (int i = 1; i < index; i++) {
            ptr = ptr.next;
        }

        E result = ptr.next.value;

        if (index + 1 == oldSize) {
            ptr.next = null;
        } else {
            ptr.next = ptr.next.next;
        }

        return result;
    }

    @Override
    public int size() {
        return this.size;
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    @Override
    public void add(int index, E element) {

    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    ////////        Эти методы имплементировать необязательно    ////////////
    ////////        но они будут нужны для корректной отладки    ////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
