package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class ReturnConfirmed extends AbstractEvent {

    private Long purifierId;
    private Long rentalId;
    private String name;
    private String purifierStatus;
    private Long purifierRentalPrice;

    public ReturnConfirmed(Company aggregate) {
        super(aggregate);
    }

    public ReturnConfirmed() {
        super();
    }
    // keep

}
