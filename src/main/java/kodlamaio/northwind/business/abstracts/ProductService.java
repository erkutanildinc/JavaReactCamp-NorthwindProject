package kodlamaio.northwind.business.abstracts;

import java.util.List;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDTO;

public interface ProductService {
	
	DataResult<List<Product>> getAll();
	DataResult<List<Product>> getAllSorted();
	DataResult<List<Product>> getAll(int pageNo,int pageSize);
	Result add(Product product);
	
	
	DataResult<Product> getByProductName(String productName);	   
    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName,int categoryId);
    DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName,int categoryId);   
    DataResult<List<Product>> getByCategory_CategoryIdIn(List<Integer> categories);    
    DataResult<List<Product>> getByProductNameContains(String productName);  
    DataResult<List<Product>> getByProductNameStartsWith(String productName);   
    DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
    
    DataResult<List<ProductWithCategoryDTO>> getProductWithCategoryDetails();
    
}
