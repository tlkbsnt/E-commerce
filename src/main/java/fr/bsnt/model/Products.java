package fr.bsnt.model;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String product_name;
    @NonNull
    private Long product_price;
    @NonNull
    private String product_company_name;
/*
    @NonNull
    private Date product_uploaded_date;
    @NonNull
    private Date product_date;
    @NonNull
    private Date product_expire_date;

 */

}
