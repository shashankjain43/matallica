package com.matallica.client;

import com.matallica.client.model.response.GetAllCommoditiesResponse;
import com.matallica.client.model.response.GetAllLocationsResponse;
import com.matallica.client.model.response.GetAllPartiesResponse;
import com.matallica.client.model.response.GetMarketDataResponse;
import com.matallica.model.response.ServiceResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "my-zuul-api-gateway")
@RibbonClient(name= "market-data-service")
public interface MarketDataServiceClient {

    @GetMapping("market-data-service/v1/market/{commodityCode}")
    ServiceResponse<GetMarketDataResponse> getMarketPrice(@PathVariable("commodityCode") String commodityCode);
}
