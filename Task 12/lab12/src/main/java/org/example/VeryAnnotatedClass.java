package org.example;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "demo annotated", indexes = {
        @Index(name = "name_idx", columnList = "name"),
        @Index(name = "id_name_idx", columnList = "id, name"),
        @Index(name = "unique_name_idx", columnList = "name", unique = true)
})
public class VeryAnnotatedClass {
    @Id
    @Column(name = "id")
    @GeneratedValue
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "weight")
    float weight;

    // varchar(10) NOT NULL
    @Column(name = "short_str", nullable = false, length = 10)
    String shortString;

    // перевод величин
    @Column(name = "weight")
    @ColumnTransformer(read = "weight/ 2.0", write = "? * 2.0")
    float dividedWeight;

    // среднее значение стоимости товара по определенному производителю
    @Formula("SELECT avg(p.cost) FROM Product p WHERE p.manufacturer_id = id ")
    BigDecimal avgManufacturerProductCoat;

    // для хранения даты и времени
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created at", updatable = false)
    @CreationTimestamp
    LocalDateTime createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated at")
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @Column(name = "manual_det_str", columnDefinition = "VARCHAR (50) NOT NULL UNIQUE CHECK( NOT substring(lower(manual_def_str), 0, 5) = 'adv')")
    String manualDefinedString;

    @ManyToOne
    @JoinColumn(
            name = "product id",
            nullable = false,
            foreignKey = @ForeignKey(name = "FK_PRODUCT_ID")
    )
    Product product;

    @Version
    long version;
}