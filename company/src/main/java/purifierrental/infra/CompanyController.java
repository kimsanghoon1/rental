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
@RequestMapping(value = "/companies")
@Transactional
public class CompanyController {

    @Autowired
    CompanyRepository companyRepository;

    @RequestMapping(
        value = "/{id}/repairrequest",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Company repairRequest(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /company/repairRequest  called #####");
        Optional<Company> optionalCompany = companyRepository.findById(id);

        optionalCompany.orElseThrow(() -> new Exception("No Entity Found"));
        Company company = optionalCompany.get();
        company.repairRequest();

        companyRepository.save(company);
        return company;
    }

    @RequestMapping(
        value = "/{id}/accept",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Company accept(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /company/accept  called #####");
        Optional<Company> optionalCompany = companyRepository.findById(id);

        optionalCompany.orElseThrow(() -> new Exception("No Entity Found"));
        Company company = optionalCompany.get();
        company.accept();

        companyRepository.save(company);
        return company;
    }

    @RequestMapping(
        value = "/{id}/returnconfirm",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Company returnConfirm(
        @PathVariable(value = "id") Long id,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /company/returnConfirm  called #####");
        Optional<Company> optionalCompany = companyRepository.findById(id);

        optionalCompany.orElseThrow(() -> new Exception("No Entity Found"));
        Company company = optionalCompany.get();
        company.returnConfirm();

        companyRepository.save(company);
        return company;
    }
    // keep
}
