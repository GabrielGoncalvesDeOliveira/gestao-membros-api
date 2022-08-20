package com.pontolivre.gestaomembrosapi.member.domain;

import com.pontolivre.gestaomembrosapi.commons.Address;
import com.pontolivre.gestaomembrosapi.church.domain.Church;
import com.pontolivre.gestaomembrosapi.commons.Gender;
import com.pontolivre.gestaomembrosapi.commons.MaritalStatus;
import com.pontolivre.gestaomembrosapi.commons.Ministry;
import com.pontolivre.gestaomembrosapi.family.domain.Family;
import lombok.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "member")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Member implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private UUID id;

    @Setter
    private String name;

    @Setter
    private String phone;

    @Setter
    private String email;

    @Setter
    private Address address;

    @Setter
    private String cpf;

    @Setter
    @Column(name = "birth_date")
    private String birthDate;

    @Setter
    @Column(name = "member_since")
    private String memberSince;

    @Setter
    private boolean baptized;

    @Setter
    private Gender gender;

    @Setter
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "family_id", name = "family_id",
            foreignKey = @ForeignKey(name = "member_family_fk", value = ConstraintMode.CONSTRAINT))
    private Family family;

    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "church_id", name = "church_id",
            foreignKey = @ForeignKey(name = "member_church_fk", value = ConstraintMode.CONSTRAINT))
    private Church church;

    @Setter
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<Ministry> ministries;

    @Setter
    private String nationality;

    @Setter
    private boolean active;

    @Setter
    private String picture;

    @Setter
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
