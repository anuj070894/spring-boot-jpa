package com.anujbrandy.data_jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
// 1
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "resource_type")
// 2
//@Inheritance(strategy = InheritanceType.JOINED)
// 3
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Resource extends BaseEntity {
    private String name;

    private int size;

    private String url;

    @OneToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;
}
