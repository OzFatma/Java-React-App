package kodlamaio.northwind.core.utilities.results;

/*super type, neden interface değil? yapılabilir fakat java dünyasında kullanım tercihi bu yönde
 ayrıca result sınıfı tek başına anlamlı ve bizim için bir geçiş sınıfı görevi de görüyor(super type)*/
public class Result {
	private boolean success;
	private String message;

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}

	public boolean isSuccess() {
		return this.success;
	}

	public String getMessage() {
		return this.message;
	}

}
