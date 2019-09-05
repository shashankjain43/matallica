package com.matallica.service;

import com.matallica.model.entity.Trade;

public interface ITradeService {
    void createTrade(Trade trade);

    Trade getTrade(Long tradeId);

    void updateTrade(Trade trade);
}
