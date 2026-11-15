
package campusbite.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class MenuController {

    @GetMapping("/api/menu")
    public List<Map<String, Object>> getMenu() {

        return Arrays.asList(
            Map.of("name", "Masala Dosa", "price", 50),
            Map.of("name", "Idli Sambar", "price", 35),
            Map.of("name", "Veg Burger", "price", 50),
            Map.of("name", "French Fries", "price", 40),
            Map.of("name", "Veg Fried Rice", "price", 80),
            Map.of("name", "Veg Noodles", "price", 70),
            Map.of("name", "Fresh Lime Soda", "price", 30),
            Map.of("name", "Cold Coffee", "price", 45)
        );
    }
}
