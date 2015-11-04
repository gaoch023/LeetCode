package c45;

import java.math.BigDecimal;
import java.util.*;

/**
 * implements the algorithm of C4.5
 * Created by Gaochao on 2015/9/29.
 */
public class MainProcess {


    public Node c45_algorithm(ArffInstances arffInstances) {
        //整个数据集的期望信息Info(D)
        List<String> classLabel = arffInstances.getClassLabel();
        //判断是否终止决策
        //所以实例属于一个类别
        boolean isSame = true;
        for (int incla = 0; incla < classLabel.size(); incla++) {
            if (classLabel.get(0).equals(classLabel.get(incla))) {
                continue;
            } else {
                isSame = false;
            }
        }
        if (isSame) {
            LeafNode leafNode = new LeafNode();
            leafNode.setClassName(classLabel.get(0));
//            System.out.println("enennend");
            return leafNode;
        }
        //


        // System.out.println("classlabel.size:"+classLabel.size());
        double DataInfo = generateInfo(classLabel);

//        System.out.println(arffInstances.getAttPos());

        //计算每个属性的期望信息Info(Dj)
        List<Double> gainRatio = new ArrayList<Double>();
        List<List> divideCondition = new ArrayList<List>();
        for (int i = 0; i < arffInstances.getDataContent().size() - 1; i++) {
//            System.out.println(arffInstances.getDataContent().get(i));
            //如果是离散型属性
            if (arffInstances.getAttPos().get(i) == false) {
                List<String> arrtributeData = new ArrayList<String>(arffInstances.getDataContent().get(i));

                Map<String, List<String>> partAttriCount = new HashMap<String, List<String>>();

                for (int indexofAttribute = 0; indexofAttribute < arrtributeData.size(); indexofAttribute++) {

                    if (partAttriCount.containsKey(arrtributeData.get(indexofAttribute))) {
                        partAttriCount.get(arrtributeData.get(indexofAttribute)).add(classLabel.get(indexofAttribute));
                    } else {
                        List<String> valueStr = new ArrayList<String>();
                        String label = classLabel.get(indexofAttribute);
                        valueStr.add(label);
                        partAttriCount.put(arrtributeData.get(indexofAttribute), valueStr);
                    }

                }

                List<String> strDivideCondition = new ArrayList<String>(partAttriCount.keySet());
                divideCondition.add(strDivideCondition);

                List<List<String>> valueList = new ArrayList<List<String>>(partAttriCount.values());
                double partDataInfo = 0;
                double splitInfodata = 0;
                for (List<String> s : valueList) {
                    splitInfodata += ((((double) s.size()) / classLabel.size()) * (Math.log(((double) s.size()) / classLabel.size()) / Math.log(2)));
                    partDataInfo += (((double) s.size()) / classLabel.size() * generateInfo(s));
                }

                double gainData = DataInfo - partDataInfo;
                splitInfodata = splitInfodata * -1;
                double gainRate = gainData / splitInfodata;
                //System.out.println("partDataInfo:"+partDataInfo);
                //System.out.println("gainData:"+gainData);
                //System.out.println("splitInfodata:"+splitInfodata);
                BigDecimal b = new BigDecimal(gainRate);
                double d = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
                gainRatio.add(d);


            } else {
                /**
                 * 在C4.5中，对连续属性的处理如下：

                 1.       对属性的取值进行排序
                 2.       两个属性取值之间的中点作为可能的分裂点，将数据集分成两部分，计算每个可能的分裂点的信息增益（InforGain）
                 3.       对每个分裂点的信息增益(InforGain)就行修正：减去log2(N-1)/|D|   其中N为可能的分裂点个数，|D|是数据集大小
                 4.       选择修正后信息增益(InforGain)最大的，分裂点作为该属性的最佳分裂点
                 5.       计算最佳分裂点的信息增益率（Gain Ratio）作为属性的Gain Ratio
                 6.       选择Gain Ratio最大的属性作为分裂属性
                 */
                //如果是连续型属性时计算增益率
                List<Double> attributeData = arffInstances.getDataContent().get(i);
//                System.out.println("attributeData"+attributeData);
                List<Double> computeBoundarydata = new ArrayList<Double>(arffInstances.getDataContent().get(i));
                Collections.sort(computeBoundarydata); //对属性的取值进行排序
//                System.out.println("attrbuteData"+attributeData);
                List<Double> tempGainData = new ArrayList<Double>();
                List<Double> tempValueList = new ArrayList<Double>();
                List<Double> tempSplitdata = new ArrayList<Double>();


                for (int indexofBoundarydata = 0; indexofBoundarydata < computeBoundarydata.size() - 1; indexofBoundarydata++) {
                    double v1 = computeBoundarydata.get(indexofBoundarydata);
                    double v2 = computeBoundarydata.get(indexofBoundarydata + 1);
                    double tempValue = (v1 + v2) / 2.0;
//                    System.out.println(tempValue);
                    tempValueList.add(tempValue);
                    List<List<String>> labelCountList = new ArrayList<List<String>>();

                    labelCountList.add(new ArrayList<String>());
                    labelCountList.add(new ArrayList<String>());
                    for (int indexofAttributeData = 0; indexofAttributeData < attributeData.size(); indexofAttributeData++) {
                        if (attributeData.get(indexofAttributeData) <= tempValue) {
                            labelCountList.get(0).add(classLabel.get(indexofAttributeData));
                        } else {
                            labelCountList.get(1).add(classLabel.get(indexofAttributeData));
                        }
                    }

                    double partDataInfo = 0;
                    double splitInfodata = 0;
                    for (int indexoflabelCount = 0; indexoflabelCount < labelCountList.size(); indexoflabelCount++) {
                        List<String> s = labelCountList.get(indexoflabelCount);
                        double tempSplitRes = ((((double) s.size()) / (double) classLabel.size()) * (Math.log(((double) s.size()) / (double) classLabel.size()) / Math.log(2)));

                        splitInfodata += tempSplitRes;
                        double countRate = ((double) s.size()) / (double) classLabel.size();
                        double tempPartRes = (countRate * generateInfo(s));

                        partDataInfo += tempPartRes;
                    }
//                    System.out.println(DataInfo);
                    double corrValue = 0.0;
                    if (computeBoundarydata.size() >= 3) {
                        corrValue = (Math.log((double) (computeBoundarydata.size() - 2)) / Math.log(2)) / (double) classLabel.size();
                    }
//                    double gainData = DataInfo - partDataInfo;
                    double gainData = DataInfo - partDataInfo - corrValue;//减去log2(N-1)/|D|   其中N为可能的分裂点个数，|D|是数据集大小
                    splitInfodata = splitInfodata * -1;


                    BigDecimal biggainData = new BigDecimal(gainData);
                    double resgainData = biggainData.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
                    tempGainData.add(gainData);
                    BigDecimal bigsplitInfodata = new BigDecimal(splitInfodata);
                    double ressplitInfodata = bigsplitInfodata.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
//                    System.out.println("信息增益:"+partDataInfo);
                    tempSplitdata.add(splitInfodata);
//                    double gainRate = gainData / splitInfodata;
//                    System.out.println("DataInfo:"+DataInfo);
//                    System.out.println("partDataInfo:"+partDataInfo);
//                    System.out.println("gainData:"+gainData);
//                    System.out.println("splitInfodata:"+splitInfodata);
//                    System.out.println("gainRate:"+gainRate);
//                    System.out.println("\n");
//                    BigDecimal b = new BigDecimal();
//                    double d = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();


                }

                double GainData = -1000000;
                double divideValue = -1;
                int indexofMaxGainData = -1;
//                System.out.println(tempGainData);
                for (int t = 0; t < tempGainData.size(); t++) {
                    if (tempGainData.get(t) > GainData) {
                        GainData = tempGainData.get(t);
                        divideValue = tempValueList.get(t);
                        indexofMaxGainData = t;
                    }
                }
                double GainRate = 0;
//                double corrValue=(Math.log((tempValueList.size()-1))/Math.log(2))/classLabel.size();
//                BigDecimal b = new BigDecimal(corrValue);
//                    double d = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
                GainRate = (GainData) / tempSplitdata.get(indexofMaxGainData);

                gainRatio.add(GainRate);
                List<Double> tempDivideValue = new ArrayList<Double>();
                tempDivideValue.add(divideValue);
                divideCondition.add(tempDivideValue);

//                System.out.println(tempValueList);
//                System.out.println(tempGainrate);
            }

        }


//        System.out.println("各个属性的信息增益率为：" + gainRatio);

        //选择最大信息增益率的属性，并进行划分
        int indexofMaxGainRate = -1;
        double tempGainRate = Double.MIN_VALUE;
        for (int indexofGainRatio = 0; indexofGainRatio < gainRatio.size(); indexofGainRatio++) {
            if (gainRatio.get(indexofGainRatio) > tempGainRate) {
                tempGainRate = gainRatio.get(indexofGainRatio);
                indexofMaxGainRate = indexofGainRatio;
            }
        }
        TreeNode resNode = new TreeNode();
//        System.out.println(indexofMaxGainRate);
//        System.out.println("划分属性为：" + arffInstances.getAttributeNameList().get(indexofMaxGainRate));
//        System.out.println("划分属性的取值为：" + divideCondition.get(indexofMaxGainRate));
        resNode.setAttributeName(arffInstances.getAttributeNameList().get(indexofMaxGainRate));
        resNode.setDicideCondition(divideCondition.get(indexofMaxGainRate));


        //根据划分属性对数据进行切割
        List<ArffInstances> arffData = new ArrayList<ArffInstances>();
        List featureAttr = null;
        if (resNode.getDicideCondition().size() == 1) {
            featureAttr = new ArrayList<Double>(arffInstances.getDataContent().get(indexofMaxGainRate));
        } else {
            featureAttr = new ArrayList<String>(arffInstances.getDataContent().get(indexofMaxGainRate));
        }


        if (divideCondition.get(indexofMaxGainRate).size() == 1) {
            for (int indexCondition = 0; indexCondition < 2; indexCondition++) {
                ArffInstances childArffInstances = new ArffInstances();

                childArffInstances.setRelationName(arffInstances.getRelationName());
//            System.out.println("Type:"+arffInstances.getAttPos());
                List<Boolean> childAttPos = new ArrayList<Boolean>(arffInstances.getAttPos());
                ArrayList<String> childAttrname = new ArrayList<String>(arffInstances.getAttributeNameList());
                childAttrname.remove(indexofMaxGainRate);
                childAttPos.remove(indexofMaxGainRate);
                childArffInstances.setAttPos(childAttPos);
                childArffInstances.setAttributeNameList(childAttrname);


                for (int indexPos = 0; indexPos < arffInstances.getAttPos().size(); indexPos++) {
                    if (indexPos == indexofMaxGainRate) {
                        continue;
                    } else {
                        if (arffInstances.getAttPos().get(indexPos) == true) {
                            childArffInstances.getDataContent().add(new ArrayList<Double>());
                        } else {
                            childArffInstances.getDataContent().add(new ArrayList<String>());
                        }
                    }
                }
                arffData.add(childArffInstances);
            }
        } else {
            for (int indexCondition = 0; indexCondition < divideCondition.get(indexofMaxGainRate).size(); indexCondition++) {
                ArffInstances childArffInstances = new ArffInstances();

                childArffInstances.setRelationName(arffInstances.getRelationName());
//            System.out.println("Type:"+arffInstances.getAttPos());
                List<Boolean> childAttPos = new ArrayList<Boolean>(arffInstances.getAttPos());
                ArrayList<String> childAttrname = new ArrayList<String>(arffInstances.getAttributeNameList());
                childAttrname.remove(indexofMaxGainRate);
                childAttPos.remove(indexofMaxGainRate);
                childArffInstances.setAttPos(childAttPos);
                childArffInstances.setAttributeNameList(childAttrname);


                for (int indexPos = 0; indexPos < arffInstances.getAttPos().size(); indexPos++) {
                    if (indexPos == indexofMaxGainRate) {
                        continue;
                    } else {
                        if (arffInstances.getAttPos().get(indexPos) == true) {
                            childArffInstances.getDataContent().add(new ArrayList<Double>());
                        } else {
                            childArffInstances.getDataContent().add(new ArrayList<String>());
                        }
                    }
                }
                arffData.add(childArffInstances);
            }
        }
//        System.out.println("child size:"+arffData.size());
        //对存储数据的列表进行初始


//        System.out.println(childArffInstances.getAttPos());
//        System.out.println(childArffInstances.getDataContent().size());

        // 划分数据
        //离散型
        List fea = divideCondition.get(indexofMaxGainRate);
        if (fea.size() == 1) {
            for (int indexArff = 0; indexArff < featureAttr.size(); indexArff++) {
                if ((Double) featureAttr.get(indexArff) <= (Double) fea.get(0)) {
                    int tempindex = 0;
                    for (int indexCon = 0; indexCon < arffInstances.getDataContent().size(); indexCon++) {
                        if (indexCon == indexofMaxGainRate) {
                            continue;
                        } else {
                            arffData.get(0).getDataContent().get(tempindex).add(arffInstances.getDataContent().get(indexCon).get(indexArff));
                            tempindex++;
                        }
                    }

                } else {
                    int tempindex = 0;
                    for (int indexCon = 0; indexCon < arffInstances.getDataContent().size(); indexCon++) {
                        if (indexCon == indexofMaxGainRate) {
                            continue;
                        } else {
                            arffData.get(1).getDataContent().get(tempindex).add(arffInstances.getDataContent().get(indexCon).get(indexArff));
                            tempindex++;
                        }
                    }
                }
            }
        } else {

            for (int indexArff = 0; indexArff < featureAttr.size(); indexArff++) {
                int tempindex = 0;
                for (int indexCon = 0; indexCon < arffInstances.getDataContent().size(); indexCon++) {
                    if (indexCon == indexofMaxGainRate) {
                        continue;
                    } else {
                        arffData.get(fea.indexOf(featureAttr.get(indexArff))).getDataContent().get(tempindex).add(arffInstances.getDataContent().get(indexCon).get(indexArff));
                        tempindex++;
                    }
                }

            }
        }

        //输出划分后的数据
//        System.out.println("print the data of the child");
//        arffData.get(1).getDataContent().get(1).set(3,200);
        for (int indexChild = 0; indexChild < arffData.size(); indexChild++) {


//            arffData.get(indexChild).printData();
            Node child = c45_algorithm(arffData.get(indexChild));
            resNode.getChildrenNode().add(child);
//            System.out.println(arffData.get(indexChild).getAttPos());
//            System.out.println(arffData.get(indexChild).getAttributeNameList());
//            System.out.println(arffData.get(indexChild).getClassLabel());
//            System.out.println(arffData.get(indexChild).getTupleSize());


//            System.out.println(arffData.get(indexChild).getDataContent().get(indexChild).size());
//            System.out.println(arffData.size());
//            System.out.println(arffData.get(indexChild).getRelationName());
//            System.out.println(arffData.get(indexChild).getAttributeNameList());
//            System.out.println(arffData.get(indexChild).getAttPos());
        }

        return resNode;

    }

