package com.unikom.partnermanage.service.impl;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.entity.PartnerEntity;
import com.unikom.partnermanage.repository.IPartnerRepository;
import com.unikom.partnermanage.service.IPartnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PartnerService implements IPartnerService {

    private IPartnerRepository partnerRepository;

    public List<PartnerEntity> getPartner() { return partnerRepository.findAll();}

//    ???
    @Override
    public PartnerEntity save(PartnerEntity partner) {
        return (PartnerEntity) partnerRepository.save(partner);
    }

    @Override
    public void deleteById(Long id) {
        partnerRepository.deleteById(id);
    }

    @Override
    public List<PartnerEntity> search(PartnerDTO partnerDTO) {
        return partnerRepository.searchPartner("code", "name");
    }

    @Override
    public Optional<PartnerEntity> findById(Long id) {
        return partnerRepository.findById(id);
    }
}
