package com.matallica.client.model.response;

import com.matallica.client.model.entity.Party;
import com.matallica.model.response.BaseResponse;
import lombok.Data;

import java.util.List;

@Data
public class GetAllPartiesResponse extends BaseResponse {

    List<Party> parties;
}
