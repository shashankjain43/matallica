package com.mettalica.model.response;

import com.mettalica.model.entity.Commodity;
import lombok.Data;

import java.util.List;

@Data
public class GetAllCommoditiesResponse extends BaseResponse {

    List<Commodity> commodities;
}
