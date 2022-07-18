package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class Paid extends AbstractEvent {

    private String payStatus;
    private Long rentalId;
    private Long purifierRentalPrice;
    private Long purifierId;
    private Long payId;
    // keep

}
