//题意：LRU的实现
//题解：使用hashmap+双向链表 实现，练习Go的写法
package main



type LRUCache struct {
	capacity int
	size int
	cache map[int]*DLinkedNode
	head, tail *DLinkedNode
}

type DLinkedNode struct{
	key, val int
	prev, nxt *DLinkedNode
}

func initNode(key, val int) *DLinkedNode{
	return &DLinkedNode{
		key: key,
		val: val,
	}
}


func Constructor(capacity int) LRUCache {
	ca := LRUCache{
		cache: map[int]*DLinkedNode{},
		head: initNode(0,0),
		tail: initNode(0,0),
		capacity: capacity,
	}

	ca.head.nxt = ca.tail
	ca.tail.prev = ca.head

	return ca
}


func (this *LRUCache) Get(key int) int {
	if _, ok := this.cache[key]; !ok {
        return -1
    }
	node := this.cache[key]
	this.moveToHead(node)
	return node.val
}


func (this *LRUCache) Put(key int, value int)  {
	if this.Get(key) != -1{//have this key
		node := this.cache[key]
		node.val = value
		this.moveToHead(node)
	}else{
		node := initNode(key,value)
		this.cache[key] = node
		this.addToHead(node)
		this.size++
		if this.size > this.capacity{
			removed := this.removeTail()
			delete(this.cache, removed.key)
			this.size--
		}
	}
}

func (this *LRUCache) removeNode(node *DLinkedNode){
	node.prev.nxt = node.nxt
	node.nxt.prev = node.prev
}

func (this *LRUCache) addToHead(node *DLinkedNode){
	node.nxt = this.head.nxt
	this.head.nxt = node
	node.nxt.prev = node
	node.prev = this.head
}

func (this *LRUCache) moveToHead(node *DLinkedNode){
	this.removeNode(node)
	this.addToHead(node)
}

func (this *LRUCache) removeTail() *DLinkedNode{
	node := this.tail.prev
	this.removeNode(node)
	return node
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * obj := Constructor(capacity);
 * param_1 := obj.Get(key);
 * obj.Put(key,value);
 */