package com.eazybytes.customer.query.handler;

import com.eazybytes.customer.dto.CustomerDto;
import com.eazybytes.customer.query.FindCustomerQuery;
import com.eazybytes.customer.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class CustomerQueryHandler {
    private final ICustomerService customerService;

    @QueryHandler
    public CustomerDto findCustomer(FindCustomerQuery findCustomerQuery) {
        return customerService.fetchCustomer(findCustomerQuery.getMobileNumber());
    }
}
