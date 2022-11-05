package com.zyn.zzu.tinytwitter.service;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    class DLinkNode {
        int key;
        DLinkNode prev;
        DLinkNode next;
        DLinkNode() {
        }

        DLinkNode(int _key) {
            this.key = _key;
        }
    }

    DLinkNode head, tail;
    Map<Integer, DLinkNode> map = new HashMap<>();

    int capacity;

    public LruCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            DLinkNode node = map.get(key);
            moveToHead(key, node);
            return key;
        }
    }

    public void put(int key) {
        if (map.size() >= capacity && !map.containsKey(key)) {
            DLinkNode tmpNode = tail.prev;
            tmpNode.prev.next = tail;
            tail.prev = tmpNode.prev;
            map.remove(tmpNode.key);
        }
        if (!map.containsKey(key)) {
            DLinkNode node = new DLinkNode(key);
            map.put(key, node);
            addToHead(node);
        } else {
            moveToHeadAndUpdate(key);
        }
    }

    public void addToHead(DLinkNode node) {
        node.prev = head;
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
    }


    public void moveToHeadAndUpdate(int key) {
        DLinkNode node = map.get(key);
        moveToHead(key, node);
    }

    public void moveToHead(int key, DLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;

        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }
}
