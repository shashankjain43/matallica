package com.matallica.client;

import com.matallica.client.model.response.GetAllCommoditiesResponse;
import com.matallica.client.model.response.GetAllLocationsResponse;
import com.matallica.client.model.response.GetAllPartiesResponse;
import com.matallica.constants.AppConstant;
import com.matallica.model.response.ServiceResponse;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = AppConstant.APP_NAME_ZUUL_API_GATEWAY)
@RibbonClient(name= AppConstant.APP_NAME_REF_DATA_SERVICE)
public interface RefDataServiceClient {

    @GetMapping("/"+ AppConstant.APP_NAME_REF_DATA_SERVICE +"/v1/commodities")
    ServiceResponse<GetAllCommoditiesResponse> getAllCommodities();

    @GetMapping("/"+ AppConstant.APP_NAME_REF_DATA_SERVICE +"/v1/locations")
    ServiceResponse<GetAllLocationsResponse> getAllLocations();

    @GetMapping("/"+ AppConstant.APP_NAME_REF_DATA_SERVICE +"/v1/parties")
    ServiceResponse<GetAllPartiesResponse> getAllParties();
}
