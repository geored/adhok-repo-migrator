package org.indy.geored.repomigrator.cache;


import javax.inject.Qualifier;
import java.lang.annotation.*;

/**
 * Qualifier used to supply tracking summary cache in infinispan.xml.
 */
@Qualifier
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention( RetentionPolicy.RUNTIME)
@Documented
public @interface TrackingSummaryCache {
}
