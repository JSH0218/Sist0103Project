package product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import product.dto.ProductDto;
import product.mapper.ProductMapper;

@Service
@AllArgsConstructor
public class ProductService {
	private final ProductMapper productMapper;
	
	public List<ProductDto> selectProduct(){
		return productMapper.selectProduct();
	}
	
	public ProductDto selectOneProduct(int pro_num) {
		return productMapper.selectOneProduct(pro_num);
	}
	
	public void insertProduct(ProductDto dto) {
		productMapper.insertProduct(dto);
	}
}
