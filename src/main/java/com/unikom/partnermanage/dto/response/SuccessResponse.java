package com.unikom.partnermanage.dto.response;

import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class SuccessResponse {

    private int status;
    private int totalRecord;
    private Page<PartnerDTO> data;

    public SuccessResponse(int status, int totalRecord ,Page<PartnerDTO> search) {
        this.status = status;
        this.totalRecord = totalRecord;
        this.data = search;
    }

}
