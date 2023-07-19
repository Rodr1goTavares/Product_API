package br.com.microsservice.productmanager;

import br.com.microsservice.productmanager.app.model.Product;
import br.com.microsservice.productmanager.app.services.product.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class ProductManagerApplicationTests {

	private final ProductService productService;

	ProductManagerApplicationTests(ProductService productService) {
		this.productService = productService;
	}

	@Test
	void testCreateProductSuccess() {
		Product testProduct = new Product(
				"Test product",
				"Test product for test the application",
				299.90,
				true
		);
	}
}
