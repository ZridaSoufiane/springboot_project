package com.management.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @NotNull
    //@Size(min = 3, max = 20)
    private String nameProduct;
    //@Min(5)
    //@Max(10000)
    private Double priceProduct;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@PastOrPresent
    private Date dateCreate;
    @ManyToOne
    private Category category;
}
