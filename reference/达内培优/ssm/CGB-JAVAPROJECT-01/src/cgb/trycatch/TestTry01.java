package cgb.trycatch;

public class TestTry01 {

	static int doMethod(int a){
		try{
		if(a<0)
		 throw new RuntimeException("参数不合法");
		 return a+1;
		}catch(RuntimeException e){
		 throw e;
		}finally{
		 System.out.println("finally");
		}
	}
	public static int doMethod(){
		int a=100;
		try{
			a++;//101
			return a;//temp=101--->return temp;
		}catch(Exception e){
			return 200;
		}finally{
			a++;
			System.out.println("doMethod.finally.a="+a);
		}
	}
	
	
	public static void main(String[] args) {
		//doMethod(-1);
		int number=doMethod();
		System.out.println(number);
	}
}
