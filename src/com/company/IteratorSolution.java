package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorSolution {

    public static <T extends Comparable<? super T>> Iterator<T> mergeSortedIterators(Iterator<T> left, Iterator<T> right) {
        return new Iterator<T>() {
            private final SpyIterator<T> l = new SpyIterator<>(left);
            private final SpyIterator<T> r = new SpyIterator<>(right);

            @Override
            public boolean hasNext() {
                return l.hasNext() || r.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                if (!l.hasNext()) return r.next();
                if (!r.hasNext()) return l.next();
                if (r.spy().compareTo(l.spy()) > 0) {
                    return l.next();
                } else {
                    return r.next();
                }
            }
        };
    }

    /**
     * Iterator that allows to check top element without moving cursor to the next one.
     *
     * @see SpyIterator#spy()
     */
    public static class SpyIterator<T> implements Iterator<T> {

        private final Iterator<T> delegate;
        private T cache;

        public SpyIterator(Iterator<T> it) {
            delegate = it;
            if (delegate.hasNext()) {
                cacheElement();
            }
        }

        private void cacheElement() {
            cache = delegate.next();
            if (cache == null) throw new IllegalStateException();
        }

        public T spy() {
            return cache;
        }

        @Override
        public boolean hasNext() {
            return (cache != null);
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T res = cache;
            if (delegate.hasNext()) {
                cacheElement();
            } else {
                cache = null;
            }
            return res;
        }
    }
}
