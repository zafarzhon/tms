package com.teachmeskills.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Entity
@Table(name = "persons")
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "create_time")
    @CreationTimestamp
    private LocalDateTime createTime;
    @Column(name = "update_time")
    @UpdateTimestamp
    private LocalDateTime updateTime;
    @Version
    private Integer version;
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setPerson(this);
    }
}
