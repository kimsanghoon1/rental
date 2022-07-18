package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class RepairRequested extends AbstractEvent {

    private Long purifierId;
    private String name;
    private String purifierStatus;
    private Long rentalId;
    private Long purifierRentalPrice;
    // keep

}
