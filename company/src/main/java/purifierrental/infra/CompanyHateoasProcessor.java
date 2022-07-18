package purifierrental.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import purifierrental.domain.*;

@Component
public class CompanyHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Company>> {

    @Override
    public EntityModel<Company> process(EntityModel<Company> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/repairrequest")
                .withRel("repairrequest")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/accept")
                .withRel("accept")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/returnconfirm")
                .withRel("returnconfirm")
        );

        return model;
    }
}
