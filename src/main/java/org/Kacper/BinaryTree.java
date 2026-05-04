package org.Kacper;

/*
 * This class will be used to construct and store the binary tree.
*/

public class BinaryTree {
    private final Node<?> root; // The top of the binary tree.

    public BinaryTree(String equation) {
        root = constructTree(equation);
    }

    // Construct the binary tree from the string.
    private Node<?> constructTree(String equation) {
        // Store the operator to split and the index of where it is.
        Character operator = null;
        Integer index = null;
        for (int i = 0; i < equation.length(); i++) {
            char ch = equation.charAt(i);
            // If the operator is multiplication or division, update only if no other operator is found
            if ((ch == '*' || ch == '/') && operator == null) {
                operator = ch;
                index = i;
            }
            // If the operator is adding or subtracting, update then break.
            if (ch == '+' || ch == '-') {
                operator = ch;
                index = i;
                break;
            }
        }
        // If no operator was found, return a number.
        if (operator == null) {
            Float number = Float.parseFloat(equation);
            return new Node<>(number, "Number");
        } else {
            // Otherwise, split string into 2 and re-run each part again.
            Node<Character> node = new Node<>(operator, "Operator");
            String left = equation.substring(0, index); // Left side of operator.
            String right = equation.substring(index + 1); // Right side of operator.
            node.setLeft(constructTree(left));
            node.setRight(constructTree(right));
            return node;
        }
        // Keep splitting until you're left with the first scenario, where a node storing a number is returned.
    }

    // Solve and return the result.
    public Float solve() {
        try {
            return getEquals(root);
        } catch (Exception e) {
            System.out.println("Unable to solve, exception found: " + e.getCause());
        }
        return null;
    }

    // Merge the tree and get the result.
    private Float getEquals(Node<?> node) {
        if (node.getType().equals("Number")) {
            return (Float) node.getElement(); // Return the number
        }

        char op = (char) node.getElement();
        // Perform operation between the left and right side.
        switch (op) {
            case '+' -> {return getEquals(node.goLeft()) + getEquals(node.goRight());}
            case '-' -> {return getEquals(node.goLeft()) - getEquals(node.goRight());}
            case '*' -> {return getEquals(node.goLeft()) * getEquals(node.goRight());}
            case '/' -> {return getEquals(node.goLeft()) / getEquals(node.goRight());}
        }
        return null;
    }
}