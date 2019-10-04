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
import org.indy.geored.repomigrator.ctl.RepoChangeEventController;
import org.indy.geored.repomigrator.history.ChangeEvent;
import org.indy.geored.repomigrator.history.ChangeSummary;
import org.indy.geored.repomigrator.history.dto.ChangeSummaryStats;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.commonjava.propulsor.deploy.undertow.util.StandardApplicationContent.application_json;

@Path( "/api/rest/history/stores" )
@ApplicationScoped
public class RepoChangeResource
        implements RestResources
{
//    @Inject
//    private RepoChangeEventController ctl;
//
//    private final int DEFAULT_PAGE = 0;
//    private final int DEFAULT_PAGE_SIZE = 25;

    @GET
    @Produces( application_json )
    public Response getSummariesByPattern( final @QueryParam( "lastUpdate" ) String lastUpdate,
                                           final @QueryParam( "page" ) Integer page,
                                           final @QueryParam( "pageSize" ) Integer pageSize,
                                           final @QueryParam( "pattern" ) String pattern,
                                           @Context final UriInfo uriInfo )
    {
//        List<ChangeSummary> summaries = null;
//        int startIndex = startIndex( page, pageSize );
//        int curPageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
//        //TODO lastUpdate support not implement yet
//        List<ChangeEvent> events = ctl.getEventsByPattern( pattern, curPageSize, startIndex );
//        return Response.status( 200 )
//                       .entity( collectSummaryStats( events ) )
//                       .build();
        return Response.status(200).build();
    }


//    private List<ChangeSummaryStats> collectSummaryStats(List<ChangeEvent> events )
//    {
//        final Map<String, ChangeSummaryStats> stats = new HashMap<>();
//
//        events.forEach( e -> {
//            ChangeSummaryStats stat = stats.computeIfAbsent( e.getStoreKey(), k -> {
//                ChangeSummaryStats newStat = new ChangeSummaryStats();
//                newStat.setStoreKey( k );
//                newStat.setLastUpdate( e.getChangeTime() );
//                return newStat;
//            } );
//
//            switch ( e.getChangeType() )
//            {
//                case CREATE:
//                    stat.setCreates( stat.getCreates() + 1 );
//                    break;
//                case UPDATE:
//                    stat.setUpdates( stat.getUpdates() + 1 );
//                    break;
//                case DELETE:
//                    stat.setDeletes( stat.getDeletes() + 1 );
//                    break;
//                default:
//                    break;
//            }
//        } );
//
//        return new ArrayList<>( stats.values() );
//    }
//
//    private int startIndex( final Integer page, final Integer pageSize )
//    {
//        int curPage = page == null ? DEFAULT_PAGE : page;
//        int curPageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
//        return curPage * curPageSize;
//    }
}
