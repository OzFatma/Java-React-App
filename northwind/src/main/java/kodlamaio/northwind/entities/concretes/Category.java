package kodlamaio.northwind.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"}) //lazyloading yap
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = ("category_name"))
    private String categoryName;

    @OneToMany(mappedBy = "category") //mappedBy ile many nin one ile ilişkisini tanımladık
    private List<Product> products;
}
