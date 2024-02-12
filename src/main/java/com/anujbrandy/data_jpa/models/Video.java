package com.anujbrandy.data_jpa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
// 1
// @DiscriminatorValue("V")
// 2
//@PrimaryKeyJoinColumn(name = "video_id")
// 3
public class Video extends Resource {
    private int length;
}
