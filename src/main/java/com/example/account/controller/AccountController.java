package com.example.account.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.account.dto.CreateAccount;
import com.example.account.dto.DeleteAccount;
import com.example.account.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AccountController {
	private final AccountService accountService;
	
	@PostMapping("/account")
	public CreateAccount.Response createAccount(
			@RequestBody @Valid CreateAccount.Request request
	) {
		return CreateAccount.Response.from(
				accountService.createAccount(
						request.getUserId(), request.getInitBalance()));
	}
	
	@DeleteMapping("/account")
	public DeleteAccount.Response deleteAccount(
			@RequestBody @Valid DeleteAccount.Request request
	) {
		return DeleteAccount.Response.from(
				accountService.deleteAccount(
						request.getUserId(), request.getAccountNumber()));
	}
}
