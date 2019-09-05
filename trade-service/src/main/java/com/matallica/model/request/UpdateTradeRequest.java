package com.matallica.model.request;

import com.matallica.model.entity.Trade;
import lombok.Data;

@Data
public class UpdateTradeRequest extends BaseRequest{

    Trade trade;
}
