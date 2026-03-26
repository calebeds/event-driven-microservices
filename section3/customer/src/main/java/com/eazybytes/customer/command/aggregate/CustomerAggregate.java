package com.eazybytes.customer.command.aggregate;

import com.eazybytes.customer.command.CreateCustomerCommand;
import com.eazybytes.customer.command.event.CustomerCreatedEvent;
import com.eazybytes.customer.entity.Customer;
import com.eazybytes.customer.exception.CustomerAlreadyExistsException;
import com.eazybytes.customer.repository.CustomerRepository;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.commandhandling.CommandHandler;

import org.axonframework.spring.stereotype.Aggregate;

import org.springframework.beans.BeanUtils;

import java.util.Optional;

@Aggregate
public class CustomerAggregate {

    @AggregateIdentifier
    private String customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private boolean activeSw;

    public CustomerAggregate() {

    }

    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand createCustomerCommand, CustomerRepository customerRepository) {
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumberAndActiveSw(createCustomerCommand.getMobileNumber(), true);
        if(optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given mobileNumber "
                    + createCustomerCommand.getMobileNumber());
        }

        CustomerCreatedEvent customerCreatedEvent = new CustomerCreatedEvent();
        BeanUtils.copyProperties(createCustomerCommand, customerCreatedEvent);

        AggregateLifecycle.apply(customerCreatedEvent);
    }
}
