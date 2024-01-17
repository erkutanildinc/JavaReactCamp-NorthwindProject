package kodlamaio.northwind.dataaccess.abstracts;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDTO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductDao extends JpaRepository<Product,Integer> {
	
    Product getByProductName(String productName);
   
    Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    
    List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
    
    List<Product> getByCategory_CategoryIdIn(List<Integer> categories);
    
    List<Product> getByProductNameContains(String productName);
    
    List<Product> getByProductNameStartsWith(String productName);
    
    @Query("From Product where productName=:productName and category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName,int categoryId);
    
    @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDTO(p.id,p.productName,c.categoryName) "
    		+ "From Category c Inner Join c.products p")
    List<ProductWithCategoryDTO> getProductWithCategoryDetails();
    
    
}