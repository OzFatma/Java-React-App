package kodlamaio.northwind.data.abstracts;

import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product getByProductName(String productName);

    Product getByProductNameAndCategory(String productName, int categoryId);

    List<Product> getByProductNameOrCategory(String productName, int categoryId);

    List<Product> getByCategoryIn(List<Integer> categories);

    List<Product> getByProductNameContains(String productName);

    List<Product> getByProductNameStartsWith(String productName);

    //Burada isimlendirme kuralları dışına çıkıyoruz @Query örneği için
    //From ile select * from kastedilmiş, kısaca from yazabiliriz.
    @Query("From Product Where productName=:productName And category.categoryId=:categoryId")
    List<Product> getByNameAndCategory(String productName, int categoryId);

    //new i unutma, dosyanın yolunu eklemelisin
    //sql sorgusu:Select p.id, p.productName, c.categoryName From categories c Inner Join products p
    //on c.categori_id=p.category_id
    @Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto" +
            "(p.id, p.productName, c.categoryName)" +
            "From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

}
//Jpa metot ismindeki get/find kelimelerini algılar ve otomatik sorgu cümleciklerini oluşturur.
//Metot isimlerindeki and,or,in contains startswith vb. kelimeleri de isimlendirme kurallarına dahildir.
//getByProductNameOrCategoryId list olarak tanımladık çünkü birden fazla türde tip veri gelebilir or sebebi ile.
//@Query .net teki Linq sorguları gibi çalışır fakat veritabanı nesneleri üzerinde değil sorgularını entityler
// üzerinden atar!!!!! Product entitisinin productName değişkenine productName parametresi =: ile atanmıştır.