package com.pontolivre.gestaomembrosapi.family.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "family")
public class Family implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "family_id")
    private UUID id;

    @Setter
    private String description;

    @Setter
    @Column(name = "changed_at")
    private LocalDateTime changedAt;
}
