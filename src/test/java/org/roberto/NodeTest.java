package org.roberto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NodeTest {

    @Test
    void assertExistsWithSingleNode() {
        var initialNode = new Node();
        initialNode.setValue(1);
        Assertions.assertTrue(initialNode.exists(1));
    }

    @Test
    void assertNotExistsWithSingleNode() {
        var initialNode = new Node();
        initialNode.setValue(1);
        Assertions.assertFalse(initialNode.exists(2));
    }

    @Test
    void assertExistsWithFiveNodes() {
        var initialNode = new Node();
        initialNode.setValue(1);
        var secondNode = new Node();
        secondNode.setValue(2);
        var thirdNode = new Node();
        thirdNode.setValue(3);
        var fourthNode = new Node();
        fourthNode.setValue(4);
        var fifthNode = new Node();
        fifthNode.setValue(5);

        secondNode.setLeft(fourthNode);
        secondNode.setRigth(fifthNode);

        initialNode.setLeft(secondNode);
        initialNode.setRigth(thirdNode);

        Assertions.assertTrue(initialNode.exists(4));
        Assertions.assertTrue(initialNode.exists(5));
    }

}