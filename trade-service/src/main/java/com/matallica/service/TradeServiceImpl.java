package com.matallica.service;

import com.matallica.client.RefDataServiceClient;
import com.matallica.client.model.response.GetAllCommoditiesResponse;
import com.matallica.dao.TradeDao.TradeDao;
import com.matallica.exception.ServiceException;
import com.matallica.exception.TradeNotFoundException;
import com.matallica.model.entity.Trade;
import com.matallica.model.response.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class TradeServiceImpl implements ITradeService {

    @Autowired
    TradeDao tradeDao;

    @Autowired
    RefDataServiceClient client;

    @Override
    public void createTrade(Trade trade) {
        trade.setTradeDate(new Date());
        if (tradeDao.countById(trade.getId()) > 0) {
            throw new ServiceException("ER-1002", "Trade already exists!");
        }
        tradeDao.save(trade);
    }

    @Override
    public Trade getTrade(Long tradeId) {
        Optional<Trade> trade = tradeDao.findById(tradeId);
        if (!trade.isPresent()) {
            throw new TradeNotFoundException("ER-1001", "Trade not found!");
        }
        ServiceResponse<GetAllCommoditiesResponse> commodities = client.getAllCommodities();
        commodities.getResponse().getCommodities().stream().forEach(e -> System.out.println("" + e));
        return trade.get();
    }

    @Override
    public void updateTrade(Trade trade) {
        if (tradeDao.countById(trade.getId()) <= 0) {
            throw new ServiceException("ER-1003", "No such Trade exists!");
        }
        tradeDao.save(trade);
    }

    @Override
    public void deleteById(Long tradeId) {
        if (tradeDao.countById(tradeId) <= 0) {
            throw new ServiceException("ER-1003", "No such Trade exists!");
        }
        tradeDao.deleteById(tradeId);
    }
}
