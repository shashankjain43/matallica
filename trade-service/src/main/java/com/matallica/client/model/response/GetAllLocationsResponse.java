package com.matallica.client.model.response;

import com.matallica.client.model.entity.Location;
import com.matallica.model.response.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetAllLocationsResponse extends BaseResponse {

    List<Location> locations;
}
