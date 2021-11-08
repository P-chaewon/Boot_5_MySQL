package com.cw.b5.product;

import lombok.Data;

@Data
public class ProductVO {
	
	private Integer num;
	private String name;
	private Integer price;
	private String information;
	private ProductFilesVO productFilesVO;

}
