package com.unikom.partnermanage.service.impl;

import com.unikom.partnermanage.dto.PartnerDTO;
import com.unikom.partnermanage.dto.Search;
import com.unikom.partnermanage.entity.Partner;
import com.unikom.partnermanage.repository.IPartnerRepository;
import com.unikom.partnermanage.service.IPartnerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.Part;
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
    public void deleteById(Long id) {
        partnerRepository.deleteById(id);
    }

    @Override
    public Page<PartnerDTO> search(Search search, Pageable pageable) {
        StringBuilder builder = new StringBuilder();
        Map<String, Object> params = new HashMap<>();

        builder.append(" SELECT p ");
        builder.append(" FROM Partner p ");
        builder.append(" WHERE 1=1 ");
        if (search.getCode() != null) {
            builder.append(" AND p.code like :code ");
            params.put("code", "%" + search.getCode() + "%");
        }
        if (search.getName() != null) {
            builder.append(" AND p.code like :name ");
            params.put("name", "%" + search.getName() + "%");
        }
        Optional<Integer> foundedYear = Optional.ofNullable(search.getFoundedYear());
        if (foundedYear.equals(0)) {
            builder.append(" AND p.code = :foundedYear ");
            params.put("foundedYear", foundedYear);
        }
        Optional<Integer> quantityOfEmployee = Optional.ofNullable(search.getQuantityOfEmployee());
        if (quantityOfEmployee.equals(0)) {
            builder.append(" AND p.code = :quantityOfEmployee ");
            params.put("quantityOfEmployee", quantityOfEmployee);
        }

        Query query = entityManager.createQuery(builder.toString());

        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }

        List<PartnerDTO> partners = query.getResultList();
        Page<PartnerDTO> page = new PageImpl<PartnerDTO>(partners, pageable, partners.size());
        PageRequest.of(0,20);
        return page;
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
