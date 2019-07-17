package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.vo.JsonVo;
import com.example.demo.vo.XmlVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class APIController {
	
	//xml return
	@GetMapping(value = "/xml", produces = "application/xml")
	public XmlVo getXmlData() {
		return new XmlVo();
	}
	
	//json return
	@GetMapping("/json")
	public JsonVo getJsonData() {
		return new JsonVo();
	}
	
	//check header
	@GetMapping("/entity")
	public ResponseEntity<String> checkHeader(@RequestParam("name") String name, HttpServletRequest httpServletRequest) {
		if(!httpServletRequest.getHeader("Authentication").equals("LEMON")) {
			return new ResponseEntity<>("permission denied", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>("welcome!", HttpStatus.OK);
	}
	
	//post 
	@PostMapping("/post")
	public ResponseEntity<String> postForEntity(String contents){
		log.info("contents: {}", contents);
		return new ResponseEntity<>("Success Response", HttpStatus.OK);
	}
}
