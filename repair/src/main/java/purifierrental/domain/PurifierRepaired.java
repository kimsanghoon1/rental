package purifierrental.domain;

import java.util.*;
import lombok.*;
import purifierrental.domain.*;
import purifierrental.infra.AbstractEvent;

@Data
@ToString
public class PurifierRepaired extends AbstractEvent {

    private String purifierStatus;
    private Long purifierId;
    private Long repairId;
    private Long repairmanId;

    public PurifierRepaired(Repair aggregate) {
        super(aggregate);
    }

    public PurifierRepaired() {
        super();
    }
    // keep

}
