package taller.controllers.privates;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import taller.dtos.product.ProductDto;
import taller.repositories.IProductRepository;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, methods = {RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.GET} )
public class ProductController {

    @Autowired
    private IProductRepository _productRepository;

    @Autowired
    private ModelMapper _modelMapper;

    private static final Logger _logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/private/products")
    public ResponseEntity<List<ProductDto>> getAll() {

        List<ProductDto> result = _productRepository.findAll()
            .stream()
            .map(product -> _modelMapper.map(product, ProductDto.class))
            .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
}
