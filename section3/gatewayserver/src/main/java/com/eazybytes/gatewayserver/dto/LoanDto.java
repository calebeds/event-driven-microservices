package com.eazybytes.gatewayserver.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class LoanDto {
    @NotEmpty(message = "LoanNumber cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{12})", message = "Loan Number must be 12 digits")
    private String loanNumber;

    @NotEmpty(message = "Loan Type cannot be null or empty")
    private String loanType;

    @Positive(message = "Total Loan should be greater than zero")
    private int totaLoan;

    @PositiveOrZero(message = "Total Amount Paid should be equal or greater than zero")
    private int amountPaid;

    @PositiveOrZero(message = "Total Outstanding amount used should be equal or greater than zero")
    private int outstandingAmount;

    private boolean activeSw;
}
