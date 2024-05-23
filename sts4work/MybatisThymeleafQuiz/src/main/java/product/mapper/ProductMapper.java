package product.mapper;

import java.util.List;

import product.dto.ProductDto;

public interface ProductMapper {
	public List<ProductDto> selectProduct();
	
	public ProductDto selectOneProduct(int pro_num);
	
	public void insertProduct(ProductDto dto);
}
