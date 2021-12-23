package kodlamaio.northwind.entities.concretes;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //sınıfın entity katmanında yer aldığını springe bildirildi.
@Data //lombok paketi ile getter setterlar otomatik oluşturuldu.
@Table(name = "products") //veritabanındaki tablo ile eşleşme sağlandı.
@AllArgsConstructor //Lombok constructor ı oluşturdu
@NoArgsConstructor //Lombok constructor ı oluşturdu boş ctor
//kendi ctorlarımızı oluşturup ekleyebiliriz.
public class Product {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK otomatik artan
    @Column(name = "product_id")
    private int id;

//    @Column(name = "category_id")
//    private int categoryId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "units_in_stock")
    private short unitsInStock;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    //C# ın aksine categoryId yi yazmaya gerek yok navigation property için private Category yeterli
}

