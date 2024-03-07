package com.stasy.api.services.sale;

import com.stasy.api.domain.product.Product;
import com.stasy.api.domain.sale.Sale;
import com.stasy.api.domain.saleproduct.SaleProduct;
import com.stasy.api.domain.saleproduct.SaleProductKey;
import com.stasy.api.domain.user.User;
import com.stasy.api.dtos.SaleDTO;
import com.stasy.api.repositories.SaleProductRepository;
import com.stasy.api.repositories.SaleRepository;
import com.stasy.api.services.product.ProductNotFoundException;
import com.stasy.api.services.product.ProductService;
import com.stasy.api.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SaleService {
    private SaleRepository saleRepository;
    private SaleProductRepository saleProductRepository;
    private UserService userService;
    private ProductService productService;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new SaleNotFoundException(id));
    }

    public Sale createSale(SaleDTO data) {
        User seller = userService.getUserById(data.sellerId());
        BigDecimal total = BigDecimal.ZERO;

        Sale sale = new Sale(data.customerName(), seller, BigDecimal.ZERO);
        List<SaleProduct> saleProducts = new ArrayList<>();

        for (var entry : data.products().entrySet()) {
            Product product = productService.getProductById(entry.getKey());
            BigDecimal price = product.getPrice();
            SaleProductKey saleProductKey = new SaleProductKey(sale, product);
            SaleProduct saleProduct = new SaleProduct(saleProductKey, price, entry.getValue());
            saleProducts.add(saleProduct);
            total = total.add(price.multiply(BigDecimal.valueOf(entry.getValue())));
        }

        sale.setTotal(total);

        saleRepository.save(sale);
        saleProductRepository.saveAll(saleProducts);
        return sale;
    }
}