    public double generateInfo(List<String> classLabel) {
        Map<String, Double> labelCount = new HashMap<String, Double>();


        for (int j = 0; j < classLabel.size(); j++) {
            if (labelCount.containsKey(classLabel.get(j))) {
                labelCount.put(classLabel.get(j), labelCount.get(classLabel.get(j)) + 1);

            } else {
                labelCount.put(classLabel.get(j), 1.0);
            }
        }
//        for (Map.Entry<String,Double> t:labelCount.entrySet()){
//            System.out.println("labelcount:"+t.getKey()+" "+t.getValue());
//
//        }
//         System.out.println("labelcountsize:"+labelCount.size());

        double InfoAllData = 0;
        ArrayList<Double> values = new ArrayList<Double>(labelCount.values());
        for (int indexOfValues = 0; indexOfValues < values.size(); indexOfValues++) {
            InfoAllData += (values.get(indexOfValues) / (double) classLabel.size()) * (Math.log(values.get(indexOfValues) / (double) classLabel.size()) / Math.log(2));

        }
        return InfoAllData * (-1);
    }

    public static void main(String[] args) {
        String fileName = "ExerciseCoding/data/playgame.arff"; //income  weather contact-lenses  playgame
        ArffInstances arffInstances = new LoadData().getArffDataContent(fileName);
        Node root = new MainProcess().c45_algorithm(arffInstances);
        System.out.println("输出决策树：");
        new MainProcess().print(root, "");


    }

    public void print(Node node, String nullCount) {

        String newnull = nullCount;
        if (node instanceof TreeNode) {
            TreeNode trn = (TreeNode) node;
//            System.out.println(newnull+trn.getAttributeName()+"->");
//            System.out.println(111111);
            for (int indchildNode = 0; indchildNode < trn.getChildrenNode().size(); indchildNode++) {
                if (trn.getDicideCondition().size() == 1) {
                    if (indchildNode == 0) {
                        System.out.print("\n" + newnull + trn.getAttributeName() + "<=" + trn.getDicideCondition());
                    } else {
                        System.out.print("\n" + newnull + trn.getAttributeName() + ">" + trn.getDicideCondition());

                    }
                } else {

                    System.out.print("\n" + newnull + trn.getAttributeName() + "=" + trn.getDicideCondition().get(indchildNode).toString());
                }
                print(trn.getChildrenNode().get(indchildNode), newnull + " \t");
            }
        } else {
            LeafNode lfn = (LeafNode) node;
//            newnull= newnull+"\t ";
            System.out.print(":" + lfn.getClassName());
        }
    }


}
