package com.varxyz.cafe.menuItem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MenuItem {
	
	public MenuItem(String menuCategoryName) {
		super();
		this.menuCategoryName = menuCategoryName;
	}
	
	public MenuItem() {
		super();
	}
	
	/**
	 * menuItem들의 공통 속성들
	 */
	private String menuCategoryName;	//해당 메뉴가 속해있는 카테고리명(Category테이블과 join)
	private String menuItemName;		//해당 메뉴의 명칭
	private double price;			//해당 메뉴의 가격
	private String menuImage;		//해당 메뉴의 대표 이미지 (url)
	private String menuDesc;		//해당 메뉴에 대한 간략한 설명(달고 시원한 수박쥬스 이런식으로?)
	
	
	/**
	 * 아래의 내용들은 추후 구매관련하여 구현해야함, 새로 만들어야 하지 않을까..? purchase
	 */
	
	
//	private double count;			//해당 메뉴를 시킨 갯수
//	private String pointSavingNum;	//해당 메뉴를 시킬때 포인트 적립할 번호
//	private String orderType;	//매장에서의 취식인지 포장인지에 대한 Type // T(takeout), S(shop)
//	private String payType;		//결제하는 방식에 따른 Type // C(card), B(bill), S(savingMoney)
}
