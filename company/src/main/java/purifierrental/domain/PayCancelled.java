package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class PayCancelled extends AbstractEvent {

    private Long payId;
    private Long rentalId;
    private String payStatus;
    private Long purifierRentalPrice;
    private Long purifierId;
    // keep

}
