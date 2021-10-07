import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class LRUCache {

    public LRUCache(int capacity) {
        this.m_count = 0;
        this.m_capacity = capacity;
        this.m_head = this.m_tail = null;
        this.m_nodeMap = new HashMap<>();
    }

    public int get(int key) {
        if (m_nodeMap.containsKey(key)) {
            Node node = m_nodeMap.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    private void moveToHead(Node node) {
        if (node == m_tail && node.pre != null) {
            m_tail = node.pre;
        }
        if (node != m_head) {
            Node pre = node.pre;
            Node next = node.next;
            node.next = m_head;
            node.pre = null;
            if (pre != null)
                pre.next = next;
            if (next != null)
                next.pre = pre;
            m_head.pre = node;
            m_head = node;
        }
    }

    private void insertToHead(Node node) {
        if (m_head == null) {
            m_head = node;
            m_tail = node;
            return;
        }
        node.pre = null;
        node.next = m_head;
        m_head.pre = node;
        m_head = node;
    }

    public void put(int key, int value) {
        if (m_nodeMap.containsKey(key)) {
            Node node = m_nodeMap.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            if (m_count < m_capacity) { // 直接插入结点到链表头部
                Node node = new Node(key, value);
                insertToHead(node);
                m_nodeMap.put(key, node);
                m_count ++;
            } else { // 需要换出最近最久未使用的链表尾部结点
                int oldKey = m_tail.key;
                m_tail.val = value;
                m_tail.key = key;
                m_nodeMap.remove(oldKey);
                m_nodeMap.put(key, m_tail);
                moveToHead(m_tail);
            }
        }
    }

    private int m_count;
    private int m_capacity;

    HashMap<Integer, Node> m_nodeMap;
    private Node m_head, m_tail;

    private class Node {

        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = this.next = null;
        }

    }


}
