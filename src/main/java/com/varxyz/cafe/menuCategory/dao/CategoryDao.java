package com.varxyz.cafe.menuCategory.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.varxyz.cafe.menuCategory.domain.MenuCategory;
import com.varxyz.cafe.menuCategory.domain.MenuCategoryProvider;
import com.varxyz.cafe.menuCategory.rowMap.MenuCategoryMapper;

@Component
public class CategoryDao {
	private JdbcTemplate jdbcTemplate;
	
	public CategoryDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	MenuCategory category;
	
	public List<MenuCategory> allCategory(MenuCategory category) {
		String sql = "SELECT menuName FROM MenuCategory";
		return jdbcTemplate.query(sql, new MenuCategoryMapper());
	}
	
	public List<MenuCategoryProvider> findCategoryName() {
		String sql = "SELECT menuName FROM MenuCategory";
		return jdbcTemplate.query(sql, new RowMapper<MenuCategoryProvider>() {

			@Override
			public MenuCategoryProvider mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuCategoryProvider categoryProvider = new MenuCategoryProvider(rs.getString("menuName"));
				
				return categoryProvider;
			}
		});
	}
	
	
	/**
	 * 카테고리에 메뉴 이름을 추가하는 기능
	 * @param category
	 */
	public void addCategory(MenuCategory category) {
		String sql = "INSERT INTO MenuCategory (menuName) VALUE (?)";
		jdbcTemplate.update(sql, category.getCategoryName());
	}
	
	/**
	 * 카테고리에 메뉴 이름을 삭제하는 기능 - 해당 카테고리에 메뉴가 없어야 가능
	 */
	public void deleteCategory(MenuCategory category) {
		String sql = "DELETE FROM MenuCategory WHERE menuName=?";
		
		jdbcTemplate.update(sql, category.getCategoryName());
	}
}
