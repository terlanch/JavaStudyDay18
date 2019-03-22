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
	//底层数组
	private String[] data;
	
	//定义一个记录实际使用长度的变量
	private int size = 0;
	
	//构造方法
	public ArrayListTest(){
		//默认初始容量为10
		data = new String[10];
	}
	
	//提供指定初始容量的构造方法
	public ArrayListTest(int len){
		if(len < 0){
			//参数不合法异常
			throw new IllegalArgumentException();
		}
		data = new String[len];
	}
	//添加元素
	public void add(String str){
		//在每一次添加元素的时候需要判断是否需要扩容
		//判断是否需要扩容
		if(size >= data.length){
			this.grow(data.length);
		}
		
		data[size++] = str;
		
	}
	
	//提供扩容方法
	private void grow(int length){
		
		if(data.length <= 1){
			data = Arrays.copyOf(data, data.length + 1);
		}else{
			data = Arrays.copyOf(data, data.length + data.length>>1);
		}
		
	}
	
	//插入元素
	public void add(int index,String str){
		//判断是否越界
		if(index > size || size < 0){
			throw new IndexOutOfBoundsException();
		}
		//判断是否需扩容
		if(size >= data.length){
			this.grow(data.length);
		}else{
		
		for(int i = size - 1;i >= index;i--){
			
			data[i+1] = data[i];	
		}
		//存放需要插入的数据
		data[index] = str;
		// 实际长度加一
		size++;
		}
	}
	//索引越界方法
	public void out(int index){
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException();
		}
	}
	
	//删除指定索引处的元素
	public void remove(int index){
		this.out(index);
		
		//将索引后面的元素向前移一位
		System.arraycopy(data, index+1, data, index, size - (index + 1));
		size--;
	}
	
	//删除指定的元素
	//要删除指定的元素，需要先找到对应元素的索引
	//然后调用我们已经写好的删除索引的方法
	public void remove(String str){
		int i = indexOf(str);
		if(i != -1){//如果找到了这个元素
			remove(i);//删除这个元素
		}else{
			System.out.println("找不到这个元素");
		}
		
	}
	
	//元素首次出现的索引
	public int indexOf(String str){
		for(int i = 0;i<size;i++){
			//先判断data[i] 和str都是null 的情况
			//又判断了data[i]不是null 并且和str相等
			if(data[i] == str || data[i] != null && data[i].equals(str)){
				return i;
			}
		}
		return -1;
	}
	
	//指定索引处的元素
	public String get(int index){
		//判断是否越界
		this.out(index);
		return data[index];
	}
	
	//修改指定索引处的元素
	public void set(int index,String str){
		//判断索引是否越界
		this.out(index);
		data[index] = str;
	}
	
	//清空集合
	public void clear(){
		data = new String[10];
		size = 0;
	}
	
	//判断是否包含某一个元素
	public boolean contains(String str){
		return indexOf(str) != -1;
	}
	
	//获取实际长度
	public int size(){
		return size;
	}
	
	//判断是否为空
	public boolean isEmpty(){
		return size == 0;
	}
	
	//截取子列表、
	public ArrayListTest subList(int fromIndex,int toIndex){
		//这一步只是判断了fromIndex 和 toIndex的范围
		
		//判断索引是否越界
		this.out(fromIndex);
		this.out(toIndex);
		
		if(fromIndex > toIndex){
			throw new IllegalArgumentException("参数不合法");
		}
	 
		//创建子列表
		ArrayListTest sublist = new ArrayListTest(toIndex - fromIndex);
		//从当前的数组中fromIndex处开始拷贝
		//拷贝到sublist对象中的data数组中，从0位开始到
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