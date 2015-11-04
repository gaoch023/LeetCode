package SearchinRotatedSortedArray;

/**
 * Created by Gaochao on 2015/9/9.
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums,int target){
        int index = -1;
        int low = 0;
        int high = nums.length-1;
        int mid =0;
        while (low<=high){
            mid = (low+high)/2;
            if (nums[mid]==target)
                return mid;
            if (nums[low]<=nums[mid]){
                if (target>=nums[low]&&target<nums[mid]){
                    high = mid-1;
                }else {
                    high = mid+1;
                }
            }else {

                if (target>=nums[mid]&&target<=nums[high]){
                    low=mid+1;
                }else {
                    high=mid-1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums={8,12,24,1,3,5,6};
        int index= new SearchinRotatedSortedArray().search(nums,3);
        System.out.println(index);
    }
}
