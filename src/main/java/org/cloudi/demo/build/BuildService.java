package org.cloudi.demo.build;
import java.util.Set;
import java.util.Collections;
import java.util.LinkedHashMap;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BuildService {

    public Set<Build> list() {
        Set<Build> builds = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
        builds.add(new Build("RHEL8.2-build-01", "Red Hat Enterprise Linux 8.2 Build-01"));
        builds.add(new Build("OCP4.5.1-build-01", "OpenShift Container Platform 4.5.1 Build-01"));
        return builds;
    }


}