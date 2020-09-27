
/**
 * @author lizheng
 *
 */
public class haha {
		private int val1;
	 public static void VARRAY(int ...arr) {   //可变长参数
		int []intarr=arr;  //为什么要多声明一个指针？
		for(int i:intarr) {
			System.out.println(i);
		}
	}	 
	 public void VARRAY2(int ...arr) {   //可变长参数
		int []intarr=arr;  //为什么要多声明一个指针？
		for(int i:intarr) {
			System.out.println(i);
		}
	}
	 
	 public static void main(String argv[]) {
//		 VARRAY(1,2,4,5);       //两种方法
		 haha A=new haha();
//		 A.VARRAY2(1,1,1);
		 aa wode= new aa();
		 myEnum2 ele1= myEnum2.A;
		 ele1.setName2("ji");
		 for(myEnum2 i : myEnum2.values()) {
			 System.out.printf("%s",i.getName());
		 }
//		 System.out.printf("%s",ele1.getName2());
		System.out.println(myEnum2.A.toString());
		System.out.println(A.getClass().getName());
	 }
}

class aa{
	public void name() {
		System.out.println("done");
	}
}
