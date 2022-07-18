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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Accepted'"
    )
    public void wheneverAccepted_UpdateRentalStatus(
        @Payload Accepted accepted
    ) {
        Accepted event = accepted;
        System.out.println(
            "\n\n##### listener UpdateRentalStatus : " + accepted + "\n\n"
        );

        // Sample Logic //
        Order.updateRentalStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ReturnConfirmed'"
    )
    public void wheneverReturnConfirmed_UpdateRentalStatus(
        @Payload ReturnConfirmed returnConfirmed
    ) {
        ReturnConfirmed event = returnConfirmed;
        System.out.println(
            "\n\n##### listener UpdateRentalStatus : " +
            returnConfirmed +
            "\n\n"
        );

        // Sample Logic //
        Order.updateRentalStatus(event);
    }
    // keep

}
