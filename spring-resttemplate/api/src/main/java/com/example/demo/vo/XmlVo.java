package com.example.demo.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;

@Getter
@XmlRootElement
public class XmlVo {
	
	@XmlElement
	private final String type = "XML";
	
	@XmlElement 
	private final String message = "This is Xml Data!!";

}
