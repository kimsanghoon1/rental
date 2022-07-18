package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class Accepted extends AbstractEvent {

    private Long purifierId;
    private Long rentalId;
    private String name;
    private Long purifierRentalPrice;
    private String purifierStatus;
    // keep

}
