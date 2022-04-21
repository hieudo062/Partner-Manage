package com.unikom.partnermanage.service;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.dto.Search;
import com.unikom.partnermanage.entity.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPartnerService {

    PartnerDTO save(PartnerDTO partner);
    void deleteById(Long id);
    Page<PartnerDTO> search(Search search, Pageable pageable);
    PartnerDTO findById(Long id);

}
