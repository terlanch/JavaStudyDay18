package cn.tedu.collectiondemo;

import java.util.ArrayList;
import java.util.Collection;

/*
 * Collection是集合的顶级接口
 * 
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		//创建集合
		Collection<String> coll = new ArrayList<String>();

		//添加元素
		coll.add("曹阳阳");
		coll.add("朴二爷");
		coll.add("古三弟");
		coll.add("栋哥");
		coll.add("张无忌");
		//清空集合中的元素  但是不是销毁
		//coll.clear();
		
		//判断集合中时候包含元素
//		boolean b1 = coll.contains("张三丰");
//		System.out.println(b1);
//		boolean b = coll.contains("栋哥");
//		System.out.println(b);
		//判断集合是否为空
//		System.out.println(coll.isEmpty());
		
		//删除指定的元素，如果删除成功，返回true
		//删除失败，返回false
//		boolean b1 = coll.remove("张无忌");
//		System.out.println(b1);
		//集合中实际存放的元素个数
		System.out.println(coll.size());
		
		//将集合转换为数组
		String[] str = coll.toArray(new String[0]);
		for(String string: str){
			
			System.out.print(string+" ");
		}
		
	//	Integer[] oi = coll.toArray(new Integer[0]);
	
		System.out.println(coll);
	}
}
