package br.com.microsservice.productmanager.app.repository;

import br.com.microsservice.productmanager.app.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
