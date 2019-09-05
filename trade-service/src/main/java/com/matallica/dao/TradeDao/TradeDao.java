package com.matallica.dao.TradeDao;

import com.matallica.model.entity.Trade;
import org.springframework.data.repository.CrudRepository;

public interface TradeDao extends CrudRepository<Trade, Long> {

    int countById(Long id);
}
