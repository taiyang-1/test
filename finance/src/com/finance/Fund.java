package com.finance;

/**
 * 基金类
 * 该类用于表示基金的基本信息，可以扩展添加基金的属性和方法
 */
public class Fund extends Asset{
    /**
     * 资产类的构造方法
     *
     * @param code     资产代码
     * @param name     资产名称
     * @param price    资产价格
     * @param quantity 资产数量
     */
    public Fund(String code, String name, double price, int quantity,RiskLevel level) {
        super(code, name, price, quantity , AssetType.FUND , level);
    }

    @Override
    public double calculateProfit() {
        return (getMarketValue() - getMarketValue()*0.015);
    }

}
