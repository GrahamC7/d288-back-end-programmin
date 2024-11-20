package com.d288.demo.entities;

package com.d288.demo.entities;import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cartitem")
@Data


public class CartItem {

    private Long id;

    private Vacation vacation;

    private Set<Excursion> excursions;

    private Cart cart;

    private Date create_date;

    private Date last_update;
}
