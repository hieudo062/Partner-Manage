package com.unikom.partnermanage.service;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.dto.Search;
import com.unikom.partnermanage.entity.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.Part;
import java.util.List;

public interface IPartnerService {

    PartnerDTO save(PartnerDTO partnerDTO);
    void deleteById(Long id);
    Page<PartnerDTO> search(Search search, int page, int size, Pageable pageable);
    PartnerDTO findById(Long id);
    PartnerDTO update(Long id, PartnerDTO partnerDTO);
    int count(Search search);

}
