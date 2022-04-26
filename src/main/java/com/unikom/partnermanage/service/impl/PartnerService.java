package com.unikom.partnermanage.service.impl;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.dto.request.Search;
import com.unikom.partnermanage.entity.Partner;
import com.unikom.partnermanage.repository.IPartnerRepository;
import com.unikom.partnermanage.service.IPartnerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.social.ResourceNotFoundException;
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

    @Override
    public PartnerDTO save(PartnerDTO partner) {
        return new PartnerDTO(partnerRepository.save(new Partner(partner)));
    }

    @Override
    public PartnerDTO delete(Long id) {
        Partner partner = partnerRepository.findByIdAndIsDeletedIsFalse(id).orElseThrow(() -> new ResourceNotFoundException("Partner", "PartnerID does not exist!"));
        partner.setIsDeleted(true);
        return new PartnerDTO(partnerRepository.save(partner));
    }

    @Override
    public long count(Search search) {
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT COUNT(*) ");
        builder.append(" FROM Partner p ");
        builder.append(" WHERE 1=1 ");
        builder.append(" AND isDeleted = 0 ");

        Map<String, Object> params = new HashMap<>();

        if (search.getCode() != null) {
            builder.append(" AND p.code like :code ");
            params.put("code", "%" + search.getCode() + "%");
        }
        if (search.getName() != null) {
            builder.append(" AND p.name like :name ");
            params.put("name", "%" + search.getName() + "%");
        }
        if (search.getFoundedYear() != null) {
            builder.append(" AND p.foundedYear like :foundedYear ");
            params.put("foundedYear", search.getFoundedYear());
        }
        if (search.getQuantityOfEmployee()  != null) {
            builder.append(" AND p.quantityOfEmployee = :quantityOfEmployee ");
            params.put("quantityOfEmployee", search.getQuantityOfEmployee());
        }

        Query query = entityManager.createQuery(builder.toString());
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return (long) query.getSingleResult();
    }

    @Override
    public Page<PartnerDTO> search(Search search, Pageable pageable) {

        long totalRecord = this.count(search);

        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT p ");
        builder.append(" FROM Partner p ");
        builder.append(" WHERE 1=1 ");
        builder.append(" AND isDeleteed = 0 ");

        Map<String, Object> params = new HashMap<>();

        if (search.getCode() != null) {
            builder.append(" AND p.code like :code ");
            params.put("code", "%" + search.getCode() + "%");
        }
        if (search.getName() != null) {
            builder.append(" AND p.name like :name ");
            params.put("name", "%" + search.getName() + "%");
        }
        if (search.getFoundedYear() != null) {
            builder.append(" AND p.foundedYear like :foundedYear ");
            params.put("foundedYear", search.getFoundedYear());
        }
        if (search.getQuantityOfEmployee() != null) {
            builder.append(" AND p.quantityOfEmployee = :quantityOfEmployee ");
            params.put("quantityOfEmployee", search.getQuantityOfEmployee());
        }

        Query query = entityManager.createQuery(builder.toString())
                .setMaxResults(pageable.getPageSize())
                .setFirstResult((int) pageable.getOffset());
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return new PageImpl<PartnerDTO>(query.getResultList(), pageable, totalRecord);
    }



    @Override
    public PartnerDTO findById(Long id) {
        return partnerRepository.findByIdAndIsDeletedIsFalse(id).map(PartnerDTO::new).orElseThrow(() -> new ResourceNotFoundException("Partner", "Partner does not exist!"));
    }

    @Override
    public PartnerDTO update(Long id, PartnerDTO partnerDTO) {
        PartnerDTO p = partnerRepository.findByIdAndIsDeletedIsFalse(id).map(PartnerDTO::new).orElseThrow(() -> new ResourceNotFoundException("Partner", "Partner does not exist!"));
        p.update(partnerDTO);
        partnerRepository.save(new Partner(p));
        return p;
    }

    public Page<PartnerDTO> findAll(Pageable pageable) {
        long size = partnerRepository.count();
        return new PageImpl<>(convertToDTO(partnerRepository.findAll()), pageable, size);
    }

    private List<PartnerDTO> convertToDTO(List<Partner> partnerEntities) {
        List<PartnerDTO> partnerDTOs = new ArrayList<>();
        for (Partner partner : partnerEntities) {
            partnerDTOs.add(new PartnerDTO(partner));
        }
        return partnerDTOs;
    }

}
