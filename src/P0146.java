import jdk.nashorn.internal.objects.NativeDebug;

import java.util.HashMap;

/**
 * P0146: LRU cache
 * 题意：实现LRU缓存结构，即最少被访问的元素在容量满了的时候被剔除
 * 做法：不太会做，看了题解之后复述一下思路。
 * 使用哈希+双链表的结构，前者用于快速查找出需要的节点，后者用于O（1）增删节点
 * 没有复杂的算法，这题主要考察的是实现一种数据结构并将其封装好的能力，需要比较耐心实现功能.
 * 速度只有55%，不知道为什么，可能一些常数没优化好吧......
 */

public class P0146 {
    public static void main( String[] args ) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        cache.put( 1 , 1 );
        cache.put( 2 , 2 );
        System.out.println( cache.get( 1 ));       // 返回  1
        cache.put( 3 , 3 );    // 该操作会使得关键字 2 作废
        System.out.println(cache.get( 2 ));       // 返回 -1 (未找到)
        cache.put( 4 , 4 );    // 该操作会使得关键字 1 作废
        System.out.println(cache.get( 1 ));       // 返回 -1 (未找到)
        System.out.println(cache.get( 3 ));       // 返回  3
        System.out.println(cache.get( 4 ));       // 返回  4
    }

    static class Node {
        public int key, val;
        Node prev, nxt;

        public Node( int key , int val ) {
            this.key = key;
            this.val = val;
        }
    }

    static class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {//构造函数用于构造空链表
            this.head = new Node( 0 , 0 );
            this.tail = new Node( 0 , 0 );
            head.nxt = tail;
            tail.prev = head;
            size = 0;
        }

        public void delete( Node target ) {//删除特定节点
            target.prev.nxt = target.nxt;
            target.nxt.prev = target.prev;
            size--;
        }

        public Node deleteLast() {
            if ( size == 0 ) return null;//空链表不做删除
            Node target = tail.prev;
            target.prev.nxt = target.nxt;
            target.nxt.prev = target.prev;
            size--;
            return target;
        }

        public void add(Node target){//添加节点，加在列表头
            target.nxt = head.nxt;
            target.prev = head;
            head.nxt.prev = target;
            head.nxt = target;
            size++;
        }

        public int getSize() {
            return size;
        }

        public Node getHead() {
            return head;
        }

        public Node getTail() {
            return tail;
        }
    }

    static class LRUCache {
        // key 映射到 Node(key, val)
        private HashMap<Integer, Node> map;
        // Node(k1, v1) <-> Node(k2, v2)...
        private DoubleList cache;

        private int cap;

        public LRUCache( int capacity ) {
            this.cap = capacity;
            this.cache = new DoubleList();
            this.map = new HashMap<>(  );
        }

        public int get( int key ) {
            if(!this.map.containsKey( key ))return -1;
            Node target = map.get( key );
            //代码复用，把这个节点移到链表头
            cache.delete( target );
            cache.add( target );
            return target.val;
        }

        public void put( int key , int value ) {
            Node now = new Node(key,value);
            if(this.map.containsKey( key )){//已存在，删旧添新
                this.cache.delete( map.get( key ) );
                map.remove( key );
            }else{
                if(cache.getSize()==cap){//满了
                    map.remove( cache.deleteLast().key );
                }
            }
            map.put( key,now );
            cache.add( now );
        }
    }

}
