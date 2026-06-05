package com.finance;

/**
 * Stock类用于表示股票信息
 * 该类可以用于存储和操作股票相关的数据
 */
public class Stock extends Asset{

/**
 * 构造方法：创建Stock对象
 * @param code 股票代码
 * @param name 股票名称
 * @param price 股票价格
 * @param quantity 股票数量
 */
    public Stock(String code, String name, double price, int quantity ,  RiskLevel level) {
    // 调用父类的构造方法，初始化股票的基本属性
        super(code, name, price, quantity, AssetType.STOCK, level);
    }

    @Override
    public double calculateProfit() {
        return (getMarketValue() + getMarketValue()*0.02);
    }

}
