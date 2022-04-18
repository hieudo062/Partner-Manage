package com.unikom.partnermanage.repository;

import com.unikom.partnermanage.entity.PartnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPartnerRepository extends JpaRepository {

    @Query("select p from PartnerEntity p where p.code like %:code% and p.name like %:name%")
    List<PartnerEntity> searchPartner(String code, String name);

}
