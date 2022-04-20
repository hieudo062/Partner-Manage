package com.unikom.partnermanage.entity;

import com.unikom.partnermanage.dto.PartnerDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;

@Data
@Entity
@Table(name = "partner")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "founded_year")
    private int foundedYear;

    @Column(name = "quantity_of_employee")
    private int quantityOfEmployee;

    @Column(name = "address")
    private String address;

    @Column(name = "start_to_cooperate")
    private int startToCooperate;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_at")
    private String modifiedAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    public Partner() {

    }

    public Partner(PartnerDTO source) {
        BeanUtils.copyProperties(source, this);
    }

}
