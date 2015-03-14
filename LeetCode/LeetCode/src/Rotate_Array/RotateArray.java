package Rotate_Array;

public class RotateArray {

	public	void rotate(int nums[], int k) {
       int[] tem1=new int[k];
       int[] tem2=new int[nums.length-k];
       System.arraycopy(nums, nums.length-k, tem1, 0, tem1.length);
       System.arraycopy(nums, 0, tem2, 0, tem2.length);
       System.arraycopy(tem1, 0, nums, 0, tem1.length);
       System.arraycopy(tem2, 0, nums, k, tem2.length);
    }

	
}
