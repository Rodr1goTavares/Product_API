package br.com.microsservice.productmanager.app.services.product;

import br.com.microsservice.productmanager.app.dto.ProductDTO;
import br.com.microsservice.productmanager.app.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface {

    List<ProductDTO> create(Product product);

    List<ProductDTO> read();

    List<ProductDTO> readWithPagination(int page, int size);

    Optional<ProductDTO> readById(Long id);

    List<ProductDTO> update(Product product);

    List<ProductDTO> delete(Long id);
}
