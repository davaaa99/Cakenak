//package session.security;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import model.Admin;
//
///**
// * 
// * @KoTA109
// */
//@WebFilter(filterName = "CheckAdmin",urlPatterns = {"/admin", "/admin/AdminIndex", "/admin/logoutadmin", "/admin/index.jsp"})
//public class CheckAdmin implements Filter {
//
//    public CheckAdmin() {
//    }
//
//    /**
//     *
//     * @param request The servlet request we are processing
//     * @param response The servlet response we are creating
//     * @param chain The filter chain we are processing
//     *
//     * @exception IOException if an input/output error occurs
//     * @exception ServletException if a servlet error occurs
//     */
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response,
//            FilterChain chain)
//            throws IOException, ServletException {
//
//    	
//    	
//        Admin user = (Admin) ((HttpServletRequest) request).getSession().getAttribute("LoginUser");
//        
//        if (user != null && user.getTipeakun().equalsIgnoreCase("ROLE_ADMIN")) {
//            chain.doFilter(request, response);
//        } else {
//            ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getRequestURI()+"login.jsp");
//        }
//
//    }
//
//    /**
//     * Destroy method for this filter
//     */
//    @Override
//    public void destroy() {
//    }
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//
//    }
//
//}
