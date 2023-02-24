package org.roberto;

public class Main {
    public static void main(String[] args) {
        Node firstNode = new Node();
        Node secondNode = new Node();
        Node thirdNode = new Node();
        Node fourNode = new Node();
        secondNode.setValue(8);
        thirdNode.setValue(10);
        fourNode.setValue(40);
        firstNode.setLeft(secondNode);
        firstNode.setRigth(thirdNode);
        secondNode.setLeft(fourNode);
        System.out.println(firstNode.exists(41));
    }
}