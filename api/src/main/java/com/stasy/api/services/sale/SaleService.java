package com.stasy.api.services.sale;

import com.stasy.api.domain.product.Product;
import com.stasy.api.domain.sale.Sale;
import com.stasy.api.domain.saleproduct.SaleProduct;
import com.stasy.api.domain.user.User;
import com.stasy.api.dtos.SaleDTO;
import com.stasy.api.repositories.SaleRepository;
import com.stasy.api.services.product.ProductService;
import com.stasy.api.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SaleService {

    private SaleRepository saleRepository;
    private UserService userService;
    private ProductService productService;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleById(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new SaleNotFoundException(id));
    }

    public List<Sale> getByDate(LocalDateTime date) {
        return saleRepository.findByDate(date).orElse(new ArrayList<>());
    }

    public List<Sale> getByDateBefore(LocalDateTime date) {
        return saleRepository.findByDateBefore(date).orElse(new ArrayList<>());
    }

    public List<Sale> getByDateAfter(LocalDateTime date) {
        return saleRepository.findByDateAfter(date).orElse(new ArrayList<>());
    }

    public List<Sale> getByDateBetween(LocalDateTime start, LocalDateTime end) {
        return saleRepository.findByDateBetween(start, end).orElse(new ArrayList<>());
    }

    public Sale createSale(SaleDTO data) {

        User user = userService.getUserById(data.sellerId());
        Sale sale = new Sale(data.customerName(), user);
        saleRepository.save(sale);

        List<SaleProduct> saleProducts;
        try {
            saleProducts = createSaleProducts(data.products(), sale);
        } catch (RuntimeException e) {
            saleRepository.delete(sale);
            throw new RuntimeException(e.getMessage());
        }

        sale.setSaleProducts(saleProducts);

        saleRepository.save(sale);

        return sale;
    }

    public List<SaleProduct> createSaleProducts(Map<Long, Integer> products, Sale sale) {
        BigDecimal total = BigDecimal.ZERO;
        List<SaleProduct> saleProducts = new ArrayList<>();

        for (var entry : products.entrySet()) {
            SaleProduct saleProduct;
            try {
                saleProduct = createSaleProduct(entry.getKey(), entry.getValue(), sale);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getMessage());
            }
            total = total.add(saleProduct.getTotal());
            saleProducts.add(saleProduct);
        }

        sale.setTotal(total);
        return saleProducts;
    }

    public SaleProduct createSaleProduct(Long productId, Integer quantity, Sale sale) {
        Product product = productService.getProductById(productId);

        if (product.getQuantity() <  quantity) {
            throw new RuntimeException("Not enough on stock for product with id " + productId);
        }
        productService.sellProducts(product.getId(), Long.valueOf(quantity));

        BigDecimal price = product.getPrice();
        return new SaleProduct(sale, product, price, quantity);
    }

    public void deleteSale(Long id) {
        Sale sale = this.getSaleById(id);
        for (SaleProduct saleProduct : sale.getSaleProducts()) {
            long productId = saleProduct.getId().getProduct().getId();
            long quantity = saleProduct.getQuantity();
            productService.addProducts(productId, quantity);
        }
        saleRepository.deleteById(id);
    }
}
