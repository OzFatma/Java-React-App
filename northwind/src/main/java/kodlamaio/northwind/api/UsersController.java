package kodlamaio.northwind.api;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users/")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        super();
        this.userService = userService;
    }

    //@Valid bu nesneyi validasyondan geçir demek
    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.add(user));
    }

    //global bir exception metodu yazdık. tek bir try catch ile tüm validation hatalarını yakalamayı bekliyorum. tek
    // tek tüm metodlara yazmaktansa metodları tek bir hata yakalama metodundan geçireceğiz.
    //.class c# daki typeof metoduna karşılık gelmekte..
    //type olarak Object verdik tüm sınıflar objeden türediği ve birden fazla tipte exception alacağımız için dönüş
    // tibi object.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        //Map, C# Dictionary ye dnk gelir. ilk parametre valide edeceğimiz nesne ikinci parametre hata mesajı tipi
        //Map bir interface new lyebilmek için implement ettiği hashmap classını kullandık.
        //gelen hatalarımız MethodArgumentNotValidException tipinde geçilecek bu sebebple parametremiz de bu tipte
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation error.");
        return errors;
    }

    @GetMapping("find_by_email")
    DataResult<User> findByEmail(@RequestParam String email) {
        return this.userService.findByEmail(email);
    }
}
