package purifierrental.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import purifierrental.CompanyApplication;
import purifierrental.domain.Registered;

@Entity
@Table(name = "Company_table")
@Data
public class Company {

    private Long purifierId;

    private Long rentalId;

    private String name;

    private Long purifierRentalPrice;

    private String purifierStatus;

    @PostPersist
    public void onPostPersist() {
        Registered registered = new Registered(this);
        registered.publishAfterCommit();
    }

    public static CompanyRepository repository() {
        CompanyRepository companyRepository = CompanyApplication.applicationContext.getBean(
            CompanyRepository.class
        );
        return companyRepository;
    }

    public void repairRequest(RepairRequestCommand repairRequestCommand) {
        RepairRequested repairRequested = new RepairRequested(this);
        repairRequested.publishAfterCommit();
    }

    public void accept(AcceptCommand acceptCommand) {
        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();
    }

    public void returnConfirm(ReturnConfirmCommand returnConfirmCommand) {
        ReturnConfirmed returnConfirmed = new ReturnConfirmed(this);
        returnConfirmed.publishAfterCommit();
    }

    public static void rentalConfirm(Paid paid) {
        /** Example 1:  new item 
        Company company = new Company();
        repository().save(company);

        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(company->{
            
            company // do something
            repository().save(company);


         });
        */

    }

    public static void rentalCancel(PayCancelled payCancelled) {
        /** Example 1:  new item 
        Company company = new Company();
        repository().save(company);

        */

        /** Example 2:  finding and process
        
        repository().findById(payCancelled.get???()).ifPresent(company->{
            
            company // do something
            repository().save(company);


         });
        */

    }

    public static void purifierReturn(PurifierReturned purifierReturned) {
        /** Example 1:  new item 
        Company company = new Company();
        repository().save(company);

        */

        /** Example 2:  finding and process
        
        repository().findById(purifierReturned.get???()).ifPresent(company->{
            
            company // do something
            repository().save(company);


         });
        */

    }

    public static void updatePurifierStatus(PurifierRepaired purifierRepaired) {
        /** Example 1:  new item 
        Company company = new Company();
        repository().save(company);

        */

        /** Example 2:  finding and process
        
        repository().findById(purifierRepaired.get???()).ifPresent(company->{
            
            company // do something
            repository().save(company);


         });
        */

    }

    public static void updatePurifierStatus(Discarded discarded) {
        /** Example 1:  new item 
        Company company = new Company();
        repository().save(company);

        */

        /** Example 2:  finding and process
        
        repository().findById(discarded.get???()).ifPresent(company->{
            
            company // do something
            repository().save(company);


         });
        */

    }
}
