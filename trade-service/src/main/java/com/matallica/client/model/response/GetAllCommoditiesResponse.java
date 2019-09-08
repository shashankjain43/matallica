package com.matallica.client.model.response;

import com.matallica.client.model.entity.Commodity;
import com.matallica.model.response.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetAllCommoditiesResponse extends BaseResponse {

    List<Commodity> commodities;
}
