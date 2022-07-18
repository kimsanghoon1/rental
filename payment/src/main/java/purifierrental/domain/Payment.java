package purifierrental.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import purifierrental.PaymentApplication;
import purifierrental.domain.Paid;
import purifierrental.domain.PayCancelled;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payId;

    private String payStatus;

    private Long rentalId;

    private Long purifierRentalPrice;

    private Long purifierId;

    @PostPersist
    public void onPostPersist() {
        Paid paid = new Paid(this);
        paid.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        PayCancelled payCancelled = new PayCancelled(this);
        payCancelled.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = PaymentApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public static void payCancel(RentalCancelled rentalCancelled) {
        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        PayCancelled payCancelled = new PayCancelled(payment);
        payCancelled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(rentalCancelled.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);

            PayCancelled payCancelled = new PayCancelled(payment);
            payCancelled.publishAfterCommit();

         });
        */

    }
}
