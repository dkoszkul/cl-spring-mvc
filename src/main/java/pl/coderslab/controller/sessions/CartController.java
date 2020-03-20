package pl.coderslab.controller.sessions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

@Controller
public class CartController {

    private Cart cart;

    private ProductDao productDao;

    @Autowired
    public CartController(Cart cart, ProductDao productDao) {
        this.cart = cart;
        this.productDao = productDao;
    }

    @GetMapping("/addtocart")
    @ResponseBody
    public String addtocart(@RequestParam("id")Long id, @RequestParam("quantity") int quantity) {
        Product product1 = productDao.getList().stream().filter(product -> product.getId().equals(id)).findFirst().get();
        cart.addToCart(quantity, product1);
        return "addtocart";
    }

    @GetMapping(value = "cart")
    public String cart(Model model) {
        model.addAttribute("cart", cart);
        return "cart";
    }
}
