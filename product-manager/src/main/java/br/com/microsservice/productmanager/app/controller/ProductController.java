package br.com.microsservice.productmanager.app.controller;

import br.com.microsservice.productmanager.app.dto.ProductDTO;
import br.com.microsservice.productmanager.app.model.Product;
import br.com.microsservice.productmanager.app.services.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> get() {
        return ResponseEntity.ok().body(this.productService.read());
    }

    @GetMapping("/{id}")
    public Optional<ProductDTO> getById(@PathVariable Long id) {
        return this.productService.readById(id);
    }

    @PostMapping
    public ResponseEntity<List<ProductDTO>> post(@RequestBody ProductDTO productDTO) {
        this.productService.create(productDTO.toProduct());
        return new ResponseEntity<>(this.productService.read(), HttpStatus.CREATED);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<List<ProductDTO>> put(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        Product productToEdit = productDTO.toProduct();
        productToEdit.setId(id);
        this.productService.update(productToEdit);
        return new ResponseEntity<>(this.productService.read(), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<ProductDTO>> delete(@PathVariable Long id) {
        return new ResponseEntity<>(this.productService.delete(id), HttpStatus.NO_CONTENT);
    }
}

