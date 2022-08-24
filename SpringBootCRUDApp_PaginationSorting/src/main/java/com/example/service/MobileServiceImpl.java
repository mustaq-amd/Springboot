package com.example.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.MobileDto;
import com.example.entity.Mobile;
import com.example.exception.MobileNotFoundException;
import com.example.repository.MobileRepository;

@Service
@Transactional
public class MobileServiceImpl implements MobileService {

	@Autowired
	private MobileRepository mobileRepository;

	@Override
	public Page<MobileDto> getAllMobiles(Pageable page) throws MobileNotFoundException {

		List<MobileDto> listOfMobiles = new ArrayList<>();

		Page<Mobile> mobiles = mobileRepository.findAll(page);

		mobiles.forEach((mobile) -> {

			MobileDto dto = new MobileDto();
			dto.setId(mobile.getId());
			dto.setName(mobile.getName());
			dto.setBrand(mobile.getBrand());
			dto.setPrice(mobile.getPrice());

			listOfMobiles.add(dto);
		});

//		if (listOfMobiles.isEmpty()) {
//			throw new MobileNotFoundException("No Existing Mobiles....");
//		}
		Page<MobileDto> pages = new PageImpl<MobileDto>(listOfMobiles, page, listOfMobiles.size());

		return pages;
	}

	@Override
	public MobileDto getMobileById(Long id) throws MobileNotFoundException {

		Mobile mobile = mobileRepository.findById(id).orElseThrow(() -> {
			throw new MobileNotFoundException("Mobile Not Exist with id : " + id);
		});

		MobileDto dto = new MobileDto();

		BeanUtils.copyProperties(mobile, dto);

		return dto;
	}

	@Override
	public Mobile addMobile(MobileDto mobileDto) throws MobileNotFoundException {

		Mobile mobile = new Mobile();
		BeanUtils.copyProperties(mobileDto, mobile);

		mobileRepository.save(mobile);

		return mobile;
	}

	@Override
	public Mobile updateMobileById(Long id, MobileDto mobileDto) throws MobileNotFoundException {

		MobileDto existingMobile = getMobileById(id);

		existingMobile.setName(mobileDto.getName() != null ? mobileDto.getName() : existingMobile.getName());
		existingMobile.setBrand(mobileDto.getBrand() != null ? mobileDto.getBrand() : existingMobile.getBrand());
		existingMobile.setPrice(mobileDto.getPrice() != null ? mobileDto.getPrice() : existingMobile.getPrice());

		Mobile updateMobile = new Mobile();
		BeanUtils.copyProperties(existingMobile, updateMobile);
		mobileRepository.save(updateMobile);

		return updateMobile;

	}

	@Override
	public String deleteMobileById(long id) throws MobileNotFoundException {

		MobileDto existingMobile = getMobileById(id);
		mobileRepository.deleteById(id);
		
		return "Mobile deleted successfuly.......";

	}

}
