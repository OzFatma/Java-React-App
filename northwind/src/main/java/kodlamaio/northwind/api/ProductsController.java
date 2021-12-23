package kodlamaio.northwind.api;

import java.util.List;

import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.web.bind.annotation.*;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;

@RestController // bu sınıf bir controllerdır.
@RequestMapping("/api/products/")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping("get_all")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody Product product) {
        return this.productService.add(product);
    }

    @GetMapping("get_by_product_name")
    public DataResult<Product> getByProductName(@RequestParam String productName) {
        return this.productService.getByProductName(productName);
    }

    @GetMapping("get_all_by_page")
    public DataResult<List<Product>> getAllByPage(int pageNo, int pageSize) {
        return this.productService.getAllByPage(pageNo, pageSize);
    }

    @GetMapping("get_product_with_category_details")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return this.productService.getProductWithCategoryDetails();
    }

    @GetMapping("get_all_sorted")
    public DataResult<List<Product>> getAllSorted() {
        return this.productService.getAllSorted();
    }

}
