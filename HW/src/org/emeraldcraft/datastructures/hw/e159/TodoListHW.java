package org.emeraldcraft.datastructures.hw.e159;

import java.util.Scanner;

public class TodoListHW {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TodoList list = new TodoList();
        while (true) {
            System.out.print("Enter in a command: ");
            String input = in.nextLine();
            if (input.startsWith("add")) {
                input = input.substring(4);
                int priority = Integer.parseInt(input.substring(0, 1));
                String description = input.substring(2);
                list.addTask(new Task(priority, description));
                System.out.println("Added task!");
            } else if (input.startsWith("next")) {
                System.out.println("Your next task is: " + list.nextTask());
            } else if (input.startsWith("quit"))
                break;
            else
                System.out.println("invalid input");
        } 
    }
}
