package com.varxyz.cafe.menuCategory.rowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.varxyz.cafe.menuCategory.domain.MenuCategory;

public class MenuCategoryMapper implements RowMapper<MenuCategory>{

	@Override
	public MenuCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MenuCategory category = new MenuCategory();
//		category.setCid(rs.getLong("cid"));
		category.setCategoryName(rs.getString("menuName"));
		return category;
	}
	
}
