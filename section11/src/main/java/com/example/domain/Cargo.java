
package com.example.domain;

public class Cargo {
    private Long id;

    private Customer customer;

    private String product;

    private Integer quantity;

    private Cargo() {
    }

    public Cargo(Long id, Customer customer, String product, Integer quantity) {
        this.id = id;
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return this.id;
    }

    public String getProduct() {
        return this.product;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Cargo setProduct(String product) {
        this.product = product;
        return this;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", customer=" + customer +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
