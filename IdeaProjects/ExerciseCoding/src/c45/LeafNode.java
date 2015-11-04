package c45;

import java.util.List;

/**
 * Created by Gaochao on 2015/10/28.
 */
public class LeafNode extends Node {

    String className=null;
    List<Node> childrenNode =null;

    public List<Node> getChildrenNode() {
        return childrenNode;
    }

    public String getClassName() {

        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
