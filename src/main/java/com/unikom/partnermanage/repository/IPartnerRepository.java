package com.unikom.partnermanage.repository;

import com.unikom.partnermanage.entity.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPartnerRepository extends JpaRepository<Partner, Long> {

//    @Query("select p from PartnerEntity p where p.code like %:code% and p.name like %:name%")
//    List<PartnerEntity> searchPartner(String code, String name);

    @Query(value = "select * " +
            "from Partner as p " +
            "where 1=1 " +
            "and p.code like %:code% " +
            "and p.name like %:name% " +
            "and p.founded_year = :foundedYear " +
            "and p.quantity_of_employee = :quantityOfEmployee " +
            "limit :limit offset :offset", nativeQuery = true)
    List<Partner> searchPartner(String code, String name, int foundedYear, int quantityOfEmployee, int limit, int offset);

}
