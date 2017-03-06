package com.bms.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bms.Entities.BarrowDetailsEntity;

public interface BarrowDetailsDAO extends JpaRepository<BarrowDetailsEntity, Serializable>{

}
