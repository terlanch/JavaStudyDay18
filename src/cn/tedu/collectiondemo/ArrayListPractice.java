package cn.tedu.collectiondemo;

import java.util.Arrays;

public class ArrayListPractice {
	public static void main(String[] args) {
		ArrayListTest alt = new ArrayListTest();
		alt.add("Golang");
		alt.add("Java");
		alt.add("Ruby");
		alt.add("C#");
		
		alt.add("C");
		alt.add(3,"OC");
		System.out.println(alt.indexOf("C"));
		System.out.println(alt.contains("C"));
		
		System.out.println(alt);
	}
}

class ArrayListTest{
	//�ײ�����
	private String[] data;
	
	//����һ����¼ʵ��ʹ�ó��ȵı���
	private int size = 0;
	
	//���췽��
	public ArrayListTest(){
		//Ĭ�ϳ�ʼ����Ϊ10
		data = new String[10];
	}
	
	//�ṩָ����ʼ�����Ĺ��췽��
	public ArrayListTest(int len){
		if(len < 0){
			//�������Ϸ��쳣
			throw new IllegalArgumentException();
		}
		data = new String[len];
	}
	//���Ԫ��
	public void add(String str){
		//��ÿһ�����Ԫ�ص�ʱ����Ҫ�ж��Ƿ���Ҫ����
		//�ж��Ƿ���Ҫ����
		if(size >= data.length){
			this.grow(data.length);
		}
		
		data[size++] = str;
		
	}
	
	//�ṩ���ݷ���
	private void grow(int length){
		
		if(data.length <= 1){
			data = Arrays.copyOf(data, data.length + 1);
		}else{
			data = Arrays.copyOf(data, data.length + data.length>>1);
		}
		
	}
	
	//����Ԫ��
	public void add(int index,String str){
		//�ж��Ƿ�Խ��
		if(index > size || size < 0){
			throw new IndexOutOfBoundsException();
		}
		//�ж��Ƿ�������
		if(size >= data.length){
			this.grow(data.length);
		}else{
		
		for(int i = size - 1;i >= index;i--){
			
			data[i+1] = data[i];	
		}
		//�����Ҫ���������
		data[index] = str;
		// ʵ�ʳ��ȼ�һ
		size++;
		}
	}
	//����Խ�緽��
	public void out(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
	}
	
	//ɾ��ָ����������Ԫ��
	public void remove(int index){
		this.out(index);
		
		//�����������Ԫ����ǰ��һλ
		System.arraycopy(data, index+1, data, index, size - (index + 1));
		size--;
	}
	
	//ɾ��ָ����Ԫ��
	//Ҫɾ��ָ����Ԫ�أ���Ҫ���ҵ���ӦԪ�ص�����
	//Ȼ����������Ѿ�д�õ�ɾ�������ķ���
	public void remove(String str){
		int i = indexOf(str);
		if(i != -1){//����ҵ������Ԫ��
			remove(i);//ɾ�����Ԫ��
		}else{
			System.out.println("�Ҳ������Ԫ��");
		}
		
	}
	
	//Ԫ���״γ��ֵ�����
	public int indexOf(String str){
		for(int i = 0;i<size;i++){
			//���ж�data[i] ��str����null �����
			//���ж���data[i]����null ���Һ�str���
			if(data[i] == str || data[i] != null && data[i].equals(str)){
				return i;
			}
		}
		return -1;
	}
	
	//ָ����������Ԫ��
	public String get(int index){
		//�ж��Ƿ�Խ��
		this.out(index);
		return data[index];
	}
	
	//�޸�ָ����������Ԫ��
	public void set(int index,String str){
		//�ж������Ƿ�Խ��
		this.out(index);
		data[index] = str;
	}
	
	//��ռ���
	public void clear(){
		data = new String[10];
		size = 0;
	}
	
	//�ж��Ƿ����ĳһ��Ԫ��
	public boolean contains(String str){
		return indexOf(str) != -1;
	}
	
	//��ȡʵ�ʳ���
	public int size(){
		return size;
	}
	
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0;
	}
	
	//��ȡ���б�
	public ArrayListTest subList(int fromIndex,int toIndex){
		//��һ��ֻ���ж���fromIndex �� toIndex�ķ�Χ
		
		//�ж������Ƿ�Խ��
		this.out(fromIndex);
		this.out(toIndex);
		
		if(fromIndex > toIndex){
			throw new IllegalArgumentException("�������Ϸ�");
		}
	 
		//�������б�
		ArrayListTest sublist = new ArrayListTest(toIndex - fromIndex);
		//�ӵ�ǰ��������fromIndex����ʼ����
		//������sublist�����е�data�����У���0λ��ʼ��
		System.arraycopy(this.data, fromIndex, sublist.data, 0, toIndex - fromIndex);
		sublist.size = toIndex - fromIndex;
		return sublist;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0;i<size;i++){
			if(i == size - 1){
				sb.append(data[i]);
			}else{
				sb.append(data[i]).append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
		
	}
	
}