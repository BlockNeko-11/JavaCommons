package io.github.blockneko11.commons.collection.set;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @since 0.1.0
 */
public class ConcurrentHashSet<E>
        extends AbstractSet<E>
        implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Object PRESENT = new Object();

    private final ConcurrentHashMap<E, Object> map;

    public ConcurrentHashSet() {
        this.map = new ConcurrentHashMap<>();
    }

    public ConcurrentHashSet(int initialCapacity) {
        this.map = new ConcurrentHashMap<>(initialCapacity);
    }

    public ConcurrentHashSet(int initialCapacity, float loadFactor) {
        this.map = new ConcurrentHashMap<>(initialCapacity, loadFactor);
    }

    public ConcurrentHashSet(int initialCapacity, float loadFactor, int concurrencyLevel) {
        this.map = new ConcurrentHashMap<>(initialCapacity, loadFactor, concurrencyLevel);
    }

    public ConcurrentHashSet(Collection<? extends E> c) {
        this((int) (c.size() / 0.75f));
        this.addAll(c);
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.map.containsKey(o);
    }

    @Override
    public boolean add(E e) {
        return this.map.put(e, PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        return this.map.remove(o) == PRESENT;
    }

    @Override
    public void clear() {
        this.map.clear();
    }
}
