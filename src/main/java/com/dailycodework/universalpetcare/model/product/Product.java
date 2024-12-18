package com.dailycodework.universalpetcare.model.product;

import com.dailycodework.universalpetcare.enums.Type;
import com.dailycodework.universalpetcare.model.BaseEntity;
import com.dailycodework.universalpetcare.model.Photo;
import com.dailycodework.universalpetcare.model.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Product extends BaseEntity {
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "name") // 1, 2, 3
    private String name;

    @Column(name = "sku") // 1, 2, 3
    private String sku;

    @Column(name = "slug")
    private String slug;

    @Column(name = "description", columnDefinition = "TEXT") // 1, 2, 3
    private String description;

    @Column(name = "price") // 1, 2, 3 // gia thuc te ban ra
    private Long price;

    @Column(name = "display")
    private Integer display; // 1 : show, 0: hidden

    @Lob
    private Blob photo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id") // 1, 2, 3
    private Category category;

    public void removeProductPhoto(){
        if(this.getPhoto() != null){
            this.setPhoto(null);
        }
    }

}
