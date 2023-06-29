package com.example.demospring.data.entities;

import com.example.demospring.data.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Table(name = "orders")
public class OrderEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid2")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "user_fk"))
    private UserEntity user;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    @OneToMany
    @JoinTable(name = "order_id", foreignKey = @ForeignKey(name = "product_to_order_fk"))
    private List<OrderItemEntity> items;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
