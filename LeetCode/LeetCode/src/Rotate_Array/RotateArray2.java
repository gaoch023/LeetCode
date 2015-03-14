package Rotate_Array;

public class RotateArray2 {

	public	void rotate(int nums[], int k) {
       int[] tem1=new int[k];
       int[] tem2=new int[nums.length-k];
      for(int i=0;i<nums.length-k;i++){
    	  tem2[i]=nums[i];
    	  System.out.print(tem2[i]+" ");
      }
      System.out.println();
      for(int i=0;i<k;i++){
    	  tem1[i]=nums[nums.length-k+i];
    	  System.out.print(tem1[i]+" ");
      }
      System.out.println();
      for(int i=0;i<nums.length;i++){
    	  if(i<k)
    		  nums[i]=tem1[i];
    	  else
    		  nums[i]=tem2[i-k];
      }
    
    }

	
}
