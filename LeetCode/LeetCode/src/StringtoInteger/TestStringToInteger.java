package StringtoInteger;

public class TestStringToInteger {

	public static void main(String[] args) {
		StringtoInteger si=new StringtoInteger();
		
		int res=si.atoi2("");
		if(si.isWrong)
		System.out.println(res);
		else
		System.out.println("WRONG");
	}
}
