package cn.tedu.collectiondemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PracticDemo1 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("qwe");
		list.add("asd");
		list.add("zxc");
		list.add("opq");
		list.add("zxc");
		
		
		list.add(2, "jkl");
		//list.clear();
		
//		boolean b = list.contains("asd");
//		System.out.println(b);
		
//		String s = list.get(3);
//		System.out.println(s);//zxc
		
//		System.out.println(list.indexOf("zxc"));//3
//		System.out.println(list.lastIndexOf("zxc"));//5
		
//		System.out.println(list.remove(2));
		//如果删除成果返回true 如果失败返回false
//		System.out.println(list.remove("zxc"));
		
		System.out.println(list);
		//返回被替换的对象
		System.out.println(list.set(2, "mln"));
		
		//截取子集合
		List<String> subList = list.subList(2, 4);
		System.out.println(subList);
		
		String[] str = list.toArray(new String[0]);
		for(String string:str){
			System.out.print(string+" ");
		}
		System.out.println();
		
		System.out.println(list.size());
		
		System.out.println(list);
		
					
		Iterator it = list.iterator();
		while(it.hasNext()){
			String str1 = (String) it.next();
			
			System.out.print(str1+" ");
		}
	}
	
}
