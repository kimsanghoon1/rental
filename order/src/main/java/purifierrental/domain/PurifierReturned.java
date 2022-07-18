package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class PurifierReturned extends AbstractEvent {

    private Long rentalId;
    private Long customerId;
    private Long purifierId;
    private String rentalStatus;
    private Long purifierRentalPrice;

    public PurifierReturned(Order aggregate) {
        super(aggregate);
    }

    public PurifierReturned() {
        super();
    }
    // keep

}
