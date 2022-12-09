package com.varxyz.cafe.cart.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CartItem {
	/**
	 * 장바구니 기능을 위한 도메인, 장바구니 기능은 담을때마다
	 * 하나하나 DB에 저장 후 최종 결제 후 해당 DB내역을 삭제하는 방향으로 하면 될것 같다
	 */
	private String menuItemName;		// innerjoin을 위해 포린키로 받아옴 - totalPrice 는 count * price
	private double countMenu;			// 주문을 위한 개수 설정
	private String tempType;			// 차가운 음료(C - Cold), 따듯한 음료(H - Hot)
	private String size;				// 음료의 사이즈값, small, medium, large ...
	
	@Override
	public String toString() {
		return "CartItem [menuItemName=" + menuItemName + ", countMenu=" + countMenu + ", tempType=" + tempType
				+ ", size=" + size + "]";
	}
	
	public CartItem( ) {
		super();
	}
	
	
	
}



//private String orderType;				// 포장하기(T - togo), 매장취식(F - forHere)
//private String payType;				// 결제 방법, Card, Cash ...