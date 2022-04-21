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
    private String code;
    private String name;
    private int foundedYear;
    private int quantityOfEmployee;
    private String address;
    private int startToCooperate;
    private Page page;

    public PartnerDTO(Partner source){
        BeanUtils.copyProperties(source, this);
    }
}
