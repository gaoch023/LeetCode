package StringtoInteger;

public class StringtoInteger {
	boolean isWrong=true;
	 public int atoi(String str) {
		 
		 int charactor=1;
		 
		 int num=0;
		 if(str==null||str==""){
			 
			 isWrong=false;
			 return 0;
		 }
		 str=str.trim();
		 if(str.charAt(0)=='+'){
			 str=str.substring(1);
			 charactor=1;
		 }
		if(str.charAt(0)=='-'){
			 str=str.substring(1);
			 charactor=-1;
		}
		int i=0,n=str.length();
		while (i < n ) {
			if(!Character.isDigit(str.charAt(i))){
				isWrong=false;
				return 0;
			}
			int tem=Character.getNumericValue(str.charAt(i));
			
			num=num*10+tem;
			i++;
		}	 
		 num=num*charactor;
		return num;
	        
	    }
	 
	 
	 private static final int maxDiv10 = Integer.MAX_VALUE / 10;
	 public int atoi2(String str) {
	     if (str == null || str.length() == 0) {
	    	 isWrong=false;
	         return 0;
	     }
	     int i = 0;
	     int n = str.length();
	     while (i < n && str.charAt(i) == ' ') {
	         i++;
	     }
	     int sign = 1;
	     if (i < n && str.charAt(i) == '+') {
	         i++;
	     } else if (i < n && str.charAt(i) == '-') {
	         sign = -1;
	         i++;
	     }
	     int num = 0;
	     while (i < n && Character.isDigit(str.charAt(i))) {
	         int digit = Character.getNumericValue(str.charAt(i));
	         if (num > maxDiv10 || (num == maxDiv10 && digit >= 8)) {
	        	
	             return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
	         }
	         num = num * 10 + digit;
	         i++;
	     }
	     return sign * num;
	 }
}
