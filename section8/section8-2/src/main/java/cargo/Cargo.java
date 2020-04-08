
package cargo;

import java.io.Serializable;
import java.util.Date;

public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String product;

    private Integer quantity;

    private Date orderDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                '}';
    }
}
