package com.roncoo.eshop.product.model;

public class ProductSpecification {

    private Long id;
    private String name;
    private String value;
    private Long productId;

    public ProductSpecification() {
    }

    public ProductSpecification(Long id, String name, String value, Long productId) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
