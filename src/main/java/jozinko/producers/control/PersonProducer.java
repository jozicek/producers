package jozinko.producers.control;

import jozinko.producers.entity.Jozinko;
import jozinko.producers.entity.Longi;
import jozinko.producers.entity.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class PersonProducer {

    @Inject
    private ConfigurationService configurationService;

    @Produces
    public Person produce() {
        if ("l".equals(configurationService.provideConfig())) {
            return new Longi();
        } else {
            return new Jozinko();
        }
    }

}
