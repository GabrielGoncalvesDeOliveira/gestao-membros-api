package com.pontolivre.gestaomembrosapi.church.domain;

import com.pontolivre.gestaomembrosapi.address.Address;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

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
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Church implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "church_id", columnDefinition = "uuid")
    private UUID id;

    @Setter
    private String denomination;

    @Setter
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
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
    private boolean active;

    @Setter
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Setter
    @Column(name = "changed_at")
    private LocalDateTime changedAt;
}
