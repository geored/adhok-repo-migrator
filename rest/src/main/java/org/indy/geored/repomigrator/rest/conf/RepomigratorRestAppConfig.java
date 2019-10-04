package org.indy.geored.repomigrator.rest.conf;

import org.commonjava.propulsor.deploy.resteasy.ResteasyAppConfig;

import java.util.List;

import static java.util.Arrays.asList;

public class RepomigratorRestAppConfig implements ResteasyAppConfig {
    @Override
    public List<String> getJaxRsMappings() {
        return asList( "/api*", "/api/*" );
    }
}
