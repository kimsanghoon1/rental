package purifierrental.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import purifierrental.OrderApplication;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rentalId;

    private Long customerId;

    private Long purifierId;

    private String rentalStatus;

    private Long purifierRentalPrice;

    @PostPersist
    public void onPostPersist() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public void rent(RentCommand rentCommand) {
        PurifierRented purifierRented = new PurifierRented(this);
        purifierRented.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        purifierrental.external.Payment payment = new purifierrental.external.Payment();
        // mappings goes here
        OrderApplication.applicationContext
            .getBean(purifierrental.external.PaymentService.class)
            .pay(payment);
    }

    public void rentalCancel(RentalCancelCommand rentalCancelCommand) {
        RentalCancelled rentalCancelled = new RentalCancelled(this);
        rentalCancelled.publishAfterCommit();
    }

    public void returnPurifier(ReturnPurifierCommand returnPurifierCommand) {
        PurifierReturned purifierReturned = new PurifierReturned(this);
        purifierReturned.publishAfterCommit();
    }

    public static void updateRentalStatus(Accepted accepted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(accepted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void updateRentalStatus(ReturnConfirmed returnConfirmed) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(returnConfirmed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }
}
