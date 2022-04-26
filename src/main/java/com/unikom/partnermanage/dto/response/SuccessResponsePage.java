package com.unikom.partnermanage.dto.response;

import com.unikom.partnermanage.dto.PartnerDTO;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class SuccessResponsePage {

    private int status;
    private long totalRecord;
    private Page<PartnerDTO> data;

    public SuccessResponsePage(int status, long totalRecord , Page<PartnerDTO> search) {
        this.status = status;
        this.totalRecord = totalRecord;
        this.data = search;
    }

}
