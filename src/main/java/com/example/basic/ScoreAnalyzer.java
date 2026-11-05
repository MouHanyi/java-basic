package com.example.basic;

import java.util.Scanner;

public class ScoreAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentCount = readStudentCount(scanner);
        int[] scores = readScores(scanner, studentCount);

        double average = calculateAverage(scores);
        int maximum = findMaximum(scores);
        int minimum = findMinimum(scores);
        int passedCount = countPassed(scores);
        int failedCount = scores.length - passedCount;

        System.out.printf("%n平均分：%.2f%n", average);
        System.out.println("最高分：" + maximum);
        System.out.println("最低分：" + minimum);
        System.out.println("及格人数：" + passedCount);
        System.out.println("不及格人数：" + failedCount);

        printGradeDistribution(scores);

        sortDescending(scores);
        printScores(scores);

        scanner.close();
    }

    /**
     * 读取学生人数。
     * 学生人数必须是大于0的整数。
     */
    static int readStudentCount(Scanner scanner) {
        while (true) {
            System.out.print("请输入学生人数：");

            if (!scanner.hasNextInt()) {
                System.out.println("输入错误，请输入整数。");
                scanner.next();
                continue;
            }

            int studentCount = scanner.nextInt();

            if (studentCount <= 0) {
                System.out.println("学生人数必须大于0。");
                continue;
            }

            return studentCount;
        }
    }

    /**
     * 读取所有学生的成绩。
     * 每个成绩必须是0～100之间的整数。
     */
    static int[] readScores(Scanner scanner, int studentCount) {
        int[] scores = new int[studentCount];

        for (int i = 0; i < studentCount; i++) {
            while (true) {
                System.out.print(
                        "请输入第" + (i + 1) + "个学生的成绩："
                );

                if (!scanner.hasNextInt()) {
                    System.out.println("输入错误，成绩必须是整数。");
                    scanner.next();
                    continue;
                }

                int score = scanner.nextInt();

                if (score < 0 || score > 100) {
                    System.out.println("成绩必须在0～100之间。");
                    continue;
                }

                scores[i] = score;
                break;
            }
        }

        return scores;
    }

    /**
     * 计算平均分。
     */
    static double calculateAverage(int[] scores) {
        long sum = 0;

        for (int score : scores) {
            sum += score;
        }

        return (double) sum / scores.length;
    }

    /**
     * 查找最高分。
     */
    static int findMaximum(int[] scores) {
        int maximum = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maximum) {
                maximum = scores[i];
            }
        }

        return maximum;
    }

    /**
     * 查找最低分。
     */
    static int findMinimum(int[] scores) {
        int minimum = scores[0];

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < minimum) {
                minimum = scores[i];
            }
        }

        return minimum;
    }

    /**
     * 统计及格人数。
     */
    static int countPassed(int[] scores) {
        int passedCount = 0;

        for (int score : scores) {
            if (score >= 60) {
                passedCount++;
            }
        }

        return passedCount;
    }

    /**
     * 统计并输出各个等级的人数。
     */
    static void printGradeDistribution(int[] scores) {
        int gradeACount = 0;
        int gradeBCount = 0;
        int gradeCCount = 0;
        int gradeDCount = 0;

        for (int score : scores) {
            if (score >= 90) {
                gradeACount++;
            } else if (score >= 80) {
                gradeBCount++;
            } else if (score >= 60) {
                gradeCCount++;
            } else {
                gradeDCount++;
            }
        }

        System.out.println();
        System.out.println("成绩等级分布：");
        System.out.println("A（90～100）：" + gradeACount + "人");
        System.out.println("B（80～89）：" + gradeBCount + "人");
        System.out.println("C（60～79）：" + gradeCCount + "人");
        System.out.println("D（0～59）：" + gradeDCount + "人");
    }

    /**
     * 使用冒泡排序，将成绩从高到低排列。
     */
    static void sortDescending(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < scores.length - 1 - i; j++) {
                if (scores[j] < scores[j + 1]) {
                    int temporary = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temporary;

                    swapped = true;
                }
            }

            // 本轮没有发生交换，说明数组已经有序
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 输出排序后的成绩。
     */
    static void printScores(int[] scores) {
        System.out.println();
        System.out.print("从高到低的成绩：");

        for (int i = 0; i < scores.length; i++) {
            if (i > 0) {
                System.out.print("、");
            }

            System.out.print(scores[i]);
        }

        System.out.println();
    }
}