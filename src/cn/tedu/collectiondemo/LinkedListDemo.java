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
	//ʵ�ʳ���
	private int size = 0;
	//ͷ���
	private Node first;
	//β�ڵ�
	private Node last;
	
	private class Node{
		String data;//�ڵ������
		Node prev;//��һ�����Ľ��
		Node next;//��һ�����Ľ��
		
		public Node(String data,Node prev,Node next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
	}
	
	public LinkedListTest(){
		
	}
	
	//���
	public void add(String str){
		//�������
		Node node = new Node(str,null,null);
		if(size == 0){//����û��Ԫ�ص�ʱ��
			this.first = node;
				
		}else{
			this.last.next = node;
			node.prev = this.last;
			
		}
		this.last = node;
		size++;
	}
	//����
	public void add(int index,String str){
		if(index > size || index <0){
			throw new IndexOutOfBoundsException();
		}
		
		if(index == size ){//���뵽���������Ԫ��
			add(str);
			return;
		}
		Node node = new Node(str,null,null);
		if(index == 0){
			node.next = this.first;
			this.first.prev = node;
			
			this.first = node;
		}else{
			//Ѱ��index�������Ľ��
			Node no = getNode(index);
			
			Node no1 = no.prev;//index��һ�����
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
	//ɾ��ָ��������Ԫ��
	public void remove(int index){
		this.out(index);
		
		//ɾ��ͷ��
		if(index == 0){
			this.first = this.first.next;
			this.first.prev = null;
		}else if(index == (size - 1)){//ɾ��β��
			this.last = this.last.prev;
			this.last.next = null;
		}else{//ɾ���м�Ԫ��
			//��ȡ���м�Ҫ��ɾ���Ľ��
			Node no = getNode(index);
			//no.prev��no����һ�����
			//no.next��no����һ�����
			no.prev.next = no.next;
			no.next.prev = no.prev;
		}
		size--;	
	}
	//��ȡindex���Ľ��
	//���index�ں���  �����Ե��Ų� Node no = this.last
	private Node getNode(int index){
		
		Node no = this.first;
		for(int i = 0;i<index;i++){
			no = no.next;
		}
		return no;
	}
	
	//ɾ��ָ���ַ�������
	public void remove(String str){
		int i = indexOf(str);
		if(i != -1){
			remove(i);
		}
	}
	
	//Ѱ��ָ���ַ����״γ��ֵ�����
	public int indexOf(String str){
		for(int i = 0;i < size ;i++){
			if(getNode(i).data == str || getNode(i).data != null && getNode(i).data.equals(str)){
				return i;
			}
		}
		return -1;
	}
	
	//��ռ���
	public void clear(){
		this.first = this.last = null;
		size = 0;
	}
	
	//�鿴�������Ƿ������Ӧ���ַ���
	public boolean contains(String str){
		return indexOf(str) != -1;
	}
	
	//��ȡ������Ӧ���ַ���
	public String get(int index){
		this.out(index);
		return getNode(index).data;
	}
	
	//�޸���������Ӧ������
	public void set(int index,String str){
		//�ж��Ƿ�Խ��
		this.out(index);
		getNode(index).data = str;
	}
	
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0;
	}
	
	//����ʵ�ʳ���
	public int size(){
		return size;
	}
	
	//��ȡ���б�
	public LinkedListTest subList(int fromIndex,int toIndex){
		this.out(fromIndex);
		this.out(toIndex);
		
		if(fromIndex > toIndex){
			throw new IllegalArgumentException();
		}
		
		//����һ�����б���fromIndex����ʼһ��һ����ӵ�toIndex
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
