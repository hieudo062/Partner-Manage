package com.unikom.partnermanage.service;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.entity.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPartnerService {

    Partner save(Partner partner);
    void deleteById(Long id);
    List<PartnerDTO> search(PartnerDTO partnerDTO);
    Page<PartnerDTO> searchPage(PartnerDTO partnerDTO, Pageable pageable);
    PartnerDTO findById(Long id);

}
