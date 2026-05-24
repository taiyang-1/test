
public class ArrayTest {
	
	public static void main(String[] args) {
		
		//1. 一维数组的声明和初始化
		int num;//声明
		num = 10;//初始化
		int id = 1001;//声明 + 初始化
		
		int[] ids;//声明
		//1.1 静态初始化:数组的初始化和数组元素的赋值操作同时进行
		ids = new int[]{1001,1002,1003,1004};
		//1.2动态初始化:数组的初始化和数组元素的赋值操作分开进行
		String[] names = new String[5];

		int[] arr4 = {1,2,3,4,5};//类型推断

		names[0] = "王铭";
		names[1] = "王赫";
		names[2] = "张学良";
		names[3] = "孙居龙";
		names[4] = "王宏志";//charAt(0)
//
		System.out.println(names.length);//5
		System.out.println(ids.length);
		

		
		for(int i = 0;i < names.length;i++){
			System.out.println(names[i]);
		}
		
		
	}

}
