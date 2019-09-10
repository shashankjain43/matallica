package com.mettalica.rabbitmq;

import com.mettalica.constants.AppConstant;
import com.mettalica.dao.TradeDao;
import com.mettalica.model.entity.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Subscriber {

    @Autowired
    TradeDao tradeDao;

    @RabbitListener(queues = "${rabbitmq.queue-name}")
    public void receivedMessage(Trade trade) {
        log.info("Received trade is: {}", trade);
        trade.setTradeStatus(AppConstant.TRADE_STATUS_PROCESSED);
        tradeDao.save(trade);
    }
}