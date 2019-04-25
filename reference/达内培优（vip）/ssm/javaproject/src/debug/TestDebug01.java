package debug;

public class TestDebug01 {
	static int doMethod(int a,int b){
		try{
		 int result=a/b;
		 return result;
		}catch(Exception e){
		 //e.printStackTrace();
		 throw new RuntimeException(e);
		}finally{
		 System.out.println("finally");
		}
	}
	public static void main(String[] args) {
		int result=doMethod(10,2);
		System.out.println(result);
	}
}
