package com.d288.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customers")
@Data
@Getter
@Setter

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "customer_first_name", nullable = false)
    private String firstName;

    @Column(name = "customer_last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "postal_code", nullable = false)
    private String postal_code;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_update;

    @JoinColumn(name = "division_id", referencedColumnName = "division_id", nullable = false
    )
    @ManyToOne
    private Division division;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Cart> carts;

    public Customer() {

<<<<<<< HEAD
<<<<<<< HEAD
    public void add(Cart cart) {
        carts.add(cart);
=======
    public Customer(){
>>>>>>> parent of ca61e94 (Created package bootstrap, created bootstrap>BootStrapData.java, added five sample customers to BootStrapData.java and added constructor to Customer.java)
=======
>>>>>>> parent of 8e71dc6 (bug fixes)
    }
}
