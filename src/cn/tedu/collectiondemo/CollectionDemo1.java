package cn.tedu.collectiondemo;

import java.util.ArrayList;
import java.util.Collection;

/*
 * Collection�Ǽ��ϵĶ����ӿ�
 * 
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		//��������
		Collection<String> coll = new ArrayList<String>();

		//���Ԫ��
		coll.add("������");
		coll.add("�Ӷ�ү");
		coll.add("������");
		coll.add("����");
		coll.add("���޼�");
		//��ռ����е�Ԫ��  ���ǲ�������
		//coll.clear();
		
		//�жϼ�����ʱ�����Ԫ��
//		boolean b1 = coll.contains("������");
//		System.out.println(b1);
//		boolean b = coll.contains("����");
//		System.out.println(b);
		//�жϼ����Ƿ�Ϊ��
//		System.out.println(coll.isEmpty());
		
		//ɾ��ָ����Ԫ�أ����ɾ���ɹ�������true
		//ɾ��ʧ�ܣ�����false
//		boolean b1 = coll.remove("���޼�");
//		System.out.println(b1);
		//������ʵ�ʴ�ŵ�Ԫ�ظ���
		System.out.println(coll.size());
		
		//������ת��Ϊ����
		String[] str = coll.toArray(new String[0]);
		for(String string: str){
			
			System.out.print(string+" ");
		}
		
	//	Integer[] oi = coll.toArray(new Integer[0]);
	
		System.out.println(coll);
	}
}
