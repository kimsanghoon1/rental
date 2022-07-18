package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class PurifierRented extends AbstractEvent {

    private Long rentalId;
    private Long customerId;
    private Long purifierId;
    private String rentalStatus;
    private Long purifierRentalPrice;

    public PurifierRented(Order aggregate) {
        super(aggregate);
    }

    public PurifierRented() {
        super();
    }
    // keep

}
