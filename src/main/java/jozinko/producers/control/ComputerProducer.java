package jozinko.producers.control;

import jozinko.producers.entity.Computer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ComputerProducer {

    @Produces
    @Pc
    public Computer producePc() {
        return new Computer("intel", "xxx22", "ddr3 16GB", "lg");
    }

    @Produces
    @MacBook
    public Computer produceMacBook() {
        return new Computer("amd", "zzz44", "ddr4 8GB", "retina");
    }

}
