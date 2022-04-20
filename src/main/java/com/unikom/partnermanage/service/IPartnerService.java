package com.unikom.partnermanage.service;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.entity.Partner;

import java.util.List;

public interface IPartnerService {

    Partner save(Partner partner);
    void deleteById(Long id);
    List<PartnerDTO> search(PartnerDTO partnerDTO);
    PartnerDTO findById(Long id);

}
