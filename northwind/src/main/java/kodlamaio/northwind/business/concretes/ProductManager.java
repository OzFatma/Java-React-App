package kodlamaio.northwind.business.concretes;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.data.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service //bir service classı olduğunu belirttik
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    @Autowired // projeyi tara ve ilgili nesneyi enjekte et
    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccessDataResult<List<Product>>
                (this.productDao.findAll(), "Products are listed.");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Product is added.");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductName(productName),
                        "Products are sorted by name.");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<Product>
                (this.productDao.getByProductNameAndCategory(productName, categoryId),
                        "Products are sorted by name and category.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameOrCategory(productName, categoryId),
                        "Products are sorted by name or category.");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByCategoryIn(categories),
                        "Products are sorted by same categories.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameContains(productName),
                        "Products are listed.");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByProductNameStartsWith(productName),
                        "Products are listed.");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>
                (this.productDao.getByNameAndCategory(productName, categoryId),
                        "Products are listed.");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(
                this.productDao.getProductWithCategoryDetails(), "Products are listed."
        );
    }

    //bir sayfada kaç ürün geleceğini ve kaç sayamız olacağını ayarlayacağız.
    //springframework ün Pageable sınıfından faydalanıyoruz. burada pagerequest static bir method parametrelerimizi
    // geçiren ve pageable nesnemizi oluşturan.
    // getcontent ise pageable nesnesini list nesnesinde okumamızı sağlıyor.
    @Override
    public DataResult<List<Product>> getAllByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<Product>>(
                this.productDao.findAll(pageable).getContent(), "Başarılı."
        );
    }

    //import sınıflar önemli data.domain olmalı
    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(
                this.productDao.findAll(sort), "Başarılı."
        );
    }
}
