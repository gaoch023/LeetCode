package execise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gaochao on 2015/10/9.
 */

public class AppandDigitToString {

    /**
     * 给一个字符串的后面扩展多个1位数字，形成多个字符串的列表。要求：“4”不能在第三位，“3”与“5”不能相连。
     * @param string 被扩展的字符串。
     * @param digitList 扩展的数字列表，此列表中的每个数字，都试图扩展到字符串后面。
     * @return 扩展子后形成的字符串列表。
     */
    public    static    List<String>    appandDigitToString(String string,List<Integer> digitList){
        List<String> resultList    =    new    ArrayList<String>();

        //digitList已经为空，直接把string加入到结果列表中
        if(digitList.size()==0){
            resultList.add(string);
            return    resultList;
        }

        for(Integer digit: digitList){
            //4不能在第3位
            if(string.length()==2 && digit==4)
                break;
            //3与5不能相连
            if(string.endsWith("3") && digit==5)
                break;
            if(string.endsWith("5") && digit==3)
                break;

            //把数字加到字符串后面，形成新串
            String    newString    =    string+digit;
            //去掉已经加到字符串里面的数字，形成一个新的数字列表
            List<Integer>    newDigitList    =    new ArrayList<Integer>();
            newDigitList.addAll(digitList);
            newDigitList.remove(digit);
            //递归调用
            List<String>    newResultList    =    appandDigitToString(newString,newDigitList);

            //添加新生成的字符串列表，但重复的字符串不加入
            for(String newResult: newResultList){
                if(!resultList.contains(newResult))
                    resultList.add(newResult);
            }
        }
        return    resultList;
    }
    public    static    void    main(String[] args){
        try{
            List<Integer>    digitList    =    Arrays.asList(1,2,2,3,4,5);
            List<String>     resultList    =    appandDigitToString("",digitList);
            System.out.println("共"+resultList.size()+"种组合:");
            for(String result:resultList){
                System.out.println(result);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
