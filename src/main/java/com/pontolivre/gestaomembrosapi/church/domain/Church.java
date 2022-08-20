package com.pontolivre.gestaomembrosapi.church.domain;

import com.pontolivre.gestaomembrosapi.commons.Address;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "church")
public class Church implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "church_id")
    private UUID id;

    @Setter
    private String denomination;

    @Setter
    private Address address;

    @Setter
    @Column(name = "corporate_name")
    private String corporateName;

    @Setter
    private String cnpj;

    @Setter
    private String phone;

    @Setter
    private String email;

    @Setter
    @Column(name = "founded_in")
    private String foundedIn;

    @Setter
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
