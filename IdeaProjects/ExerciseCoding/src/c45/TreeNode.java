package c45;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gaochao on 2015/10/26.
 */
public class TreeNode extends Node{
    String attributeName =null;//the attribute represented by this Node
    List<String> dicideCondition =new ArrayList<String>(); //the Values of the divide Condition
    List<Node> childrenNode =new ArrayList<Node>();

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public void setChildrenNode(List<Node> childrenNode) {
        this.childrenNode = childrenNode;
    }

    public void setDicideCondition(List<String> dicideCondition) {
        this.dicideCondition = dicideCondition;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public List<Node> getChildrenNode() {
        return childrenNode;
    }

    public List<String> getDicideCondition() {
        return dicideCondition;
    }
}
