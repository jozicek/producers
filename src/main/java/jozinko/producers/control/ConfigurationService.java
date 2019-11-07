package jozinko.producers.control;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConfigurationService {

    private String config;

    public void setConfig(String config) {
        this.config = config;
    }

    public String provideConfig() {
        return config;
    }

}
