package com.fundaments.boot.fundaments.repository;

import com.fundaments.boot.fundaments.entity.ArtifactToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactTokenRepository extends JpaRepository<ArtifactToken, Long> {

}
