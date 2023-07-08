package taller.controllers;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import taller.domain.Product;
import taller.dtos.bookingType.BookingTypeDto;
import taller.dtos.product.ProductDto;
import taller.repositories.IProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    @Autowired
    private IProductRepository _productRepository;

    @Autowired
    private ModelMapper _modelMapper;

    private static final Logger _logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAll() {

        List<ProductDto> result = _productRepository.findAll()
            .stream()
            .map(product -> _modelMapper.map(product, ProductDto.class))
            .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }
}
