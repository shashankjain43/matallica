package com.matallica.model.request;

import com.matallica.model.entity.Trade;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTradeRequest extends BaseRequest {

    Trade trade;
}
