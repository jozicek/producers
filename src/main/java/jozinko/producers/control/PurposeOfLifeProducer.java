package jozinko.producers.control;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class PurposeOfLifeProducer {


    @Produces
    @PurposeOfLife
    public Integer produce() {
        return 42;
    }

}
