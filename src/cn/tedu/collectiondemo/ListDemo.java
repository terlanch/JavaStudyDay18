package cn.tedu.collectiondemo;

import java.util.ArrayList;
import java.util.List;

/*
 * Collection接口的子接口List接口
 * 
 * List接口的特性：
 * List接口是有序的-->存储和取出的顺序是一致的（和打印顺序无关）
 * List接口都有索引的方法
 */
public class ListDemo {
	public static void main(String[] args) {
		//创建List
		List<String> list = new ArrayList<String>();
		//添加元素
		list.add("西门吹雪");
		list.add("李寻欢");
		list.add("小鱼儿");
		list.add("无情子");
		list.add("小鱼儿");
		//插入元素
		list.add(2, "老实和尚");
//		list.add(6,"司空摘星");
		//ctrl + t 查看类的继承关系
		//	IndexOutOfBoundsException
		
		
		
		//查看是否包含元素
		boolean b = list.contains("小鱼儿");
		System.out.println(b);
		//获取指定下标的元素
		String s = list.get(4);
		System.out.println(s);
		
		//查找指定元素首次出现的位置
		System.out.println(list.indexOf("小鱼儿"));
		//查找指定元素最后出现的位置
		System.out.println(list.lastIndexOf("小鱼儿"));
		System.out.println(list);
		//删除指定索引处的元素
		//返回值是删除的元素
		//System.out.println(list.remove(3));
		//删除指定的对象，如果有重复元素只删除第一个
		//System.out.println(list.remove("小鱼儿"));
		
		//替换指定索引处的元素
		System.out.println(list.set(1, "叶孤城"));
		
		//截取子列表
		//截取的内容是包含参数1处的元素，但是不包含参数2处的元素
		//包头不包尾
		List<String> subList = list.subList(2, 5);
		System.out.println(subList);
		//比较方法
		List<String> list1 = new ArrayList<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		
		List<String> list2 = new ArrayList<String>();
		list2.add(new String("a"));
		list2.add("b");
		list2.add("c");
		list2.add("d");
		//比较方法equlas 底层是逐位对元素的字符进行比较
		System.out.println(list1.equals(list2));
		
		
		
		
	}
}
