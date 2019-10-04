package org.indy.geored.repomigrator.core.inject;


import org.commonjava.propulsor.config.ConfigurationException;
import org.commonjava.propulsor.config.ConfigurationRegistry;
import org.commonjava.propulsor.config.DefaultConfigurationListener;
import org.commonjava.propulsor.config.DefaultConfigurationRegistry;
import org.indy.geored.repomigrator.core.conf.RepomigratorQueryConfigInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

@ApplicationScoped
public class ConfigRegistryProducer {

//    @Inject
//    Instance<RepomigratorQueryConfigInfo> configs;
//
//    @Produces
//    public ConfigurationRegistry getConfigurationRegistry() throws ConfigurationException
//    {
//        Logger logger = LoggerFactory.getLogger( getClass() );
//        logger.info( "RepoMigration service configuration registry producer." );
//
//        DefaultConfigurationListener configListener =
//            new DefaultConfigurationListener();
//
//
//        configs.forEach( (conf) -> {
//            try
//            {
//                configListener.with( conf );
//            }
//            catch ( ConfigurationException e )
//            {
//                logger.error( "Load configuration error, config:{}, error: {}", conf.getClass(), e.getMessage(), e );
//            }
//        });
//
//        return new DefaultConfigurationRegistry( configListener );
//    }


}
