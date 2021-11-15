package com.example.homework.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
//@SequenceGenerator(name = "categoriesIDgenerator", sequenceName = "categories_id_seq", allocationSize = 1)
public class Category {

    @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productsIDgenerator")
    private Integer id;
    @Column(name = "parent_id")
    private Integer parentId;
    @Column(name = "category_name")
    private String categoryName;


}
