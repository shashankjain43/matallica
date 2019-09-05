package com.matallica.controller;

import com.matallica.model.request.CreateTradeRequest;
import com.matallica.model.request.UpdateTradeRequest;
import com.matallica.model.response.CreateTradeResponse;
import com.matallica.model.response.GetTradeResponse;
import com.matallica.model.response.ServiceResponse;
import com.matallica.model.response.UpdateTradeResponse;
import com.matallica.service.ITradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/v1/trades")
public class TradeController {

    @Autowired
    ITradeService tradeService;

    @PostMapping("/create")
    public ServiceResponse<CreateTradeResponse> createTrade(@Valid @RequestBody CreateTradeRequest request){

        tradeService.createTrade(request.getTrade());
        CreateTradeResponse response = new CreateTradeResponse();
        response.setMessage("Successfully created!");
        ServiceResponse<CreateTradeResponse> res = new ServiceResponse<>();
        res.setResponse(response);
        return res;
    }

    @PostMapping("/update")
    public ServiceResponse<UpdateTradeResponse> createTrade(@Valid @RequestBody UpdateTradeRequest request){

        tradeService.updateTrade(request.getTrade());
        UpdateTradeResponse response = new UpdateTradeResponse();
        response.setMessage("Successfully updated!");
        ServiceResponse<UpdateTradeResponse> res = new ServiceResponse<>();
        res.setResponse(response);
        return res;
    }

    @GetMapping("/{tradeId}")
    public ServiceResponse<GetTradeResponse> createTrade(@PathVariable @Min(1) Long tradeId){

        GetTradeResponse response = new GetTradeResponse();
        response.setTrade(tradeService.getTrade(tradeId));
        ServiceResponse<GetTradeResponse> res = new ServiceResponse<>();
        res.setResponse(response);
        return res;
    }


}
