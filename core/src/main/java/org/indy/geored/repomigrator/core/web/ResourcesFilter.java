package org.indy.geored.repomigrator.core.web;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.*;
import java.io.IOException;



@ApplicationScoped
public class ResourcesFilter implements Filter {



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        if ( req.getRequestURI().matches( ".*(css|jpg|png|gif|js)" ) )
//        {
//            chain.doFilter( request, response );
//        }
//        else
//        {
//            req.getRequestDispatcher("/index.html").forward( request, response );
//        }
    }

    @Override
    public void destroy() {

    }
}
