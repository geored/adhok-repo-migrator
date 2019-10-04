package org.indy.geored.repomigrator.core.web;

import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.FilterInfo;
import io.undertow.servlet.util.ImmediateInstanceFactory;
import org.commonjava.propulsor.deploy.undertow.UndertowDeploymentProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.DispatcherType;

@ApplicationScoped
public class FilterDeploymentProvider implements UndertowDeploymentProvider {



    @Inject
    ResourcesFilter resourcesFilter;


    @Override
    public DeploymentInfo getDeploymentInfo() {
        final FilterInfo resourceFilter =
            Servlets.filter(
                "ResourceManagement",
                ResourcesFilter.class,new ImmediateInstanceFactory<ResourcesFilter>(resourcesFilter ));

        final DeploymentInfo di = new DeploymentInfo().addFilter( resourceFilter )
            .addFilterUrlMapping( resourceFilter.getName(),
                "/browse/*", DispatcherType.REQUEST )
            .setDeploymentName( "RepomigratorQueryWeb" )
            .setClassLoader( ClassLoader.getSystemClassLoader() );

        return di;
    }
}
