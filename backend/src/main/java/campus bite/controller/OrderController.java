package campusbite.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Map;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    private final JdbcTemplate jdbcTemplate;

    public OrderController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/api/order")
    public Map<String, Object> placeOrder(
            @RequestBody Map<String, Object> order) {

        String customerName = String.valueOf(
                order.getOrDefault("customerName",
                order.getOrDefault("customer_name", "Guest"))
        );

        String items = String.valueOf(
                order.getOrDefault("items", "")
        );

        Object totalValue = order.getOrDefault("total", 0);
        double total = Double.parseDouble(String.valueOf(totalValue));

        String status = "Confirmed";

        jdbcTemplate.update(
                "INSERT INTO orders (customer_name, items, total, status) VALUES (?, ?, ?, ?)",
                customerName, items, total, status
        );

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Order placed successfully!");
        response.put("status", status);

        return response;
    }

    @GetMapping("/api/orders")
    public List<Map<String, Object>> getOrders() {

        return jdbcTemplate.queryForList(
                "SELECT * FROM orders ORDER BY id DESC"
        );
    }
}
