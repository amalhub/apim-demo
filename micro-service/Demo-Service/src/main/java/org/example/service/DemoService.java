/*
 * Copyright (c) 2016, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.example.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.example.service.model.Location;
import org.example.service.model.Payload;

/**
 * This is the Microservice resource class.
 * See <a href="https://github.com/wso2/msf4j#getting-started">https://github.com/wso2/msf4j#getting-started</a>
 * for the usage of annotations.
 *
 * @since 1.0.0
 */
@Path("/service")
public class DemoService {

    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(@PathParam("name") String name) {
        System.out.println("Hello invoked");
        return "{\"message\" : \"Hello " + name + "\"}";
    }

    @GET
    @Path("/conditions/q/{state}/{city}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLocation(@PathParam("state") String state, @PathParam("city") String city) {
        System.out.println("Get Location invoked");
        return "{\"state\": \"" + state + "\", \"city\": \"" + city + "\"" +
                ", \"celsius\": 30}";
    }

    @GET
    @Path("/getFahrenheit/{celsius}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFahrenheit(@PathParam("celsius") String celsius) {
        System.out.println("Get fahrenheit invoked");
        double f = Double.parseDouble(celsius) * 1.8 + 32;
        return "{\"Fahrenheit\" : " + (int) f + "}";
    }

    @POST
    @Path("/send/location")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String postLocation(Payload payload) {
        System.out.println("POST Location invoked");
        String state = payload.getLocation().getState();
        String city = payload.getLocation().getCity();
        return "{\"received\": {\"state\": \"" + state + "\", \"city\": \"" + city + "\"}}";
    }

}
