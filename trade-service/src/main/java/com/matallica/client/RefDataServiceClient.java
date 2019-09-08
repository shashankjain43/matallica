package com.matallica.client;

import com.matallica.client.model.response.GetAllCommoditiesResponse;
import com.matallica.client.model.response.GetAllLocationsResponse;
import com.matallica.client.model.response.GetAllPartiesResponse;
import com.matallica.model.response.ServiceResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ref-data-service")
@RibbonClient(name= "ref-data-service")
public interface RefDataServiceClient {

    @GetMapping("/v1/commodities")
    ServiceResponse<GetAllCommoditiesResponse> getAllCommodities();

    @GetMapping("/v1/locations")
    ServiceResponse<GetAllLocationsResponse> getAllLocations();

    @GetMapping("/v1/parties")
    ServiceResponse<GetAllPartiesResponse> getAllParties();
}
