package com.unikom.partnermanage.dto;

import com.unikom.partnermanage.entity.PartnerEntity;
import lombok.Data;

@Data
public class PartnerDTO {
    private String code;
    private String name;
    private int founderYear;
    private int quantityOfEmployee;

    private PartnerEntity toEntity() {

        PartnerEntity partnerEntity = new PartnerEntity();
        partnerEntity.setName(this.name);
        partnerEntity.setCode(this.code);
        partnerEntity.setFoundedYear(this.founderYear);
        partnerEntity.setQuantityOfEmployee(this.quantityOfEmployee);

        return partnerEntity;
    }
}
