package com.finance;

import com.finance.expection.AssetNotFoundException;
import com.finance.expection.DuplicateAssetException;
import com.finance.io.DataManager;
import com.finance.model.*;
import com.finance.service.Portfolio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PortfolioApp {

    private static Portfolio pf;

    public static void main(String[] args) {

        pf = DataManager.loadPortfolio();

        boolean running = true;
        while (running) {
            System.out.println("\n========== 个人投资组合管理 ==========");
            System.out.println("1. 添加资产");
            System.out.println("2. 查看全部资产（按收益率排序）");
            System.out.println("3. 按名称排序查看");
            System.out.println("4. 按市值排序查看");
            System.out.println("5. 按代码查找资产");
            System.out.println("6. 按代码删除资产");
            System.out.println("7. 导出资产报告");
            System.out.println("8. 计算总市值与总收益");
            System.out.println("9. 退出");
            char choice = Util.readMenuSelection();

            switch (choice) {
                case '1': addAsset();            break;
                case '2': viewByProfit();        break;
                case '3': viewByName();          break;
                case '4': viewByMarketValue();   break;
                case '5': findByCode();          break;
                case '6': removeAsset();         break;
                case '7': exportReport();        break;
                case '8': showTotal();           break;
                case '9':

                    DataManager.savePortfolio(pf);
                    System.out.println("退出成功！");
                    running = false;
                    break;
            }
        }
    }

    // ==================== 添加资产 ====================

    private static void addAsset() {
        String type = Util.readString("请输入资产类型（1.股票  2.基金  3.债券）：");

        try {
            switch (type) {
                case "1": {
                    String code = Util.readString("请输入股票代码：");
                    String name = Util.readString("请输入股票名称：");
                    int quantity = Util.readInt("请输入股票数量：");
                    double price = Util.readDouble("请输入股票价格：");
                    RiskLevel level = readRiskLevel();
                    pf.add(new Stock(code, name, price, quantity, level));
                    System.out.println("股票已添加！");
                    break;
                }
                case "2": {
                    String code = Util.readString("请输入基金代码：");
                    String name = Util.readString("请输入基金名称：");
                    int quantity = Util.readInt("请输入基金数量：");
                    double price = Util.readDouble("请输入基金价格：");
                    RiskLevel level = readRiskLevel();
                    pf.add(new Fund(code, name, price, quantity, level));
                    System.out.println("基金已添加！");
                    break;
                }
                case "3": {
                    String code = Util.readString("请输入债券代码：");
                    String name = Util.readString("请输入债券名称：");
                    int quantity = Util.readInt("请输入债券数量：");
                    double price = Util.readDouble("请输入债券价格：");
                    double couponRate = Util.readDouble("请输入债券票面利率（如0.04表示4%）：");
                    RiskLevel level = readRiskLevel();
                    pf.add(new Bond(code, name, price, quantity, couponRate, level));
                    System.out.println("债券已添加！");
                    break;
                }
                default:
                    System.out.println("无效的资产类型，请重试。");
            }
        } catch (DuplicateAssetException e) {
            System.out.println("添加失败：" + e.getMessage());
        }
    }

    // ==================== 三种排序查看 ====================

    private static void viewByProfit() {
        if (pf.size() == 0) {
            System.out.println("暂无资产，请先添加。");
            return;
        }
        ArrayList<Asset> list = pf.getAll();
        list.sort(new Comparator<Asset>() {
            @Override
            public int compare(Asset o1, Asset o2) {
                return Double.compare(o2.calculateProfit(), o1.calculateProfit());
            }
        });
        printAssetList(list, "按收益率排序");
    }

    private static void viewByName() {
        if (pf.size() == 0) {
            System.out.println("暂无资产，请先添加。");
            return;
        }
        ArrayList<Asset> list = pf.getAll();
        Collections.sort(list, new Comparator<Asset>() {
            @Override
            public int compare(Asset o1, Asset o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        printAssetList(list, "按名称排序");
    }

    private static void viewByMarketValue() {
        if (pf.size() == 0) {
            System.out.println("暂无资产，请先添加。");
            return;
        }
        ArrayList<Asset> list = pf.getAll();
        Collections.sort(list, new Comparator<Asset>() {
            @Override
            public int compare(Asset o1, Asset o2) {
                return Double.compare(o2.getMarketValue(), o1.getMarketValue());
            }
        });
        printAssetList(list, "按市值排序");
    }

    /** 遍历并打印资产列表（三个查看方法共用） */
    private static void printAssetList(ArrayList<Asset> list, String title) {
        System.out.println("\n————— 资产列表（" + title + "）—————");
        for (Asset asset : list) {
            System.out.println(asset.getInfo() + "，收益：" + String.format("%.2f", asset.calculateProfit()));
        }
    }

    // ==================== 查找 & 删除 & 导出 ====================

    private static void findByCode() {
        String code = Util.readString("请输入资产代码：");
        try {
            Asset a = pf.findByCode(code);
            System.out.println(a.getInfo() + "，收益：" + String.format("%.2f", a.calculateProfit()));
        } catch (AssetNotFoundException e) {
            System.out.println("查找失败：" + e.getMessage());
        }
    }

    private static void removeAsset() {
        String code = Util.readString("请输入资产代码：");
        try {
            pf.remove(code);
            System.out.println("删除成功！");
        } catch (AssetNotFoundException e) {
            System.out.println("删除失败：" + e.getMessage());
        }
    }

    private static void exportReport() {
        String code = Util.readString("请输入要导出的资产代码：");
        try {
            Asset a = pf.findByCode(code);
            String path = DataManager.exportReport(a);
            if (path != null) {
                System.out.println("报告已导出到：" + path);
            }
        } catch (AssetNotFoundException e) {
            System.out.println("导出失败：" + e.getMessage());
        }
    }

    // ==================== 统计 & 工具 ====================

    private static void showTotal() {
        System.out.println("\n————— 投资组合汇总 —————");
        System.out.println("总市值：" + String.format("%.2f", pf.getTotalMarketValue()));
        System.out.println("总收益：" + String.format("%.2f", pf.getTotalProfit()));
        System.out.println("资产数量：" + pf.size());
    }

    private static RiskLevel readRiskLevel() {
        String input = Util.readString("请选择风险等级（1.低风险  2.中风险  3.高风险）：");
        switch (input) {
            case "1": return RiskLevel.LOW;
            case "2": return RiskLevel.MEDIUM;
            case "3": return RiskLevel.HIGH;
            default:
                System.out.println("无效选择，默认设为中风险");
                return RiskLevel.MEDIUM;
        }
    }
}
