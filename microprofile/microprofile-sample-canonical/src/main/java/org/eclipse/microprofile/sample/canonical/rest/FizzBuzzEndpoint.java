/*
 * Copyright (C) 2016, 2017 Antonio Goncalves and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.eclipse.microprofile.sample.canonical.rest;

import axity.appdynamics.clientrest.ControllerService;
import org.eclipse.microprofile.sample.canonical.utils.QLogger;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

@Path("/fizzbuzz")
public class FizzBuzzEndpoint {

    @Inject
    @QLogger
    private Logger logger;

    @Inject
    private ControllerService controllerService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<String> getTopCDs(List<Integer> body) {
        logger.info("Body "+  body);
        List<String> result = controllerService.buildFizzBuzz(body);
        return result;
    }


}
