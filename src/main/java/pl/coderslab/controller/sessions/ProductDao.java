package pl.coderslab.controller.sessions;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    public List<Product> getList() {
        return List.of(
                new Product(1L, "a", 22.2),
                new Product(2L, "b", 12.2),
                new Product(3L, "c", 32.2),
                new Product(4L, "d", 42.2)
        );
    }
}
