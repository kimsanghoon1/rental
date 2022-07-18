package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class Discarded extends AbstractEvent {

    private String purifierStatus;
    private Long purifierId;
    private Long repairId;
    private Long repairmanId;

    public Discarded(Repair aggregate) {
        super(aggregate);
    }

    public Discarded() {
        super();
    }
    // keep

}
