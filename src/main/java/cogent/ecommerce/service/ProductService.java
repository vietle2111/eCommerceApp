package cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cogent.ecommerce.dao.ProductRepository;
import cogent.ecommerce.entity.Product;

@Service
public class ProductService{
	
	@Autowired
	private ProductRepository pr;
	
	public List<Product> getProducts(){
		return pr.findAll();
	}
	
	public Product getProductById(long id) {
		Product p = new Product();
		Optional op = pr.findById(id);
		if(op.isPresent())
			p = (Product)op.get();
		return p;
	}
	
	public String addProduct(Product p){
		 return (pr.save(p).getId()).toString();
	}
	
	public Page<Product> getProByCateId(long id){
		return pr.findByCategoryId(id, null); //new Pageable.of(2,20); for branch
	}
}
