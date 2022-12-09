package com.varxyz.cafe.cart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.varxyz.cafe.cart.domain.CartItem;
import com.varxyz.cafe.menuItem.domain.MenuItem;

@Component
public class CartDao {
	public JdbcTemplate jdbcTemplate;
	
	public CartDao(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}
	
	/**
	 * 새로운 장바구니 생성  // 안씀
	 */
	public void createCart() {
		String sql = "CREATE TABLE Cart ( "
				+ "	menuItemName 	VARCHAR(20) 	NOT NULL, "
//				+ " countMenu		DOUBLE		 	DEFAULT '0.0', "
				+ "	tempType		CHAR			NOT NULL	DEFAULT 'C', "
				+ "	size			VARCHAR(10)		NOT NULL	DEFAULT	'small', "
				+ "	CONSTRAINT Cart_MenuItem_FK FOREIGN KEY (menuItemName) "
				+ " REFERENCES MenuItem(menuItemName) ) ";
		jdbcTemplate.execute(sql);
	}
	
	/**
	 * 장바구니에 새로운 품목을 넣는 기능
	 * @param cartItem
	 */
	public void addToCart(CartItem cartItem) {
		String sql = "INSERT INTO Cart (menuItemName, countMenu, tempType, size)"
				+ " VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, cartItem.getMenuItemName(), cartItem.getCountMenu(),
				cartItem.getTempType(), cartItem.getSize());
	}
	
	/**
	 * 장바구니에서 품목을 제거하는 기능
	 * @param cartItem
	 */
	public void deleteFromCart(CartItem cartItem) {
		String sql = "DELETE FROM Cart WHERE menuItemName=?";
		jdbcTemplate.update(sql, cartItem.getMenuItemName());
	}
	
	/**
	 * 장바구니에서 전체 품목을 제거하는 기능
	 * @param cartItem
	 */
	public void deleteAllFromCart(CartItem cartItem) {
		String sql = "DELETE FROM Cart";
		jdbcTemplate.update(sql);
	}
	
	/**
	 * 장바구니에 들어있는 메뉴의 가격을 innerjoin을 통해 menuItem에서 가져오기 위한 기능
	 * @param cartItem
	 * @return
	 */
	public MenuItem checkPrice(CartItem cartItem) {
		String sql = "SELECT m.price FROM MenuItem m INNER JOIN"
				+ " CartItem c ON m.menuItemName = c.menuItemName WHERE c.menuItemName=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<MenuItem>() {
			@Override
			public MenuItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				MenuItem menuItem = new MenuItem(rs.getString("menuCategoryName"),
						rs.getString("menuItemName"),rs.getDouble("price"),rs.getString("menuImage")
						,rs.getString("menuDesc"));
				return menuItem;
			}
		}, cartItem.getMenuItemName());
	}
	
	/**
	 * 장바구니에 들어있는 메뉴의 갯수를 확인하기 위한 기능
	 * @param cartItem
	 * @return
	 */
	public CartItem checkCount(CartItem cartItem) {
		String sql = "SELECT countMenu FROM Cart WHERE menuItemName=?";
		return jdbcTemplate.queryForObject(sql, new RowMapper<CartItem>() {
			@Override
			public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				CartItem cartItem = new CartItem(rs.getString("menuItemName"), 
						rs.getDouble("countMenu"), rs.getString("tempType"), rs.getString("size"));
				return cartItem;
			}
		}, cartItem.getMenuItemName());
	}
	
	/**
	 * 장바구니에 들어있는 전체 메뉴를 보여주기 위한 기능
	 * @param cartItem
	 * @return
	 */
	public List<CartItem> showAllCart() {
		String sql = "SELECT * FROM Cart";
		return jdbcTemplate.query(sql, new RowMapper<CartItem>() {
			@Override
			public CartItem mapRow(ResultSet rs, int rowNum) throws SQLException {
				CartItem cartItem = new CartItem(rs.getString("menuItemName"),
						rs.getDouble("countMenu"),
						rs.getString("tempType"), rs.getString("size"));
				return cartItem;
			}
		});
	}
	
	/**
	 * 최종 결제 후 카트 테이블 전체가 삭제되도록 하는 기능
	 */
	public void deleteCart() {
		String sql = "DROP TABLE Cart";
		jdbcTemplate.update(sql);
	}
	
	
	
	
	
	
	
	
	
	
}
