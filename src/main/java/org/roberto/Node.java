package org.roberto;

import java.util.Objects;

public class Node {

    private Node left, rigth;
    private int value;

    private boolean findRecursive(int value) {
        System.out.println("Buscando");
        if (Objects.isNull(this)) {
            return false;
        }
        if (this.value == value) {
            return true;
        }
        if (Objects.nonNull(this.getLeft()) && this.getLeft().findRecursive(value)) {
            return true;
        }
        if (Objects.nonNull(this.getRigth()) && this.getRigth().findRecursive(value)) {
            return true;
        }
        return false;
    }

    public boolean exists(int value) {
        if (Objects.isNull(this)) {
            return false;
        }
        return findRecursive(value);
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRigth() {
        return rigth;
    }

    public void setRigth(Node rigth) {
        this.rigth = rigth;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
