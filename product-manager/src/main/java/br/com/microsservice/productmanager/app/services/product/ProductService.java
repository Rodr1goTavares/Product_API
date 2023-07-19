package br.com.microsservice.productmanager.app.services.product;

import br.com.microsservice.productmanager.app.dto.ProductDTO;
import br.com.microsservice.productmanager.app.entity.Product;
import br.com.microsservice.productmanager.app.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> create(Product product) {
        this.productRepository.save(product);
        return read();
    }

    @Override
    public List<ProductDTO> read() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product : this.productRepository.findAll()) {
            productDTOList.add(ProductDTO.toDto(product));
        }
        return productDTOList;
    }

    @Override
    public Optional<ProductDTO> readById(Long id) {
        Optional<Product> searchedProduct = this.productRepository.findById(id);
        return searchedProduct.map(ProductDTO::toDto);
    }

    @Override
    public List<ProductDTO> update(Product product) {
        this.productRepository.save(product);
        return read();
    }

    @Override
    public List<ProductDTO> delete(Long id) {
        this.productRepository.deleteById(id);
        return read();
    }
}
