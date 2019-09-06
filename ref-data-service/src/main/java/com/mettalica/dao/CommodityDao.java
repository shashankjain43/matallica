package com.mettalica.dao;

import com.mettalica.model.entity.Commodity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityDao extends CrudRepository<Commodity, Integer> {
}
