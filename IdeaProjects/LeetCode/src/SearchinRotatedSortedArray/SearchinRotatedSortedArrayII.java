package SearchinRotatedSortedArray;

/**
 * Created by Gaochao on 2015/9/10.
 */
public class SearchinRotatedSortedArrayII {

    public int search(int[] nums,int target){
        int low=0;
        int high=nums.length;
        int mid=0;
        while (low<=high){
            mid=(low+high)/2;
            if (nums[mid]==target){
                return mid;
            }
            if (nums[low]<nums[mid]){
                if (nums[low]<=target&&target<nums[mid]){
                    high=mid-1;
                }else {
                    low=mid+1;
                }
            }else if (nums[low]==nums[mid]){
                low++;
            }else {
                if (nums[mid]<target&&target<=nums[high]){
                    low=mid+1;
                }else {
                   high=mid-1;
                }
            }
        }
        return -1;
    }
}
