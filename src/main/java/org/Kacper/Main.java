package org.Kacper;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        while (true) {
            System.out.print("Enter calculation: ");
            input = sc.nextLine();
            if (input.equals("exit")) break;

            BinaryTree tree = new BinaryTree(input);
            System.out.println(" = " + tree.solve());
        }
    }
}