package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class RentalCancelled extends AbstractEvent {

    private Long rentalId;
    private Long customerId;
    private Long purifierId;
    private String rentalStatus;
    private Long purifierRentalPrice;

    public RentalCancelled(Order aggregate) {
        super(aggregate);
    }

    public RentalCancelled() {
        super();
    }
    // keep

}
