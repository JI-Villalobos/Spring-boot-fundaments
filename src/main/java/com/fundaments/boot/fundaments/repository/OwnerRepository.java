package com.fundaments.boot.fundaments.repository;

import com.fundaments.boot.fundaments.entity.Owner;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query("SELECT o FROM Owner o WHERE o.email=?1")
    Optional<Owner> findByEmail(String email);

    @Query("SELECT o FROM Owner o WHERE o.name LIKE ?1%")
    List<Owner> findAndSort(String name, Sort sort);

    List<Owner> findByName(String name);

    List<Owner> findAll();
}
