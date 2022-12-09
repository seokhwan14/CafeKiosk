package com.varxyz.cafe.menuCategory.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuCategoryProvider {
	private String categoryHost;

	@Override
	public String toString() {
		return categoryHost;
	}
	
	
}
