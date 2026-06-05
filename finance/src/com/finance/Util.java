package com.finance;

import java.util.Scanner;

/**
 * 工具类：封装所有控制台输入操作，统一管理Scanner，避免重复代码。
 * 所有方法都是静态的，方便在 PortfolioApp 中直接调用。
 */
public class Util {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 读取菜单选择，只接受 '1'~'4'，输入不合法则提示重试。
     */
    public static char readMenuSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1);
            c = str.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4') {
                System.out.print("选择错误，请重新输入：");
            } else {
                break;
            }
        }
        return c;
    }

    /**
     * 读取确认选择（Y/N），不区分大小写。
     */
    public static char readConfirmSelection() {
        char c;
        while (true) {
            String str = readKeyBoard(1).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("选择错误，请重新输入：");
            }
        }
        return c;
    }

    /**
     * 打印提示并读取一行字符串（不允许为空）。
     * @param prompt 提示文字
     * @return 用户输入的字符串
     */
    public static String readString(String prompt) {
        System.out.print(prompt);
        String line;
        while (true) {
            line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.print("输入不能为空，请重新输入：");
            } else {
                break;
            }
        }
        return line;
    }

    /**
     * 打印提示并读取一个整数。输入不合法则提示重试。
     * @param prompt 提示文字
     * @return 用户输入的整数
     */
    public static int readInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("请输入有效的整数：");
            }
        }
    }

    /**
     * 打印提示并读取一个小数。输入不合法则提示重试。
     * @param prompt 提示文字
     * @return 用户输入的小数
     */
    public static double readDouble(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("请输入有效的数字：");
            }
        }
    }

    /**
     * 私有方法：读取指定最大长度的键盘输入。
     */
    private static String readKeyBoard(int limit) {
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            return line;
        }
    }
}
