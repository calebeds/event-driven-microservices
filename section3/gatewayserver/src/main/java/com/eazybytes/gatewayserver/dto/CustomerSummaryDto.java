package com.eazybytes.gatewayserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerSummaryDto {
    private CustomerDTO customer;
    private AccountsDto account;
    private LoanDto loan;
    private CardsDto cards;
}
