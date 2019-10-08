package org.indy.geored.repomigrator.core.conf;

import javax.enterprise.context.ApplicationScoped;
import org.commonjava.cdi.util.weft.config.DefaultWeftConfig;
import org.commonjava.propulsor.config.ConfigurationException;
import org.commonjava.propulsor.config.section.MapSectionListener;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import java.io.InputStream;

@ApplicationScoped
public class RepomigratorWeftConfig extends MapSectionListener implements RepomigratorQueryConfigInfo {
  public final static String RM_METRICS_NODE_PREFIX = "node.prefix";

    public static final String SECTION_NAME = "threadpools";

    public static final String DEFAULT_THREADS = "defaultThreads";

    public static final String DEFAULT_PRIORITY = "defaultPriority";

    public static final String DEFAULT_MAX_LOAD_FACTOR = "defaultMaxLoadFactor";

    public static final String ENABLED = "enabled";

    public static final String NODE_PREFIX = RM_METRICS_NODE_PREFIX;

    public static final String THREADS_SUFFIX = ".threads";

    public static final String PRIORITY_SUFFIX = ".priority";

    public static final String MAX_LOAD_FACTOR_SUFFIX = ".maxLoadFactor";

    public static final String ENABLED_SUFFIX = ".enabled";

    private final DefaultWeftConfig weftConfig = new DefaultWeftConfig();

    private final String numericPattern = "[0-9]+";


    @Override
    public String getDefaultConfigFileName()
    {
        return RepomigratorQueryConfigInfo.APPEND_DEFAULTS_TO_MAIN_CONF;
    }

    @Override
    public InputStream getDefaultConfig()
    {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream( "./etc/main.conf" );
    }

    @Override
    public void parameter( final String name, final String value )
      throws ConfigurationException
    {

//        if ( !value.matches( numericPattern ) )
//        {
//            throw new ConfigurationException( "Invalid value: '{}' for parameter: '{}'. Only numeric values are accepted for section: '{}'.", value,
//                                              name, SECTION_NAME );
//        }

        try
        {
            if ( DEFAULT_THREADS.equals( name ) )
            {
                final int v = Integer.parseInt( value );
                weftConfig.configureDefaultThreads( v );
            }
            else if ( DEFAULT_PRIORITY.equals( name ) )
            {
                final int v = Integer.parseInt( value );
                weftConfig.configureDefaultPriority( v );
            }
            else if ( DEFAULT_MAX_LOAD_FACTOR.equals( name ) )
            {
                final float v = Float.parseFloat( value );
                weftConfig.configureDefaultMaxLoadFactor( v );
            }
            else if ( ENABLED.equals( name ) )
            {
                weftConfig.configureEnabled( Boolean.parseBoolean( value ) );
            }
            else if ( NODE_PREFIX.equals( name ) )
            {
                weftConfig.configureNodePrefix( value );
            }
            else
            {
                final int lastIdx = name.lastIndexOf( '.' );
                if ( lastIdx > -1 && name.length() > lastIdx )
                {
                    final String pool = name.substring( 0, lastIdx );
                    final String suffix = name.substring( lastIdx );

                    if ( THREADS_SUFFIX.equals( suffix ) )
                    {
                        final int v = Integer.parseInt( value );
                        weftConfig.configureThreads( pool, v );
                    }
                    else if ( PRIORITY_SUFFIX.equals( suffix ) )
                    {
                        final int v = Integer.parseInt( value );
                        weftConfig.configurePriority( pool, v );
                    }
                    else if ( ENABLED_SUFFIX.equals( suffix ) )
                    {
                        weftConfig.configureEnabled( pool, Boolean.parseBoolean( value ) );
                    }
                    else if ( MAX_LOAD_FACTOR_SUFFIX.equals( suffix ) )
                    {
                        final float v = Float.parseFloat( value );
                        weftConfig.configureMaxLoadFactor( pool, v );
                    }
                }
            }
        }
        catch ( NumberFormatException e )
        {
            throw new ConfigurationException( "Non-numeric value for 'threadpools' parameter: '{}' (value was: '{}')", name, value );
        }
    }

    @Produces
    @Default
    public DefaultWeftConfig getWeftConfig()
    {
        return weftConfig;
    }

    @Override
    public void sectionStarted( final String name )
      throws ConfigurationException
    {
        // NOP; just block map init in the underlying implementation.
    }
}