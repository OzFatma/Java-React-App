package kodlamaio.northwind.business.abstracts;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Category;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.Query;

public interface ProductService {
    DataResult<List<Product>> getAll();

    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

    //bu sorguları yalnızca service katmanında yazdık , data katmanında imzaları yok. productdao daki finall u
    // kullanıyoruz.
    DataResult<List<Product>> getAllByPage(int pageNo, int pageSize);
    DataResult<List<Product>> getAllSorted();


}
