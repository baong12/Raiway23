package com.vti.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDTO;
import com.vti.entity.Account;
import com.vti.form.AccountFilterForm;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private IAccountService service;

	@GetMapping()
	public Page<AccountDTO> getAllAccounts(
			Pageable pageable, 
			@RequestParam(value = "search", required = false) String search,
			AccountFilterForm filterForm) {
		Page<Account> entitiePages = service.getAllAccounts(pageable, search, filterForm);
		List<AccountDTO> dtos = modelMapper.map(
				entitiePages.getContent(),
				new TypeToken<List<AccountDTO>>() {}.getType());
		for (AccountDTO dto : dtos) {
			dto.add(linkTo(methodOn(AccountController.class).getAccountByID(dto.getId())).withSelfRel());
		}
		Page<AccountDTO> dtoPages = new PageImpl<>(dtos, pageable, entitiePages.getTotalElements());
		return dtoPages;
	}

	@GetMapping("/{id}")
	public AccountDTO getAccountByID(@PathVariable(name = "id") Integer id) {
		Account entity = service.getAccountByID(id);
		AccountDTO dto = modelMapper.map(entity, AccountDTO.class);
		dto.add(linkTo(methodOn(AccountController.class).getAccountByID(id)).withSelfRel());
		return dto;
	}
}
