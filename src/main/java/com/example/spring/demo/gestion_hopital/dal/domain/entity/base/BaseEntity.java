package com.example.spring.demo.gestion_hopital.dal.domain.entity.base;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@ToString
public class BaseEntity <T extends Serializable> {
    @Id
    @GeneratedValue
    private T id;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Setter
    private LocalDateTime createdAt;

    @Column(name = "UPDATED_AT",nullable = false )
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    @Setter
    private LocalDateTime updatedAt;
}
