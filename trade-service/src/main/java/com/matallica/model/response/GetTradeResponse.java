package com.matallica.model.response;

import com.matallica.model.entity.Trade;
import lombok.Data;

@Data
public class GetTradeResponse extends BaseResponse {

    Trade trade;
}
