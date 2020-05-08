package com.company;

import java.util.Scanner;

public class Klavye implements IKlavye {

    public String veriAl() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
