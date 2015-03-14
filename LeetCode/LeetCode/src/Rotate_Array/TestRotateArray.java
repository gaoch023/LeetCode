package Rotate_Array;

public class TestRotateArray {

	public static void main(String[] args) {
		RotateArray2 ra=new RotateArray2();
		int[] nums=new int[7];
		for(int i=0;i<nums.length;i++){
			nums[i]=i+1;
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		ra.rotate(nums, 4);
		
		for(int i=0;i<nums.length;i++){
			System.out.print(nums[i]+" ");
		}
	}
}
