package findMedianSortedArrays;

/**
 * Created by Gaochao on 2015/9/11.
 */
public class FindMedianSortedArrays {
    public int findMedianSortedArrays(int[] nums1,int[] nums2){
        if (nums1.length==0&&nums2.length==0)
            return 0;
        if (nums1.length==0){
            return nums2[(nums2.length-1)/2];
        }
        if (nums2.length==0){
            return nums1[(nums1.length-1)/2];
        }
        int m1=nums1[(nums1.length-1)/2];

        int m2=nums2[(nums2.length-1)/2];

        System.out.println("m1"+m1);
        System.out.println("m2"+m2);

        int[] res1=null;
        int[] res2=null;
        if (m1==m2)
            return m1;
        else if (m1>m2){
            if (nums2.length%2==0){
                 res1=new int[nums2.length/2];
                System.arraycopy(nums2,(nums2.length+1)/2,res1,0,nums2.length/2);
            }else {
                 res1=new int[(nums2.length-1)/2];
                System.arraycopy(nums2,(nums2.length+1)/2,res1,0,(nums2.length-1)/2);            }
             res2=new int[(nums1.length-1)/2];
                    System.arraycopy(nums1,0,res2,0,(nums1.length-1)/2);
        }else {
            if (nums1.length%2==0){
                 res1=new int[nums1.length/2];
                System.arraycopy(nums1,(nums1.length+1)/2,res1,0,nums1.length/2);
            }else {
                 res1=new int[(nums1.length-1)/2];
                System.arraycopy(nums1,(nums1.length+1)/2,res1,0,(nums1.length-1)/2);            }
             res2=new int[(nums2.length-1)/2];
            System.arraycopy(nums2,0,res2,0,(nums2.length-1)/2);
        }
        for (int i:res1) {
            System.out.println("res1:" + i);
        }
        for(int j:res2) {
            System.out.println("res2:" + j);
        }
        int[] res=new int[res1.length+res2.length];
        if (res1[res1.length-1]>res2[res2.length-1]) {
            System.arraycopy(res2, 0, res, 0, res2.length);
            System.arraycopy(res1, 0, res, res2.length, res1.length);

        } else {
            System.arraycopy(res1, 0, res, 0, res1.length);
            System.arraycopy(res2, 0, res, res1.length, res2.length);
        }
        return res[(res.length-1)/2];


    }

    public static void main(String[] args) {
       int[] arr1 = {1,2,3,4,7};
       int[] arr2 = {3,4,5,6};
        int[] d={ };
        int[] d2={ };
        int re=new FindMedianSortedArrays().findMedianSortedArrays(d,d2);
        System.out.println(re);
    }
}
