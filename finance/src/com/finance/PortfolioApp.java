package com.finance;

public class PortfolioApp {
    private static Asset[] portfolio = new Asset[10];
    private static int size = 0;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n========== 个人投资组合管理 ==========");
            System.out.println("1. 添加资产");
            System.out.println("2. 查看全部资产");
            System.out.println("3. 计算总市值与总收益");
            System.out.println("4. 退出");
            char choice = Util.readMenuSelection();

            switch (choice) {
                case '1':
                    addAsset();
                    break;
                case '2':
                    viewAll();
                    break;
                case '3':
                    calculateTotal();
                    break;
                case '4':
                    System.out.println("退出成功！");
                    running = false;
                    break;
                default:
                    System.out.println("无效选择，请重试。");
            }
        }
    }

    /**
     * 添加资产：判断数组是否已满，选择类型，读取信息，创建子类对象。
     */
    private static void addAsset() {
        if (size >= portfolio.length) {
            System.out.println("组合已满（最多" + portfolio.length + "个），无法添加！");
            return;
        }

        String type = Util.readString("请输入资产类型（1.股票  2.基金  3.债券）：");

        switch (type) {
            case "1": {
                String code = Util.readString("请输入股票代码：");
                String name = Util.readString("请输入股票名称：");
                int quantity = Util.readInt("请输入股票数量：");
                double price = Util.readDouble("请输入股票价格：");
                portfolio[size] = new Stock(code, name, price, quantity);
                size++;
                System.out.println("股票已添加！");
                break;
            }
            case "2": {
                String code = Util.readString("请输入基金代码：");
                String name = Util.readString("请输入基金名称：");
                int quantity = Util.readInt("请输入基金数量：");
                double price = Util.readDouble("请输入基金价格：");
                portfolio[size] = new Fund(code, name, price, quantity);
                size++;
                System.out.println("基金已添加！");
                break;
            }
            case "3": {
                String code = Util.readString("请输入债券代码：");
                String name = Util.readString("请输入债券名称：");
                int quantity = Util.readInt("请输入债券数量：");
                double price = Util.readDouble("请输入债券价格：");
                double couponRate = Util.readDouble("请输入债券票面利率（如0.04表示4%）：");
                portfolio[size] = new Bond(code, name, price, quantity, couponRate);
                size++;
                System.out.println("债券已添加！");
                break;
            }
            default:
                System.out.println("无效的资产类型，请重试。");
        }
    }

    /**
     * 查看全部资产：遍历数组，调用每个资产的 getInfo() 和 calculateProfit()。
     */
    private static void viewAll() {
        if (size == 0) {
            System.out.println("暂无资产，请先添加。");
            return;
        }
        System.out.println("\n————— 资产列表（共 " + size + " 个）—————");
        for (int i = 0; i < size; i++) {
            Asset a = portfolio[i];
            System.out.println("[" + (i + 1) + "] " + a.getInfo()
                    + "，收益：" + String.format("%.2f", a.calculateProfit()));
        }
    }

    /**
     * 计算总市值与总收益：遍历数组累加。
     */
    private static void calculateTotal() {
        if (size == 0) {
            System.out.println("暂无资产，请先添加。");
            return;
        }
        double totalMarketValue = 0;
        double totalProfit = 0;
        for (int i = 0; i < size; i++) {
            totalMarketValue += portfolio[i].getMarketValue();
            totalProfit += portfolio[i].calculateProfit();
        }
        System.out.println("\n————— 投资组合汇总 —————");
        System.out.println("总市值：" + String.format("%.2f", totalMarketValue));
        System.out.println("总收益：" + String.format("%.2f", totalProfit));
    }
}
