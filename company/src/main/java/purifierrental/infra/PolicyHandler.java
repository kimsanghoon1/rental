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
    CompanyRepository companyRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_RentalConfirm(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener RentalConfirm : " + paid + "\n\n"
        );

        // Sample Logic //
        Company.rentalConfirm(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PayCancelled'"
    )
    public void wheneverPayCancelled_RentalCancel(
        @Payload PayCancelled payCancelled
    ) {
        PayCancelled event = payCancelled;
        System.out.println(
            "\n\n##### listener RentalCancel : " + payCancelled + "\n\n"
        );

        // Sample Logic //
        Company.rentalCancel(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PurifierReturned'"
    )
    public void wheneverPurifierReturned_PurifierReturn(
        @Payload PurifierReturned purifierReturned
    ) {
        PurifierReturned event = purifierReturned;
        System.out.println(
            "\n\n##### listener PurifierReturn : " + purifierReturned + "\n\n"
        );

        // Sample Logic //
        Company.purifierReturn(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PurifierRepaired'"
    )
    public void wheneverPurifierRepaired_UpdatePurifierStatus(
        @Payload PurifierRepaired purifierRepaired
    ) {
        PurifierRepaired event = purifierRepaired;
        System.out.println(
            "\n\n##### listener UpdatePurifierStatus : " +
            purifierRepaired +
            "\n\n"
        );

        // Sample Logic //
        Company.updatePurifierStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Discarded'"
    )
    public void wheneverDiscarded_UpdatePurifierStatus(
        @Payload Discarded discarded
    ) {
        Discarded event = discarded;
        System.out.println(
            "\n\n##### listener UpdatePurifierStatus : " + discarded + "\n\n"
        );

        // Sample Logic //
        Company.updatePurifierStatus(event);
    }
    // keep

}
