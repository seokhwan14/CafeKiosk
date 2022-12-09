package com.varxyz.cafe.menuCategory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuCategory {
	/**
	 * 
	 */
	private long cid;				//카테고리별 고유번호
	private String categoryName;		//카테고리의 각 명칭
	
	
//	public MenuCategory(String categoryName) {
//		super();
//		this.categoryName = categoryName;
//	}
	
	public MenuCategory() {
		super();
	}
	
//	private String coffee; //카페인 위주의 음료  	'C'
//	private String dessert; //디저트류				'D'
//	private String eventMenu; //계절별 이벤트 메뉴	'E'
//	private String juice; //과일쥬스류				'J'
//	private String smoothy; //스무디류				'S'
//	private String ade; //에이드류					'A'
	
}
