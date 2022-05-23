package App;

import org.springframework.context.annotation.ComponentScan;
import ru.test.spring.Cart;
import ru.test.spring.Product;
import ru.test.spring.ProductRepository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

@ComponentScan("ru.test.spring")
public class Main {
    public static void main(String[] args) {
       ProductRepository productRepository = new ProductRepository();
       Cart cart = new Cart();
        cart.addProduct(productRepository.findById(666L));
        Scanner sc = new Scanner(System.in);
        System.out.println("Если хотите посмотреть список команд введите help ");
        while (true) {
            String scan = sc.nextLine();
            if (scan.equals("help")) {
                listCommand();
            }else if (scan.equals("check")) {
                System.out.println(productRepository.findAll());
            }else if (scan.startsWith("Find")) {
                String[] text = scan.split(" ");
                System.out.println(productRepository.findById(Long.valueOf(text[1])));
                Arrays.fill(text,"");
            }else if (scan.startsWith("add")){
                String[] text = scan.split(" ");
                cart.addProduct(productRepository.findById(Long.valueOf(text[1])));
                Arrays.fill(text,"");
                System.out.println("Продукт добавлен");
            }else if (scan.startsWith("delete")){
                String[] text = scan.split(" ");
                cart.delProduct(Long.valueOf(text[1]));
                Arrays.fill(text,"");
                System.out.println("Продукт удален");
            }else if (scan.equals("cart")){
                System.out.println("Корзина : ");
                System.out.println(cart.findAllCart());
            }

        }

    }

    private static String listCommand(){

        System.out.println("check - вывод товаров");
        System.out.println("Find id - вывод товара по его id");
        System.out.println("add id - добавить в корзину товар с id ");
        System.out.println("delete id - удалить из корзнины товар с id");
        System.out.println("cart - вывод корзины ");
        return("Список команд выведен");
    }
}
