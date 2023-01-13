package com.kyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kyc.entity.PanDetails;


@Repository
public interface IKycRepository extends JpaRepository<PanDetails, Integer> {

}
