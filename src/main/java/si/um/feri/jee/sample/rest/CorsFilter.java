package si.um.feri.jee.sample.rest;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        fillCors(responseContext.getHeaders());

        // Handle preflight requests
        if (requestContext.getRequest().getMethod().equals("OPTIONS")) {
            responseContext.setStatus(200);
            responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            responseContext.getHeaders().add("Access-Control-Allow-Headers", "Content-Type, Authorization");
            responseContext.getHeaders().add("Access-Control-Max-Age", "86400");
        }

        if (requestContext.getRequest().getMethod().equals("PUT")) {
            responseContext.setStatus(200);
            responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
            responseContext.getHeaders().add("Access-Control-Allow-Headers", "Content-Type, Authorization");
            responseContext.getHeaders().add("Access-Control-Max-Age", "86400");
        }
    }

    public static void fillCors(MultivaluedMap<String, Object> m) {
        m.add("Access-Control-Allow-Origin", "*");
        m.add("Access-Control-Allow-Credentials", "true");
        m.add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        m.add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
    }

}
