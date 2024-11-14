package com.teachmeskills.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

@Entity
@Table(name = "orders")
@NoArgsConstructor
@Data
public class Order {
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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    @ToString.Exclude
    private Person person;


}