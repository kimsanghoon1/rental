package purifierrental.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import purifierrental.config.kafka.KafkaProcessor;
import purifierrental.domain.*;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RentalCancelled'"
    )
    public void wheneverRentalCancelled_PayCancel(
        @Payload RentalCancelled rentalCancelled
    ) {
        RentalCancelled event = rentalCancelled;
        System.out.println(
            "\n\n##### listener PayCancel : " + rentalCancelled + "\n\n"
        );

        // Sample Logic //
        Payment.payCancel(event);
    }
    // keep

}
