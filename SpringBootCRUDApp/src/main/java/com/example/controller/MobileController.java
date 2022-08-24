package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MobileDto;
import com.example.entity.Mobile;
import com.example.service.MobileService;

@RestController
public class MobileController {

	@Autowired
	private MobileService mobileService;

	@GetMapping("/mobiles")
	public ResponseEntity<List<MobileDto>> getAllMobiles() {
		return new ResponseEntity<List<MobileDto>>(mobileService.getAllMobiles(), HttpStatus.OK);

	}

	@GetMapping("/mobiles/{mobileId}")
	public ResponseEntity<MobileDto> getMobileId(@PathVariable Long mobileId) {
		return new ResponseEntity<MobileDto>(mobileService.getMobileById(mobileId), HttpStatus.OK);

	}

	@PostMapping("/mobiles")
	public ResponseEntity<Mobile> addMobile(@RequestBody MobileDto mobileDto) {
		return new ResponseEntity<Mobile>(mobileService.addMobile(mobileDto), HttpStatus.CREATED);

	}

	@PutMapping("/mobiles/{mobileId}")
	public ResponseEntity<Mobile> updateMobileById(@PathVariable Long mobileId, @RequestBody MobileDto mobileDto) {
		return new ResponseEntity<Mobile>(mobileService.updateMobileById(mobileId, mobileDto), HttpStatus.OK);

	}

	@DeleteMapping("/mobiles/{mobileId}")
	public ResponseEntity<String> deleteMobileById(@PathVariable Long mobileId) {
		return new ResponseEntity<String>(mobileService.deleteMobileById(mobileId), HttpStatus.OK);

	}

}
