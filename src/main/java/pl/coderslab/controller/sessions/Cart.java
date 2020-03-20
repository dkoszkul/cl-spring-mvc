package pl.coderslab.controller.sessions;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(int quantity, Product product) {
        Optional<CartItem> first = cartItems.stream().filter(cartItem -> cartItem.getProduct().getName().equals(product.getName())).findFirst();

        if (first.isPresent()) {
            System.out.println("JEst!");
            CartItem cartItem = first.get();
            cartItems.remove(cartItem);
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItems.add(cartItem);
        } else {
            System.out.println("Nie ma");
            cartItems.add(new CartItem(quantity, product));
        }
    }

    public int getProductsAmount() {
        return cartItems.stream()
                .mapToInt(CartItem::getQuantity).sum();
    }

    public double getAllPrice() {
        return cartItems.stream()
                .mapToDouble(value -> value.getQuantity() * value.getProduct().getPrice()).sum();
    }
}
