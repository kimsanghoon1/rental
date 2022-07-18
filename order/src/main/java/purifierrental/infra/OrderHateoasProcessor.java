package purifierrental.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import purifierrental.domain.*;

@Component
public class OrderHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Order>> {

    @Override
    public EntityModel<Order> process(EntityModel<Order> model) {
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/rent")
                .withRel("rent")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/rentalcencel")
                .withRel("rentalcencel")
        );
        model.add(
            Link
                .of(model.getRequiredLink("self").getHref() + "/returnPurifier")
                .withRel("returnPurifier")
        );

        return model;
    }
}
