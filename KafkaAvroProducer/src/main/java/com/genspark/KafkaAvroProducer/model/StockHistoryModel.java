package com.genspark.KafkaAvroProducer.model;

public class StockHistoryModel {


    public int getTradeId() {
        return TradeId;
    }

    public void setTradeId(int tradeId) {
        TradeId = tradeId;
    }

    private int TradeId;
    private int tradeQuantity;
    private String tradeMarket;
    private String stockName;
    private String tradeType;
    private float price;
    private float amount;     public int getTradeQuantity() {
        return tradeQuantity;
    }     public void setTradeQuantity(int tradeQuantity) {
        this.tradeQuantity = tradeQuantity;
    }     public String getTradeMarket() {
        return tradeMarket;
    }     public void setTradeMarket(String tradeMarket) {
        this.tradeMarket = tradeMarket;
    }     public String getStockName() {
        return stockName;
    }     public void setStockName(String stockName) {
        this.stockName = stockName;
    }     public String getTradeType() {
        return tradeType;
    }     public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }     public float getPrice() {
        return price;
    }     public void setPrice(float price) {
        this.price = price;
    }     public float getAmount() {
        return amount;
    }     public void setAmount(float amount) {
        this.amount = amount;
    }


}