package com.matallica.client.model.response;

import com.matallica.model.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class GetMarketDataResponse extends BaseResponse {

    String commodityCode;
    BigDecimal price;
}
