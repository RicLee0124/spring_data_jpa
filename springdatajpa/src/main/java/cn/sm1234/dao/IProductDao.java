package cn.sm1234.dao;

import cn.sm1234.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductDao extends JpaRepository<Product, Integer>{
}
