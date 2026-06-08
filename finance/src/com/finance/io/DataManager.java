package com.finance.io;

import com.finance.model.*;
import com.finance.service.Portfolio;

import java.io.*;

public class DataManager {

    private static final String FILE_PATH = "data/portfolio.txt";

    /**
     * 从文件加载资产。文件不存在就返回空组合。
     */
    public static Portfolio loadPortfolio() {
        Portfolio portfolio = new Portfolio();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            System.out.println("数据文件不存在，将创建新组合。");
            return portfolio;
        }

        BufferedReader reader = null;
        try {
            // 打开文件
            reader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                /*
                 * 解析一行：STOCK|600519|贵州茅台|1680.5|100|MEDIUM
                 * split("\\|") 按竖线切分，得到字符串数组
                 *   parts[0]=类型  parts[1]=代码  parts[2]=名称
                 *   parts[3]=价格  parts[4]=数量  parts[5]=风险等级
                 */
                String[] parts = line.split("\\|");

                AssetType type = AssetType.valueOf(parts[0]);
                String code = parts[1];
                String name = parts[2];
                double price = Double.parseDouble(parts[3]);    // 字符串 → double
                int quantity = Integer.parseInt(parts[4]);      // 字符串 → int
                RiskLevel risk = RiskLevel.valueOf(parts[5]);   // 字符串 → 枚举

                // 根据类型创建对应的子类对象
                if (type == AssetType.STOCK) {
                    portfolio.add(new Stock(code, name, price, quantity, risk));
                } else if (type == AssetType.FUND) {
                    portfolio.add(new Fund(code, name, price, quantity, risk));
                } else if (type == AssetType.BOND) {
                    double couponRate = Double.parseDouble(parts[6]);
                    portfolio.add(new Bond(code, name, price, quantity, couponRate, risk));
                }
            }
            System.out.println("数据加载完成，共 " + portfolio.size() + " 个资产。");

        } catch (IOException e) {
            System.out.println("读取文件失败：" + e.getMessage());
        } catch (Exception e) {
            // 某一行解析出错（格式不对、数字解析失败），跳过继续
            System.out.println("数据格式有误，部分数据可能丢失。");
        } finally {
            // 无论如何都要关闭文件
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // 关文件失败，程序也做不了什么，忽略
                }
            }
        }
        return portfolio;
    }

    /**
     * 保存所有资产到文件。
     */
    public static void savePortfolio(Portfolio portfolio) {
        // 确保 data 目录存在
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File(FILE_PATH)));

            for (Asset asset : portfolio.getAll()) {

                String line = asset.getType().name() + "|"      // STOCK
                        + asset.getCode() + "|"
                        + asset.getName() + "|"
                        + asset.getPrice() + "|"
                        + asset.getQuantity() + "|"
                        + asset.getRiskLevel().name();          // MEDIUM

                if (asset instanceof Bond) {
                    Bond bond = (Bond) asset;
                    line = line + "|" + bond.getCouponRate();
                }

                writer.write(line);
                writer.newLine();
            }
            System.out.println("数据已保存（共 " + portfolio.size() + " 个资产）。");

        } catch (IOException e) {
            System.out.println("保存数据失败：" + e.getMessage());
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // 忽略
                }
            }
        }
    }

    /**
     * 导出单个资产的详细报告。
     * @return 导出文件的完整路径，失败返回 null
     */
    public static String exportReport(Asset asset) {
        File dir = new File("data");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = "data/" + asset.getCode() + "_report.txt";

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(new File(fileName)));

            writer.write("========== 资产报告 ==========");
            writer.newLine();
            writer.write("代码：" + asset.getCode());
            writer.newLine();
            writer.write("名称：" + asset.getName());
            writer.newLine();
            writer.write("类型：" + asset.getType().getDescription());
            writer.newLine();
            writer.write("市值：" + String.format("%.2f", asset.getMarketValue()));
            writer.newLine();
            writer.write("收益：" + String.format("%.2f", asset.calculateProfit()));
            writer.newLine();
            writer.write("风险等级：" + asset.getRiskLevel().getDescription());
            writer.newLine();

            if (asset instanceof Bond) {
                Bond bond = (Bond) asset;
                writer.write("票面利率：" + String.format("%.2f%%", bond.getCouponRate() * 100));
                writer.newLine();
            }

            writer.write("==============================");
            writer.newLine();

        } catch (IOException e) {
            System.out.println("导出失败：" + e.getMessage());
            return null;
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // 忽略
                }
            }
        }
        return new File(fileName).getAbsolutePath();
    }
}
