package com.finance;

/**
 * Asset类，用于表示资产信息
 * 这是一个基础的资产类，可以用于存储和管理各种资产相关的数据
 */
public abstract class Asset {
    private String code;// 资产代码
    private String name;// 资产名称
    private double price;// 单价
    private int quantity;// 持仓数量

    /**
     * 资产类的构造方法
     * @param price 资产价格
 * @param quantity 资产数量
 */
    public Asset(String code, String name, double price, int quantity) {
    // 使用传入的参数初始化资产代码
        this.code = code;
    // 使用传入的参数初始化资产名称
        this.name = name;
    // 使用传入的参数初始化资产价格
        this.price = price;
    // 使用传入的参数初始化资产数量
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

/**
 * 计算市场价值的方法
 * 该方法通过价格和数量的乘积得到总的市场价值
 *
 * @return 返回计算得到的市场价值，类型为double
 */
    public double getMarketValue() {
    // 返回价格与数量的乘积，即市场总价值
        return price * quantity;
    }

    public abstract double calculateProfit();

    public String getInfo() {
        return "资产代码：" + code + "，资产名称：" + name + "，单价：" + price + "，持仓数量：" + quantity + "，市值：" + getMarketValue();
    }
}
