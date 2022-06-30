package com.evpowerguard.registration;


import com.evpowerguard.registration.domain.User;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<User>> {

    @Override
    public EntityModel<User> process(EntityModel<User> model) {

        //model.add(Link.of(model.getRequiredLink("self").getHref() + "/feed").withRel("feed"));

        // if(model.getContent() instanceof User)
        //     model.add(Link.of(model.getRequiredLink("self").getHref() + "/groom").withRel("groom"));

        return model;
    }
}