package ru.test.spring;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Scope("prototype")
public class Cart {

    private static final Map<Long, Product> cartMap = new HashMap<>();
    private ProductRepository productRepository = new ProductRepository();




    public void addProduct(Product product) {
        if (product != null)
            cartMap.put((long) (cartMap.size() + 1), product);

    }

    public String findAllCart(){
         System.out.println("\n"+ cartMap);
        return "End.";
    }

    public void delProduct(Long id) {

        if (id==1) {
            System.out.println("нельзя удалить тестовую запись");
        }else {cartMap.remove(id);}
    }
}