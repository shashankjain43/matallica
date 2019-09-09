package com.metallica.service;

import com.metallica.client.MarketDataServiceClient;
import com.metallica.client.RefDataServiceClient;
import com.metallica.client.model.response.GetAllCommoditiesResponse;
import com.metallica.client.model.response.GetMarketDataResponse;
import com.metallica.constants.AppConstant;
import com.metallica.dao.TradeDao.TradeDao;
import com.metallica.exception.ServiceException;
import com.metallica.exception.TradeNotFoundException;
import com.metallica.model.entity.Trade;
import com.metallica.model.response.ServiceResponse;
import com.metallica.rabbitmq.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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

    @Autowired
    MarketDataServiceClient mdClient;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    RabbitMQConfig mqConfig;

    @Override
    public void createTrade(Trade trade) {
        trade.setTradeDate(new Date());
        if (tradeDao.countById(trade.getId()) > 0) {
            throw new ServiceException("ER-1002", "Trade already exists!");
        }
        ServiceResponse<GetMarketDataResponse> mdResponse = mdClient.getMarketPrice(trade.getCommodity());
        trade.setPrice(mdResponse.getResponse().getPrice());
        trade.setTradeStatus(AppConstant.INITIATED);
        rabbitTemplate.convertAndSend(mqConfig.getExchangeName(), mqConfig.getRoutingKey(), trade);
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
