package org.indy.geored.repomigrator.conf;


import org.commonjava.propulsor.boot.BootOptions;
import org.commonjava.propulsor.config.ConfigurationException;
import org.commonjava.propulsor.config.Configurator;
import org.commonjava.propulsor.config.ConfiguratorException;
import org.commonjava.propulsor.config.dotconf.DotConfConfigurationReader;
import org.commonjava.propulsor.config.io.ConfigFileUtils;
import org.indy.geored.repomigrator.core.conf.SystemPropertyProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@ApplicationScoped
public class RepomigratorQueryConfiguration implements Configurator {

    @Inject
    DotConfConfigurationReader dotConfConfigurationReader;

    @Inject Instance<SystemPropertyProvider> systemPropertyProviders;

    @Override
    public void load(BootOptions options) throws ConfiguratorException {
        String config = options.getConfig();
        File configFile = new File( config );

        try (InputStream stream = ConfigFileUtils.readFileWithIncludes( configFile ))
        {
            dotConfConfigurationReader.loadConfiguration( stream );
        }
        catch ( ConfigurationException | IOException e )
        {
            throw new ConfiguratorException( "Failed to read configuration: %s. Reason: %s", e, config,
                e.getMessage() );
        }

        Properties sysprops = System.getProperties();
        systemPropertyProviders.forEach( (provider) -> {
            Properties p =  provider.getSystemProperties();
            p.stringPropertyNames().forEach( ( name ) -> sysprops.setProperty( name, p.getProperty( name ) ) );
        } );
        System.setProperties( sysprops );

    }
}
