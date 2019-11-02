package org.hunngom.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
// TODO discuss whether this is needed, or rather we go for the fixed membership fee / donation payments
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_type_generator")
    @SequenceGenerator(name = "payment_type_generator", sequenceName = "payment_type_seq", allocationSize = 1)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name; // for now we do not support multi-lingual UI
}
