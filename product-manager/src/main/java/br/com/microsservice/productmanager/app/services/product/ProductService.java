package br.com.microsservice.productmanager.app.services.product;

import br.com.microsservice.productmanager.app.dto.ProductDTO;
import br.com.microsservice.productmanager.app.entity.Product;
import br.com.microsservice.productmanager.app.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    private List<ProductDTO> toDTOList(List<Product> productList) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(Product product : productList) {
            productDTOList.add(ProductDTO.toDto(product));
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> create(Product product) {
        this.productRepository.save(product);
        return read();
    }

    @Override
    public List<ProductDTO> read() {
        List<Product> result = this.productRepository.findAll();
        return toDTOList(result);
    }

    @Override
    public List<ProductDTO> readWithPagination(int page, int size) {
        Page<Product> productsPage = this.productRepository.findAll(PageRequest.of(page, size));
        List<Product> productList = productsPage.stream().toList();
        return toDTOList(productList);
    }

    @Override
    public Optional<ProductDTO> readById(Long id) {
        Optional<Product> searchedProduct = this.productRepository.findById(id);
        return searchedProduct.map(ProductDTO::toDto);
    }

    @Override
    public List<ProductDTO> update(Product product) {
        this.productRepository.saveAndFlush(product);
        return read();
    }

    @Override
    public List<ProductDTO> delete(Long id) {
        this.productRepository.deleteById(id);
        return read();
    }
}
