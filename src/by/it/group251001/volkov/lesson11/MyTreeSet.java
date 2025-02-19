package by.it.group251001.volkov.lesson11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyTreeSet<E> implements Set<E> {
    private Object[] mas = new Object[0];
    private int actSize = 0;

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        for (int i = 0; i < actSize - 1; i++) {
            res.append(mas[i].toString()).append(", ");
        }
        return res + mas[actSize - 1].toString() + "]";
    }
    public int size() {
        return actSize;
    }

    public void clear() {
        actSize = 0;
        mas = new Object[0];
    }

    public boolean isEmpty() {
        return actSize == 0;
    }

    public boolean add(E e) {
        int index = 0;
        while (index < actSize && ((Comparable<? super E>) mas[index]).compareTo(e) < 0) {
            index++;
        }
        if (!isEmpty() && index < actSize && mas[index].equals(e)) {
            return false;
        }
        if (mas.length == actSize) {
            mas = Arrays.copyOf(mas, actSize * 2 + 1);
        }
        actSize++;
        for (int i = actSize - 1; i > index; i--) {
            mas[i] = mas[i - 1];
        }
        mas[index] = e;
        return true;
    }

    public boolean remove(Object o) {
        int index = 0;
        while (index < actSize && !mas[index].equals(o))
            index++;
        if (index == actSize)
            return false;
        for (int i = index; i < size() - 1; i++)
            mas[i] = mas[i + 1];
        actSize--;
        return true;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < actSize; i++)
            if (mas[i].equals(o)) {
                return true;
            }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean retBull = false;
        for (E o : c) {
            if (add(o)) {
                retBull = true;
            }
        }
        return true;
    }

    public boolean removeAll(Collection<?> c) {
        boolean[] u = new boolean[actSize];
        int kol = 0, cnt = 0;
        for (int i = 0; i < actSize; i++)
            if (c.contains(mas[i])) {
                u[i] = true;
                kol++;
            }
        if (kol == 0)
            return false;
        Object[] newArr = new Object[actSize - kol];
        for (int i = 0; i < actSize; i++)
            if (!u[i])
                newArr[cnt++] = mas[i];
        mas = newArr;
        actSize = actSize - kol;
        return true;
    }

    public boolean retainAll(Collection<?> c) {
        boolean[] u = new boolean[actSize];
        int kol = 0, cnt = 0;
        for (int i = 0; i < actSize; i++)
            if (c.contains(mas[i])) {
                u[i] = true;
                kol++;
            }
        if (kol == actSize)
            return false;
        Object[] newArr = new Object[kol];
        for (int i = 0; i < actSize; i++)
            if (u[i])
                newArr[cnt++] = mas[i];
        mas = newArr;
        actSize = kol;
        return true;
    }
}
