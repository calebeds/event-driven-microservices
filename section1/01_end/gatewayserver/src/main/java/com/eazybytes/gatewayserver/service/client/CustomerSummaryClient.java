package com.eazybytes.gatewayserver.service.client;

import com.eazybytes.gatewayserver.dto.AccountsDto;
import com.eazybytes.gatewayserver.dto.CardsDto;
import com.eazybytes.gatewayserver.dto.CustomerDTO;
import com.eazybytes.gatewayserver.dto.LoanDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import reactor.core.publisher.Mono;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

public interface CustomerSummaryClient {
    @GetExchange(value = "/eazybank/customer/api/fetch", accept = APPLICATION_JSON)
    Mono<ResponseEntity<CustomerDTO>> fetchCustomerDetails(@RequestParam("mobileNumber") String mobileNumber);

    @GetExchange(value = "/eazybank/accounts/api/fetch", accept = APPLICATION_JSON)
    Mono<ResponseEntity<AccountsDto>> fetchAccountDetails(@RequestParam("mobileNumber") String mobileNumber);

    @GetExchange(value = "/eazybank/loans/api/fetch", accept = APPLICATION_JSON)
    Mono<ResponseEntity<LoanDto>> fetchLoanDetails(@RequestParam("mobileNumber") String mobileNumber);

    @GetExchange(value = "/eazybank/cards/api/fetch", accept = APPLICATION_JSON)
    Mono<ResponseEntity<CardsDto>> fetchCardsDetails(@RequestParam("mobileNumber") String mobileNumber);

}
