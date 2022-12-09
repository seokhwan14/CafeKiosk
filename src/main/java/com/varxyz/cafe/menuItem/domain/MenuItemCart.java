package com.varxyz.cafe.menuItem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuItemCart {
	private String menuItemCart;
	
	@Override
	public String toString() {
		return menuItemCart;
	}
}
