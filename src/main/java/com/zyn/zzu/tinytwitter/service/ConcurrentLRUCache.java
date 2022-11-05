package com.zyn.zzu.tinytwitter.service;


import com.zyn.zzu.common.utils.R;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentLRUCache<K, V> {

    private ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();
    private ConcurrentLinkedDeque<K> queue = new ConcurrentLinkedDeque<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int sizeLimit;

    public ConcurrentLRUCache(int sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    public V get(K key) {
        V cached = cache.get(key);
        if (cached != null) {
            lock.readLock().lock();
            try {
                if (queue.removeLastOccurrence(key)) {
                    queue.offer(key);
                }
            } finally {
                lock.readLock().unlock();
            }

        }
        return cached;
    }

    public void put(K key, V val) {
        lock.writeLock().lock();
        try {
            if (cache.containsKey(key)) {
                queue.removeLastOccurrence(key);
            }
            if (queue.size() == sizeLimit) {
                K leastUsed = queue.poll();
                cache.remove(leastUsed);
            }
            cache.put(key, val);
            queue.offer(key);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean remove(K key) {
        lock.writeLock().lock();
        try {
            if (cache.containsKey(key)) {
                cache.remove(key);
                queue.removeLastOccurrence(key);
                return true;
            }
            return false;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int size() {
        return queue.size();
    }
}



