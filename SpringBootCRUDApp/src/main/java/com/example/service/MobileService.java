package com.example.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.dto.MobileDto;
import com.example.entity.Mobile;
import com.example.exception.MobileNotFoundException;

public interface MobileService {

	public List<MobileDto> getAllMobiles() throws MobileNotFoundException;

	public MobileDto getMobileById(Long id) throws MobileNotFoundException;

	public Mobile addMobile(MobileDto mobileDto) throws MobileNotFoundException;

	public Mobile updateMobileById(Long id, MobileDto mobileDto) throws MobileNotFoundException;

	public String deleteMobileById(long id) throws MobileNotFoundException;

}
