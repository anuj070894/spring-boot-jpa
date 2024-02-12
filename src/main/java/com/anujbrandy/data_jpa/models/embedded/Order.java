package com.anujbrandy.data_jpa.models.embedded;

import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(
        name = "_order"
)
public class Order {
    @EmbeddedId
    private OrderId id;

    private String orderInfo;

    @Embedded
    private Address address;
}
