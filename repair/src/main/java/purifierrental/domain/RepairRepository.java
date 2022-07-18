package purifierrental.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import purifierrental.domain.*;

@RepositoryRestResource(collectionResourceRel = "repairs", path = "repairs")
public interface RepairRepository
    extends PagingAndSortingRepository<Repair, Long> {}
