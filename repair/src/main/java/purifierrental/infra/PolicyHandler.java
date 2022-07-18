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
    RepairRepository repairRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RepairRequested'"
    )
    public void wheneverRepairRequested_RequestRepair(
        @Payload RepairRequested repairRequested
    ) {
        RepairRequested event = repairRequested;
        System.out.println(
            "\n\n##### listener RequestRepair : " + repairRequested + "\n\n"
        );

        // Sample Logic //
        Repair.requestRepair(event);
    }
    // keep

}
