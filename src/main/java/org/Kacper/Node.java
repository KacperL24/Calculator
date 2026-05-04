package org.Kacper;

/*
 * This class will store the number/operator for the equation.
 * It uses element E for numbers and operators (Characters).
*/

public class Node<E> {
    private final E element; // The field which stores the operator/number.
    private Node<?> left; // The left tree node.
    private Node<?> right; // The right tree node.
    private final String type; // The type of data stored.

    public Node(E element, String type) {
        this.element = element;
        left = null;
        right = null;
        // Where null is a leaf.
        this.type = type;
    }

    // Set the children nodes.
    public void setLeft(Node<?> left) {
        this.left = left;
    }
    public void setRight(Node<?> right) {
        this.right = right;
    }

    // Get the element of the node.
    public E getElement() {
        return element;
    }

    // Get the type for this node.
    public String getType() {
        return type;
    }

    // Traverse the Binary tree by going left or right.
    public Node<?> goLeft() {
        return left;
    }

    public Node<?> goRight() {
        return right;
    }
}