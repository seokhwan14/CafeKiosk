package com.varxyz.cafe.menuItem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.varxyz.cafe.menuItem.domain.MenuItem;

public class MenuItemDao {
	private JdbcTemplate jdbcTemplate;
	
	public MenuItemDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	MenuItem menuItem;
	
	
	public void addMenu(MenuItem menuItem) {
		String sql = "INSERT INTO MenuItem (menuCategoryName, menuItemName, price, menuImage, menuDesc)"
				+ " VALUES (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, menuItem.getMenuCategoryName(), menuItem.getMenuItemName(),
				menuItem.getPrice(),
				menuItem.getMenuImage(), menuItem.getMenuDesc());
	}
	
	
	public void deleteMenu(MenuItem menuItem) {
		String sql = "DELETE FROM MenuItem WHERE menuItemName=?";
		jdbcTemplate.update(sql, menuItem.getMenuItemName());
	}
	
	
	public List<MenuItem> findMenuByCategory(MenuItem menuItem) {
		String sql = "SELECT * FROM MenuItem WHERE menuCategoryName=?";
		return jdbcTemplate.query(sql, new RowMapper<MenuItem>() {
			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem(rs.getString("menuCategoryName"),
						rs.getString("menuItemName"),rs.getDouble("price"),rs.getString("menuImage")
						,rs.getString("menuDesc"));
				return menuItem;
			}
			
		}, menuItem.getMenuCategoryName());
	}
	
	
	public List<MenuItem> findByMenuName(MenuItem menuItem) {
		String sql = "SELECT * FROM MenuItem WHERE menuItemName=?";
		return jdbcTemplate.query(sql, new RowMapper<MenuItem>() {
			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem(rs.getString("menuCategoryName"),
						rs.getString("menuItemName"),rs.getDouble("price"),rs.getString("menuImage")
						,rs.getString("menuDesc"));
				return menuItem;
			}
			
		}, menuItem.getMenuItemName());
	}
}
