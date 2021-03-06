package com.unikom.partnermanage.dto.response;

import com.unikom.partnermanage.dto.PartnerDTO;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class SuccessResponse {
    private int status;
    private PartnerDTO data;

    public SuccessResponse(int status , PartnerDTO search) {
        this.status = status;
        this.data = search;
    }
}
