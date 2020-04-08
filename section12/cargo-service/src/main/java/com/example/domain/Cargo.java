
package com.example.domain;

import javax.persistence.*;

@Entity(name = "cargo")
public class Cargo {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer")//注释本表中指向另一个表的外键（在当前表的字段名）
    private Customer customer;

    @Column
    private String product;

    @Column
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
