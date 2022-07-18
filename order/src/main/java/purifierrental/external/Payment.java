package purifierrental.external;

import java.util.Date;
import lombok.Data;

@Data
public class Payment {

    private Long payId;
    private String payStatus;
    private Long rentalId;
    private Long purifierRentalPrice;
    private Long purifierId;
    // keep

}
