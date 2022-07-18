package purifierrental.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import purifierrental.domain.*;

@RestController
@RequestMapping(value = "/orders")
@Transactional
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(
        value = "/{id}/rent",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order rent(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/rent  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.rent();

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/{id}/rentalcencel",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order rentalCancel(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/rentalCancel  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.rentalCancel();

        orderRepository.save(order);
        return order;
    }

    @RequestMapping(
        value = "/{id}/returnPurifier",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order returnPurifier(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/returnPurifier  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.returnPurifier();

        orderRepository.save(order);
        return order;
    }
    // keep
}
