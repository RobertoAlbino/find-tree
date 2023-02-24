package org.roberto;

import java.util.Objects;

public class Node {

    private Node left, rigth;
    private Integer value;
    private NodeType type;

    public Node() {
        this.value = null;
        this.left = null;
        this.rigth = null;
        this.type = null;
    }

    private boolean findRecursive(int value) {
        System.out.println(String.format("Looking for %s", value));
        if (Objects.isNull(this)) {
            System.out.println("Null node...");
            return false;
        }
        if (Objects.isNull(this.value)) {
            System.out.println("Null value...");
            return false;
        }
        System.out.println(String.format("Node value %s", this.value));
        System.out.println(String.format("Node type %s", this.type));
        if (this.value == value) {
            System.out.println("Found...");
            return true;
        }
        if (Objects.nonNull(this.getLeft()) && this.getLeft().findRecursive(value)) {
            System.out.println("Found in left...");
            return true;
        }
        if (Objects.nonNull(this.getRigth()) && this.getRigth().findRecursive(value)) {
            System.out.println("Found in rigth...");
            return true;
        }
        System.out.println("Not found...");
        return false;
    }

    public boolean exists(int value) {
        return findRecursive(value);
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        left.setType(NodeType.LEFT);
        this.left = left;
    }

    public Node getRigth() {
        return rigth;
    }

    public void setRigth(Node rigth) {
        rigth.setType(NodeType.RIGTH);
        this.rigth = rigth;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }
}
