package com.finance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Portfolio {
    private ArrayList<Asset> assets;//主存储
    private HashMap<String, Asset> codeIndex;//索引
    private HashSet<String> codes;//防止重复

    public Portfolio() {
        this.assets = new ArrayList<>();
        this.codeIndex = new HashMap<>();
        this.codes = new HashSet<>();
    }

    //添加资产
    public boolean add(Asset asset) {
       if(codes.contains(asset.getCode())){
           System.out.println("资产代码重复，请重新输入");
           return false;
       }else {
           assets.add(asset);
           codeIndex.put(asset.getCode(), asset);
           codes.add(asset.getCode());
           return true;
       }
    }

/**
 * 根据资产代码查找资产对象
 * @param code 资产代码，用于唯一标识一个资产
 * @return 返回找到的Asset对象，如果未找到则返回null
 */
    public Asset findByCode(String code) {
    // 通过codeIndex映射表根据code键获取对应的Asset值
        return codeIndex.get(code);
    }

/**
 * 根据资产代码移除资产的方法
 * @param code 要移除的资产代码
 * @return 如果成功移除返回true，如果资产不存在返回false
 */
    public boolean remove(String code){
        // 检查codes集合中是否包含指定的资产代码
        if(codes.contains(code)){
            // 根据资产代码获取其索引并从assets集合中移除对应的资产
            assets.remove(codeIndex.get(code));
            // 从代码索引映射中移除该资产代码的映射关系
            codeIndex.remove(code);
            // 从资产代码集合中移除该代码
            codes.remove(code);
            return true;
        }else {
            // 如果资产不存在，打印提示信息并返回false
            System.out.println("资产不存在");
            return false;
        }
    }
     public ArrayList<Asset> getAll() {
        return assets;
    }

     public int size (){
        return assets.size();
     }

     public double getTotalMarketValue(){
        double totalMarketValue = 0;
        for(Asset asset : assets){
            totalMarketValue += asset.getMarketValue();
        }
        return totalMarketValue;
     }

     public double getTotalProfit(){
        double totalProfit = 0;
        for(Asset asset : assets){
            totalProfit += asset.calculateProfit();
        }
        return totalProfit;
     }
}
