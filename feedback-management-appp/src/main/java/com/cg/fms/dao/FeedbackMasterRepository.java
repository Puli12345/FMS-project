package com.cg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.FeedbackMaster;

@Repository
public interface FeedbackMasterRepository extends JpaRepository<FeedbackMaster, Integer> {
   
}
