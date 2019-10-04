/**
 * Copyright (C) 2018 Red Hat, Inc. (jdcasey@commonjava.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.indy.geored.repomigrator.rest.resources;


import org.commonjava.propulsor.deploy.resteasy.RestResources;
import org.indy.geored.repomigrator.common.PaginatedResult;
import org.indy.geored.repomigrator.ctl.ContentTrackingController;
import org.indy.geored.repomigrator.rest.exception.AuditQueryWebException;
import org.indy.geored.repomigrator.tracking.dto.TrackedContentEntryDTO;
import org.indy.geored.repomigrator.tracking.dto.TrackingSummaryDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Collection;

import static org.commonjava.propulsor.deploy.undertow.util.StandardApplicationContent.application_json;

@Path( "/api/rest" )
@Consumes( { application_json } )
@Produces( { application_json } )
@ApplicationScoped
public class ContentTrackingResource
                implements RestResources
{

//    @Inject
//    ContentTrackingController trackingController;

    @GET
    public TrackingSummaryDTO getTrackingSummary(@PathParam( "tracking-id" ) String trackingID )
                    throws AuditQueryWebException
    {
        TrackingSummaryDTO trackingSummaryDTO = null;
//        try
//        {
//            trackingSummaryDTO = trackingController.getTrackingSummaryByID( trackingID );
//        }
//        catch ( Exception e )
//        {
//            throw new AuditQueryWebException( e );
//        }

        return trackingSummaryDTO;
    }

}
