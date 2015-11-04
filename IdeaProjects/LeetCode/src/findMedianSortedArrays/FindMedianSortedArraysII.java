package findMedianSortedArrays;

/**
 * Created by Gaochao on 2015/9/12.
 */
public class FindMedianSortedArraysII {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        int ll=l1+l2;
        if (ll%2==0){
            return (findMedianCore(nums1,nums2,0,l1-1,0,l2-1,ll/2)+findMedianCore(nums1,nums2,0,l1-1,0,l2-1,ll/2+1))/2;

        }else
            return findMedianCore(nums1,nums2,0,l1-1,0,l2-1,ll/2+1);

    }
    public double findMedianCore(int[] A,int[] B,int astart,int aend,int bstart,int bend,int k){
        int lenA=aend-astart+1;
        int lenB=bend-bstart+1;
        if (lenA>lenB)
            return findMedianCore(B,A,bstart,bend,astart,aend,k);
        if (lenA<=0)
            return B[bstart+k-1];
        if (k==1)
            return A[astart]>B[bstart]?B[bstart]:A[astart];
        int partA=k/2>lenA?lenA:k/2;
        int partB=k-partA;
        if (A[astart+partA-1]==B[bstart+partB-1]){
            return A[astart+partA-1];
        }else if(A[astart+partA-1]>B[bstart+partB-1]) {
            return findMedianCore(A,B,astart,aend,bstart+partB,bend,k-partB);
        }else {
            return findMedianCore(A,B,astart+partA,aend,bstart,bend,k-partA);
        }
    }


}
