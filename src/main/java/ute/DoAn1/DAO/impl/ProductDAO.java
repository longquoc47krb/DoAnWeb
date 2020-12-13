package ute.DoAn1.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ute.DoAn1.DAO.IProductDAO;
import ute.DoAn1.mapper.ProductMapper;
import ute.DoAn1.model.ProductModel;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {

	int pageSize = 6;
	private int noOfRecords;
	@Override
	public List<ProductModel> findAll() {
		String sql = "SELECT * FROM product;";
		return query(sql, new ProductMapper());
	}

	@Override
	public ProductModel totalProduct() {
		String sql = "SELECT count(*) FROM product;";
		List<ProductModel> totalProduct = query(sql.toString(), new ProductMapper());
		return totalProduct.isEmpty() ? null : totalProduct.get(0);
	}
	public int getNumberPage() {
		String sql = "SELECT count(*) FROM product;";
		try {
			Connection connection = new ProductDAO().getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int totalProduct = rs.getInt(1);
				int countPage = 0;
				countPage = totalProduct / pageSize;
				if(countPage % pageSize != 0) {
					countPage++;
				}
				return countPage;
				
			}
		} catch(Exception ex) {
			
		}
		return 0;
		
	}

	public List<ProductModel> getPaging(int index){
		String sql = "SELECT * FROM product\n"
				+ "ORDER BY product.id\n"
				+ "OFFSET ? ROWS \n"
				+ "FETCH FIRST "+pageSize+ " ROWS ONLY;";
		
		ProductModel product = new ProductModel();

		List<ProductModel> list = new ArrayList<>();
		try {
			Connection connection = new ProductDAO().getConnection();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,(index-1)*pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				     product = new ProductModel();
					 product.setId(rs.getLong(1));
					 product.setName(rs.getString(2));
					 product.setPrice(rs.getInt(3));
					 product.setContent(rs.getString(4));
					 product.setImage(rs.getString(5));
					 product.setCategorie_id(rs.getLong(6));
					 list.add(product);
				
			}
			return list;
		} 
		catch(Exception ex) 
		{
			
		}
		return null;
		
	}
	
}
