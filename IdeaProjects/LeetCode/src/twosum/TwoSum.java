package twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gaochao on 2015/9/11.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers,int target){
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        if (numbers==null)
            return null;
        for (int i=0;i<numbers.length;i++){
            int x=numbers[i];
            if (map.containsKey(target-x)){
                return new int[]{map.get(target-x)+1,i+1};
            }
            map.put(x,i);
        }
        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        int[] data={1,3,5,3,7,2};
        int [] data2=null;
        int[] index=new TwoSum().twoSum(data2, 12);
        System.out.println(index[0]);
        System.out.println(index[1]);
    }
}
