package c45;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class implements the function of loading data from file with arff.
 * Created by Gaochao on 2015/9/29.
 */
public class LoadData {

    /**
     * read the content of the file
     *
     * @param fileName the name of the data
     * @return the object od the arffInatances
     */
    public ArffInstances getArffDataContent(String fileName) {
        ArffInstances arffInstances = new ArffInstances();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String str = bufferedReader.readLine();
            //过滤掉注释的内容
            while (str.trim().length() == 0 || str.toCharArray()[0] == '%') {
                str = bufferedReader.readLine();
            }
            //获取关系名称
            if (str.contains("@relation") || str.contains("@RELATION")) {
                String[] relationList = str.split("\\s+");
                arffInstances.setRelationName(relationList[1]);
                str = bufferedReader.readLine();
            }
            //过滤掉空白行
            while (str.trim().length() == 0) {
                str = bufferedReader.readLine();
            }
            //获取文件的属性列表
            int index = 0;
            while (str.contains("@ATTRIBUTE") || str.contains("@attribute")) {
                String[] attr = str.split("\\s+");
                if (str.contains("REAL") || str.contains("numeric") || str.contains("real")) {
                    arffInstances.getAttPos().add(true);
                } else {
                    arffInstances.getAttPos().add(false);
                }
                arffInstances.getAttributeNameList().add(attr[1].trim());
                str = bufferedReader.readLine();
            }
            while (str.trim().length() == 0 || str.contains("@data") || str.contains("@DATA") || str.toCharArray()[0] == '%') {
                str = bufferedReader.readLine();
            }
            //统计数值型和离散型和个数
            for (int i = 0; i < arffInstances.getAttPos().size(); i++) {
                if (arffInstances.getAttPos().get(i)==true) {
                    ArrayList<Double> numericData = new ArrayList<Double>();
                    arffInstances.getDataContent().add(numericData);
                } else {
                    ArrayList<String> nominalData = new ArrayList<String>();
                    arffInstances.getDataContent().add(nominalData);
                }
            }
            int num = 0;
            while (str!=null&&str.length()!= 0) {
                num++;
                String[] tuple = str.trim().split(",");
                for (int i = 0; i < tuple.length; i++) {
                    if (arffInstances.getAttPos().get(i)==true){
                        double value=Double.valueOf(tuple[i]);
                        arffInstances.getDataContent().get(i).add(value);
                    }else {
                        arffInstances.getDataContent().get(i).add(tuple[i]);
                    }
                }
                str = bufferedReader.readLine();



            }
            arffInstances.setTupleSize(num);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        arffInstances.generateClassLabel();
        return arffInstances;
    }

    public static void main(String[] args) {
        String fileName = "ExerciseCoding/data/contact-lenses.arff";
        ArffInstances arffInstances = new LoadData().getArffDataContent(fileName);
        arffInstances.printData();
        System.out.println(":"+arffInstances.getClassLabel());
    }
}
