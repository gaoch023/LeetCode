package removeDuplicates;

/**
 * Created by Gaochao on 2015/9/8.
 */

/**
 * Follow up for "Remove Duplicates":
 *What if duplicates are allowed at most twice?
 */
public class RemoveDuplicatesII {
    public int removeDuplicatesII(int[] nums){
        int index=0;

        for (int i=0;i<nums.length;i++){
            if (i>0 && i<nums.length-1 && nums[i]==nums[i-1]&&nums[i]==nums[i+1]){
                continue;
            }
            nums[index++]=nums[i];
        }
        return index;
    }

    public static void main(String[] args) {

        int[] nums={1,2,1,3,3,3,4,5,2};
        int length=new RemoveDuplicatesII().removeDuplicatesII(nums);
        for (int i=0;i<nums.length;i++)
        System.out.print(nums[i] + " ");
        System.out.println();
        System.out.println(length);
    }
}
