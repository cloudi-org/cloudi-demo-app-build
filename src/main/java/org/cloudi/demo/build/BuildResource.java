package org.cloudi.demo.build;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.Inject;


@Path("/builds")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BuildResource {

    @Inject
    BuildService service;

    private Set<Build> builds = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public BuildResource() {
    }

    @GET
    public Set<Build> list() {
        if (builds.size() == 0){
            builds = service.list();
        }
        return builds;
    }

    @POST
    public Set<Build> add(Build build) {
        builds.add(build);
        return builds;
    }

    @DELETE
    public Set<Build> delete(Build build) {
        builds.removeIf(existingBuild -> existingBuild.name.contentEquals(build.name));
        return builds;
    }
}
