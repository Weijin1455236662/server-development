package example;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person {

    private Long id;

    @NotNull
    @Size(min = 5, max = 20,message="{name.size}")
    private String name;

    @NotNull
    @Size(min = 2, max = 100,message="{address.size}")
    private String address;

    @NotNull
    @Size(min = 2, max = 6,message="{zipCode.size}")
    private String zipCode;

    @NotNull
    @Size(min = 2, max = 11,message="{phone.size}")
    private String phone;

    public Person() {
    }

    public Person(String name, String address, String zipCode, String phone) {
        this(null, name, address, zipCode, phone);
    }

    public Person(Long id, String name, String address, String zipCode, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "id","address", "zipCode", "phone");
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, "id","address", "zipCode", "phone");
    }

}
