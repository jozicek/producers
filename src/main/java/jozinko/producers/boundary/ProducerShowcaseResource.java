package jozinko.producers.boundary;

import jozinko.producers.control.ConfigurationService;
import jozinko.producers.control.MacBook;
import jozinko.producers.control.Pc;
import jozinko.producers.control.PurposeOfLife;
import jozinko.producers.entity.Computer;
import jozinko.producers.entity.Person;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

// TODO: 5.11.2019 Expose SDK class as CDI bean
// TODO: 5.11.2019 multiple beans with different initialization or scope for the same implementation class
// TODO: 5.11.2019 vary implementation of bean at runtime
// multiple implementations injected by interface and distinguished by qualifier
// different from injecting particular implementation, can be changed easily in one place and not
// all injection points -> program towards interface not implementation principle.
@Path("show")
public class ProducerShowcaseResource {

    @Inject
    @PurposeOfLife
    private Integer purposeOfLife;

    @Inject
    private ConfigurationService configurationService;

    @Inject
    private Person person;

    @Inject
    @MacBook
    private Computer mac;

    @Inject
    @Pc
    private Computer pc;

    @GET
    @Path("pol")
    public Response getPurposeOfLife() {
        return Response.ok(purposeOfLife).build();
    }

    @POST
    @Path("config/{configParam}")
    public Response setConfig(@PathParam("configParam") String configParam) {
        configurationService.setConfig(configParam);
        return Response.ok().build();
    }

    @GET
    @Path("person")
    public String getPerson() {
        return person.sayHello();
    }

    @GET
    @Path("pc")
    public Computer getPc() {
        return pc;
    }

    @GET
    @Path("mac")
    public Computer getMac() {
        return mac;
    }

}
