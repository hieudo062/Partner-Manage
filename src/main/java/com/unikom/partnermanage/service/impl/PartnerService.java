package com.unikom.partnermanage.service.impl;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.entity.Partner;
import com.unikom.partnermanage.repository.IPartnerRepository;
import com.unikom.partnermanage.service.IPartnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.*;

@Service
@AllArgsConstructor
public class PartnerService implements IPartnerService {

    private IPartnerRepository partnerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<PartnerDTO> getAllPartner() {
        return this.convertToDTO(partnerRepository.findAll());
    }

    @Override
    public Partner save(Partner partner) {
        return partnerRepository.save(partner);
    }

    @Override
    public void deleteById(Long id) {
        partnerRepository.deleteById(id);
    }

    @Override
    public List<PartnerDTO> search(PartnerDTO partnerDTO) {
        StringBuilder builder = new StringBuilder();
        Map<String, Object> params = new HashMap<>();
        builder.append(" SELECT p ");
        builder.append(" FROM Partner p ");
        builder.append(" WHERE 1=1 ");
        if (partnerDTO.getCode() != null) {
            builder.append(" AND p.code like :code ");
//            params.put("code", "%" + partnerDTO.getCode() + "%");
        }
        if (partnerDTO.getName() != null) {
            builder.append(" AND p.name like :name ");
//            params.put("name", "%" + partnerDTO.getName() + "%");
        }
        if (partnerDTO.getFoundedYear() != 0) {
            builder.append(" AND p.foundedYear = :foundedYear ");
//            params.put("foundedYear", "%" + partnerDTO.getFoundedYear() + "%");
        }
        if (partnerDTO.getQuantityOfEmployee() != 0) {
            builder.append(" AND p.quantityOfEmployee = :quantityOfEmployee ");
//            params.put("quantityOfEmployee", "%" + partnerDTO.getQuantityOfEmployee() + "%");
        }

        Query query = entityManager.createQuery(builder.toString());
        if (partnerDTO.getCode() != null) {
            query.setParameter("code", "%" + partnerDTO.getCode() + "%");
        }
        if (partnerDTO.getName() != null) {
            query.setParameter("name", "%" + partnerDTO.getCode() + "%");
        }
        if (partnerDTO.getFoundedYear() != 0) {
            query.setParameter("foundedYear", partnerDTO.getFoundedYear());
        }
        if (partnerDTO.getQuantityOfEmployee() != 0) {
            query.setParameter("quantityOfEmployee", partnerDTO.getQuantityOfEmployee());
        }
        return convertToDTO(query.getResultList());

    }


    @Override
    public PartnerDTO findById(Long id) {
        return partnerRepository.findById(id).map(PartnerDTO::new).orElseThrow(() -> new RuntimeException());
    }

    private List<PartnerDTO> convertToDTO(List<Partner> partnerEntities) {
        List<PartnerDTO> partnerDTOs = new ArrayList<>();

        for (Partner partner : partnerEntities) {
            partnerDTOs.add(new PartnerDTO(partner));
        }

        return partnerDTOs;
    }
}
