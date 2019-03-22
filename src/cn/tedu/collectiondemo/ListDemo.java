package cn.tedu.collectiondemo;

import java.util.ArrayList;
import java.util.List;

/*
 * Collection�ӿڵ��ӽӿ�List�ӿ�
 * 
 * List�ӿڵ����ԣ�
 * List�ӿ��������-->�洢��ȡ����˳����һ�µģ��ʹ�ӡ˳���޹أ�
 * List�ӿڶ��������ķ���
 */
public class ListDemo {
	public static void main(String[] args) {
		//����List
		List<String> list = new ArrayList<String>();
		//���Ԫ��
		list.add("���Ŵ�ѩ");
		list.add("��Ѱ��");
		list.add("С���");
		list.add("������");
		list.add("С���");
		//����Ԫ��
		list.add(2, "��ʵ����");
//		list.add(6,"˾��ժ��");
		//ctrl + t �鿴��ļ̳й�ϵ
		//	IndexOutOfBoundsException
		
		
		
		//�鿴�Ƿ����Ԫ��
		boolean b = list.contains("С���");
		System.out.println(b);
		//��ȡָ���±��Ԫ��
		String s = list.get(4);
		System.out.println(s);
		
		//����ָ��Ԫ���״γ��ֵ�λ��
		System.out.println(list.indexOf("С���"));
		//����ָ��Ԫ�������ֵ�λ��
		System.out.println(list.lastIndexOf("С���"));
		System.out.println(list);
		//ɾ��ָ����������Ԫ��
		//����ֵ��ɾ����Ԫ��
		//System.out.println(list.remove(3));
		//ɾ��ָ���Ķ���������ظ�Ԫ��ֻɾ����һ��
		//System.out.println(list.remove("С���"));
		
		//�滻ָ����������Ԫ��
		System.out.println(list.set(1, "Ҷ�³�"));
		
		//��ȡ���б�
		//��ȡ�������ǰ�������1����Ԫ�أ����ǲ���������2����Ԫ��
		//��ͷ����β
		List<String> subList = list.subList(2, 5);
		System.out.println(subList);
		//�ȽϷ���
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
		//�ȽϷ���equlas �ײ�����λ��Ԫ�ص��ַ����бȽ�
		System.out.println(list1.equals(list2));
		
		
		
		
	}
}
