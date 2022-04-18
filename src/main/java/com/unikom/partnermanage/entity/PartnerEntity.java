package com.unikom.partnermanage.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "partner")
public class PartnerEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private int foundedYear;
    private int quantityOfEmployee;
    private String address;
    private int startToCooperate;
    private String createdAt;
    private String createdBy;
    private String modifiedAt;
    private String modifiedBy;

}
