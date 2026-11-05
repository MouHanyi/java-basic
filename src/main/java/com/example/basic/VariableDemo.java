package com.example.basic;

import java.util.Scanner;

public class VariableDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入姓名：");
        String name = scanner.nextLine();

        System.out.print("请输入年龄：");
        int age = scanner.nextInt();

        System.out.print("请输入Java成绩：");
        double score = scanner.nextDouble();

        boolean passed = score >= 60;
        int nextYearAge = age + 1;

        System.out.println();
        System.out.println("姓名：" + name);
        System.out.println("当前年龄：" + age);
        System.out.println("明年年龄：" + nextYearAge);
        System.out.println("Java成绩：" + score);
        System.out.println("是否及格：" + passed);

        scanner.close();

    }
}
