package io.wisoft.foodie.project.account.web.dto;


import io.wisoft.foodie.project.account.service.AccountService;
import io.wisoft.foodie.project.account.web.dto.res.FindAccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(final AccountService accountService){

        this.accountService = accountService;

    }

    @GetMapping("{/id}")
    public ResponseEntity<FindAccountResponse> findAccountById(@PathVariable("id") @Valid final Long accountId){
        return ResponseEntity.ok(
                accountService.findAccountById(accountId)
        );
    }


}
