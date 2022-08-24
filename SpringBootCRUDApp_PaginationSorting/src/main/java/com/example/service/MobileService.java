package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.dto.MobileDto;
import com.example.entity.Mobile;
import com.example.exception.MobileNotFoundException;

public interface MobileService {

	public Page<MobileDto> getAllMobiles(Pageable page) throws MobileNotFoundException;

	public MobileDto getMobileById(Long id) throws MobileNotFoundException;

	public Mobile addMobile(MobileDto mobileDto) throws MobileNotFoundException;

	public Mobile updateMobileById(Long id, MobileDto mobileDto) throws MobileNotFoundException;

	public String deleteMobileById(long id) throws MobileNotFoundException;

}
