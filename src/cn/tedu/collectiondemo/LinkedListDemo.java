package cn.tedu.collectiondemo;

public class LinkedListDemo {
	public static void main(String[] args) {
		LinkedListTest llt = new LinkedListTest();
		llt.add("aaa");
		llt.add("bbb");
		llt.add("ccc");
		llt.add("ddd");
		llt.add(4,"eee");
		llt.remove("eee");
		//System.out.println(llt.indexOf("ddd"));
		System.out.println(llt);
		//System.out.println(llt.indexOf("eee"));
		
	}
}

class LinkedListTest{
	//实际长度
	private int size = 0;
	//头结点
	private Node first;
	//尾节点
	private Node last;
	
	private class Node{
		String data;//节点的数据
		Node prev;//上一个结点的结点
		Node next;//下一个结点的结点
		
		public Node(String data,Node prev,Node next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
	}
	
	public LinkedListTest(){
		
	}
	
	//添加
	public void add(String str){
		//创建结点
		Node node = new Node(str,null,null);
		if(size == 0){//链表没有元素的时候
			this.first = node;
				
		}else{
			this.last.next = node;
			node.prev = this.last;
			
		}
		this.last = node;
		size++;
	}
	//插入
	public void add(int index,String str){
		if(index > size || index <0){
			throw new IndexOutOfBoundsException();
		}
		
		if(index == size ){//插入到最后就是添加元素
			add(str);
			return;
		}
		Node node = new Node(str,null,null);
		if(index == 0){
			node.next = this.first;
			this.first.prev = node;
			
			this.first = node;
		}else{
			//寻找index索引处的结点
			Node no = getNode(index);
			
			Node no1 = no.prev;//index上一个结点
			no1.next = node;
			node.prev = no1;
			node.next = no;
			no.prev = node;
		
		}
		size++;
	}
	
	public void out(int index){
		if(index >= size || index < 0){
			throw new IndexOutOfBoundsException();		
		}
	}
	//删除指定索引处元素
	public void remove(int index){
		this.out(index);
		
		//删除头部
		if(index == 0){
			this.first = this.first.next;
			this.first.prev = null;
		}else if(index == (size - 1)){//删除尾部
			this.last = this.last.prev;
			this.last.next = null;
		}else{//删除中间元素
			//获取到中间要被删除的结点
			Node no = getNode(index);
			//no.prev是no的上一个结点
			//no.next是no的下一个结点
			no.prev.next = no.next;
			no.next.prev = no.prev;
		}
		size--;	
	}
	//获取index处的结点
	//如果index在后半段  还可以倒着查 Node no = this.last
	private Node getNode(int index){
		
		Node no = this.first;
		for(int i = 0;i<index;i++){
			no = no.next;
		}
		return no;
	}
	
	//删除指定字符的索引
	public void remove(String str){
		int i = indexOf(str);
		if(i != -1){
			remove(i);
		}
	}
	
	//寻找指定字符串首次出现的索引
	public int indexOf(String str){
		for(int i = 0;i < size ;i++){
			if(getNode(i).data == str || getNode(i).data != null && getNode(i).data.equals(str)){
				return i;
			}
		}
		return -1;
	}
	
	//清空集合
	public void clear(){
		this.first = this.last = null;
		size = 0;
	}
	
	//查看链表中是否包含对应的字符串
	public boolean contains(String str){
		return indexOf(str) != -1;
	}
	
	//获取索引对应的字符串
	public String get(int index){
		this.out(index);
		return getNode(index).data;
	}
	
	//修改索引处对应的内容
	public void set(int index,String str){
		//判断是否越界
		this.out(index);
		getNode(index).data = str;
	}
	
	//判断是否为空
	public boolean isEmpty(){
		return size == 0;
	}
	
	//返回实际长度
	public int size(){
		return size;
	}
	
	//截取子列表
	public LinkedListTest subList(int fromIndex,int toIndex){
		this.out(fromIndex);
		this.out(toIndex);
		
		if(fromIndex > toIndex){
			throw new IllegalArgumentException();
		}
		
		//创建一个新列表，从fromIndex处开始一个一个添加到toIndex
		LinkedListTest llt = new LinkedListTest();
		Node no = getNode(fromIndex);
		for(int i = fromIndex;i<toIndex;i++){
			llt.add(no.data);
			no = no.next;
		}
		return llt;
	}
	
	//toSting
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0;i < size;i++){
			if(i == size - 1){
				sb.append(getNode(i).data);
			}else{
				sb.append(getNode(i).data).append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	
}
