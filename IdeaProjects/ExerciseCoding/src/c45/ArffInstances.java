package c45;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaochao on 2015/9/30.
 */
public class ArffInstances {
    private String relationName=null;
    private List<List> dataContent=new ArrayList<List>();
    private int tupleSize=0;
    private ArrayList<String> attributeNameList = new ArrayList<String>();
    private List<Boolean> attPos=new ArrayList<Boolean>();//记录属性是数值型还是离散型
    private List<String> classLabel= new ArrayList<String>();



    public List<String> getClassLabel() {
        generateClassLabel();
        return classLabel;
    }

    public void setClassLabel(List<String> classLabel) {
        this.classLabel = classLabel;
    }

    public List<Boolean> getAttPos() {
        return attPos;
    }

    public List<List> getDataContent() {
        return dataContent;
    }

    public String getRelationName() {
        return relationName;
    }

    public int getTupleSize() {
        tupleSize = dataContent.get(0).size();
        return tupleSize;
    }

    public ArrayList<String> getAttributeNameList() {
        return attributeNameList;
    }

    public void setAttPos(List<Boolean> attPos) {
        this.attPos = attPos;
    }

    public void setAttributeNameList(ArrayList<String> attributeNameList) {
        this.attributeNameList = attributeNameList;
    }

    public void setDataContent(List<List> dataContent) {
        this.dataContent = dataContent;
    }

    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }

    public void setTupleSize(int tupleSize) {
        this.tupleSize = tupleSize;
    }

    //print the content of the data
    public void printData() {
        for (int m=0;m<attributeNameList.size();m++) {
            System.out.print(attributeNameList.get(m) + ",");
        }
        System.out.println();
        for (int j = 0; j < dataContent.get(0).size(); j++) {

            for (int i = 0; i < dataContent.size(); i++) {
                System.out.print(dataContent.get(i).get(j) + ",");
            }
            System.out.println();
        }
    }

    public void generateClassLabel() {
        if (dataContent.size()>=2) {
            this.classLabel = dataContent.get(dataContent.size() - 1);
        }else {
            this.classLabel=null;
        }
    }


}
