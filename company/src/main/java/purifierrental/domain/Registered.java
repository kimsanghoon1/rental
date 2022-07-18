package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class Registered extends AbstractEvent {

    private Long purifierId;
    private String name;
    private Long purifierRentalPrice;
    private String purifierStatus;
    private Long rentalId;

    public Registered(Company aggregate) {
        super(aggregate);
    }

    public Registered() {
        super();
    }
    // keep

}
