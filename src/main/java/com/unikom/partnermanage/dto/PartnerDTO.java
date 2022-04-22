package com.unikom.partnermanage.dto;

import com.unikom.partnermanage.entity.Partner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDTO {
    private Long id;
    private String code;
    private String name;
    private int foundedYear;
    private int quantityOfEmployee;
    private String address;
    private int startToCooperate;
    private Boolean isDeleteed = false;

    public void update(PartnerDTO source) { BeanUtils.copyProperties(source, this, "id"); }

    public PartnerDTO(Partner source){
        BeanUtils.copyProperties(source, this, "isDeleteed");
    }
}
