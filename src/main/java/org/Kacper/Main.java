package org.Kacper;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static String eq = "";
    private static JLabel label;

    public static void addCharacter(char c) {
        eq += c;
        label.setText(" " + eq);
    }

    public static void clear() {
        eq = "";
        label.setText(" " + eq);
    }

    public static void compute() {
        // If nothing is written, return.
        if (eq.equals("")) return;

        eq = "0" + eq; // Adding a zero before so it works with negative numbers.
        BinaryTree tree = new BinaryTree(eq);
        Float result = tree.solve();

        label.setText(" " + result.toString());
        eq = result.toString();
    }

    public static void setupGui(Container pane) {
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;
        c.ipadx = 40;

        // Label for displaying the text of what to compute.
        label = new JLabel(" " + eq); // Label
        c.gridx = 0;
        c.gridwidth = 4;
        pane.add(label, c);

        // Settings for buttons.
        JButton button;
        c.gridwidth = 1;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;

        button = new JButton("C"); //CLEAR BUTTON
        c.gridx = 3;
        c.gridy = 1;
        button.addActionListener(e -> {clear();});
        pane.add(button, c);

        // Buttons formatted.
        char[] b = {
          '1', '2', '3', '+',
          '4', '5', '6', '-',
          '7', '8', '9', '*',
          '0', '.', '/'
        };

        // Loop for each button and put in correspondingly.
        int currentX = 0;
        int currentY = 2;
        for (int i = 0; i < b.length; i++) {
            button = new JButton(String.valueOf(b[i]));
            c.gridx = currentX;
            c.gridy = currentY;
            char symbol = b[i];
            button.addActionListener(e -> {addCharacter(symbol);});
            pane.add(button, c);

            // Change level when max x is reached.
            currentX += 1;
            if (currentX == 4) {
                currentX = 0;
                currentY += 1;
            }
        }

        // Button to get the computation.
        button = new JButton("=");
        c.gridx = 3;
        c.gridy = 5;
        button.addActionListener(e -> {compute();});
        pane.add(button, c);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setupGui(frame.getContentPane());

        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}