package com.mf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_goods")
public class Goods {

    @Id
    @GeneratedValue
    private Integer id;

    private String code;

    private String name;

    private Double purchasePrice;

    private Double inventoryquantity;

    private Double minQuantity;

    private Double priceWhole;

    private Double priceResale;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getQuantity() {
        return inventoryquantity;
    }

    public void setQuantity(Double quantity) {
        this.inventoryquantity = quantity;
    }

    public Double getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(Double minQuantity) {
        this.minQuantity = minQuantity;
    }

    public Double getPriceWhole() {
        return priceWhole;
    }

    public void setPriceWhole(Double priceWhole) {
        this.priceWhole = priceWhole;
    }

    public Double getPriceResale() {
        return priceResale;
    }

    public void setPriceResale(Double priceResale) {
        this.priceResale = priceResale;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", quantity=" + inventoryquantity +
                ", minQuantity=" + minQuantity +
                ", priceWhole=" + priceWhole +
                ", priceResale=" + priceResale +
                '}';
    }
}
