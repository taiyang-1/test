package com.finance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PortfolioApp {
    private  static Portfolio pf = new Portfolio();
    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n========== 个人投资组合管理 ==========");
            System.out.println("1. 添加资产");
            System.out.println("2. 查看全部资产(按收益率排序)");
            System.out.println("3. 按名称排序查看");
            System.out.println("4. 按市值排序查看");
            System.out.println("5. 按代码查找资产");
            System.out.println("6. 按代码删除资产");
            System.out.println("7. 计算总市值与总收益");
            System.out.println("8. 退出");
            char choice = Util.readMenuSelection();
            switch (choice) {
                case '1':
                    addAsset();
                    break;
                case '2':
                    viewByProfit(pf);
                    break;
                case '3':
                    viewByName(pf);
                    break;
                case '4':
                    viewByMarketValue(pf);
                    break;
                case '5':
                    findByCode(pf);
                    break;
                case '6':
                    remove(pf);
                    break;
                case '7':
                    showTotal(pf);
                    break;
                case '8':
                    running = false;
                    break;
                default:
                    System.out.println("无效的选择，请重试。");
            }
                }
        }


    /**
     * 添加资产：选择类型，读取信息，创建子类对象。
     */
    private static void addAsset() {
        String type = Util.readString("请输入资产类型（1.股票  2.基金  3.债券）：");

        switch (type) {
            case "1": {
                String code = Util.readString("请输入股票代码：");
                String name = Util.readString("请输入股票名称：");
                int quantity = Util.readInt("请输入股票数量：");
                double price = Util.readDouble("请输入股票价格：");
                RiskLevel level = readRiskLevel();
                pf.add(new Stock(code, name, price, quantity,level));
                System.out.println("股票已添加！");
                break;
            }
            case "2": {
                String code = Util.readString("请输入基金代码：");
                String name = Util.readString("请输入基金名称：");
                int quantity = Util.readInt("请输入基金数量：");
                double price = Util.readDouble("请输入基金价格：");
                RiskLevel level = readRiskLevel();
                pf.add(new Fund(code, name, price, quantity,level));
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
                pf.add(new Bond(code, name, price, quantity, couponRate,level));
                System.out.println("债券已添加！");
                break;
            }
            default:
                System.out.println("无效的资产类型，请重试。");
        }
    }


/**
 * 按收益查看资产列表的方法
 * @param pf 投资组合对象，包含所有资产信息
 */
    private static void viewByProfit( Portfolio pf){
    // 检查投资组合是否为空
        if(pf.size()==0){
            System.out.println("暂无资产，请先添加。");
        }else{
            System.out.println("\n————— 资产列表（按收益排序）—————");
        // 获取投资组合中的所有资产
            ArrayList<Asset> list = pf.getAll();
        // 使用Comparator对资产按收益进行降序排序
            list.sort(new Comparator<Asset>() {
                @Override
                public int compare(Asset o1, Asset o2) {
                // 比较两个资产的收益，o2在前实现降序排序
                    return Double.compare(o2.calculateProfit(), o1.calculateProfit());
                }
            });
            for (Asset asset : list) {
                System.out.println(asset.getInfo());
            }
        }

    }

    /**
     * 按名称查看资产列表的方法
     * @param pf 投资组合对象，包含所有资产信息
     */
     private static void viewByName(Portfolio pf){
         if(pf.size()==0){
             System.out.println("暂无资产，请先添加。");
             return;
         }else{
             System.out.println("\n————— 资产列表（按名称排序）—————");
             ArrayList<Asset> list = pf.getAll();
             Collections.sort(list,new Comparator<Asset>() {

                 @Override
                 public int compare(Asset o1, Asset o2) {
                     return o1.getName().compareTo(o2.getName());
                 }
             });
             for (Asset asset : list) {
                 System.out.println(asset.getInfo());
             }
         }
     }

     //降序
    private static void viewByMarketValue(Portfolio pf){
         if(pf.size()==0){
             System.out.println("暂无资产，请先添加。");
             return;
         }else{
             System.out.println("\n————— 资产列表（按市值排序）—————");
             ArrayList<Asset> list = pf.getAll();
             Collections.sort(list,new Comparator<Asset>() {

                 @Override
                 public int compare(Asset o1, Asset o2) {
                     return Double.compare(o2.getMarketValue(), o1.getMarketValue());
                 }
             });
             for (Asset asset : list) {
                 System.out.println(asset.getInfo());
             }
         }
    }

    private static void findByCode(Portfolio pf){
         String code = Util.readString("请输入资产代码：");
         Asset a = pf.findByCode(code);
         if(a==null){
             System.out.println("未找到该资产！");
         }else {
             System.out.println(a.getInfo());
         }

    }

    private static void remove(Portfolio pf){
         String code = Util.readString("请输入资产代码：");
         if(pf.remove(code)){
             System.out.println("删除成功！");
         }else{
             System.out.println("删除失败！");
         }
    }

    private static void showTotal(Portfolio pf){
         System.out.println("\n————— 统计信息 —————");
         System.out.println("总资产价值：" + String.format("%.2f",pf.getTotalMarketValue()));
         System.out.println("总资产利润：" + String.format("%.2f",pf.getTotalProfit()));
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