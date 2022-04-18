package com.unikom.partnermanage.service;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.entity.PartnerEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IPartnerService {

    PartnerEntity save(PartnerEntity partner);
    void deleteById(Long id);
    List<PartnerEntity> search(PartnerDTO partnerDTO);
    Optional<PartnerEntity> findById(Long id);

}
