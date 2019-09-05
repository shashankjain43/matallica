package com.matallica.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String side;
    BigDecimal price;
    BigDecimal quantity;
    String commodity;
    String counterParty;
    String location;
    Date tradeDate;
}
