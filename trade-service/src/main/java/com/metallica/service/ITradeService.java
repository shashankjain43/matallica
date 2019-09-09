package com.metallica.service;

import com.metallica.model.entity.Trade;

public interface ITradeService {
    void createTrade(Trade trade);

    Trade getTrade(Long tradeId);

    void updateTrade(Trade trade);

    void deleteById(Long tradeId);
}
