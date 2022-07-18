package purifierrental.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import purifierrental.domain.*;

@RestController
@RequestMapping(value = "/repairs")
@Transactional
public class RepairController {

    @Autowired
    RepairRepository repairRepository;

    @RequestMapping(
        value = "/{id}/discard",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Repair discard(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /repair/discard  called #####");
        Optional<Repair> optionalRepair = repairRepository.findById(id);

        optionalRepair.orElseThrow(() -> new Exception("No Entity Found"));
        Repair repair = optionalRepair.get();
        repair.discard();

        repairRepository.save(repair);
        return repair;
    }

    @RequestMapping(
        value = "/{id}/repair",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Repair repair(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /repair/repair  called #####");
        Optional<Repair> optionalRepair = repairRepository.findById(id);

        optionalRepair.orElseThrow(() -> new Exception("No Entity Found"));
        Repair repair = optionalRepair.get();
        repair.repair();

        repairRepository.save(repair);
        return repair;
    }
    // keep
}
