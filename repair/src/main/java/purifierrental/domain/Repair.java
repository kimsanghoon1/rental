package purifierrental.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import purifierrental.RepairApplication;

@Entity
@Table(name = "Repair_table")
@Data
public class Repair {

    private String purifierStatus;

    private Long purifierId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long repairId;

    private Long repairmanId;

    @PostPersist
    public void onPostPersist() {}

    public static RepairRepository repository() {
        RepairRepository repairRepository = RepairApplication.applicationContext.getBean(
            RepairRepository.class
        );
        return repairRepository;
    }

    public void discard(DiscardCommand discardCommand) {
        Discarded discarded = new Discarded(this);
        discarded.publishAfterCommit();
    }

    public void repair(RepairCommand repairCommand) {
        PurifierRepaired purifierRepaired = new PurifierRepaired(this);
        purifierRepaired.publishAfterCommit();
    }

    public static void requestRepair(RepairRequested repairRequested) {
        /** Example 1:  new item 
        Repair repair = new Repair();
        repository().save(repair);

        */

        /** Example 2:  finding and process
        
        repository().findById(repairRequested.get???()).ifPresent(repair->{
            
            repair // do something
            repository().save(repair);


         });
        */

    }
}
