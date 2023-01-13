package com.kyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kyc.entity.OCRDataBase;


@Repository
public interface IOcrResponseRepository extends JpaRepository<OCRDataBase, Long> {

}
