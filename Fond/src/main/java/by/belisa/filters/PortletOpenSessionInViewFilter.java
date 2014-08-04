package by.belisa.filters;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.filter.ActionFilter;
import javax.portlet.filter.EventFilter;
import javax.portlet.filter.FilterChain;
import javax.portlet.filter.FilterConfig;
import javax.portlet.filter.RenderFilter;
import javax.portlet.filter.ResourceFilter;

import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.portlet.context.PortletApplicationContextUtils;

import by.belisa.dao.UserDao;

public class PortletOpenSessionInViewFilter implements RenderFilter, ActionFilter, EventFilter, ResourceFilter {
	private static Logger log = Logger.getLogger(PortletOpenSessionInViewFilter.class);
	private FilterConfig config;
	public PortletOpenSessionInViewFilter(){
		log.debug("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!created portletOpenSessionInViewFilter");
	}
	
	
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		ApplicationContext context = PortletApplicationContextUtils.getWebApplicationContext(config.getPortletContext());
		sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
		log.debug("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!filter context id "+context.hashCode());
		Session session = SessionFactoryUtils.getSession(sessionFactory, true);
		session.setFlushMode(FlushMode.AUTO);
		return session;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws PortletException {
		this.config = arg0;
		log.debug("!!!!!!!!!!!!!!!!!init filter");
		
	}

	@Override
	public void doFilter(RenderRequest req, RenderResponse resp,
			FilterChain chain) throws IOException, PortletException {
		log.debug("!!!!!!!!!!!!!!!!!do filter start");
		Session s = getSession();
		s.beginTransaction();
		chain.doFilter(req, resp);
		log.debug("!!!!!!!!!!!!!!!!!do filter finish");
		s.getTransaction().commit();
		s.close();
		
	}

	@Override
	public void doFilter(ActionRequest req, ActionResponse resp,
			FilterChain chain) throws IOException, PortletException {
		Session s = getSession();
		chain.doFilter(req, resp);
		s.close();
		
	}

	@Override
	public void doFilter(ResourceRequest req, ResourceResponse resp,
			FilterChain chain) throws IOException, PortletException {
		Session s = getSession();
		chain.doFilter(req, resp);
		s.close();
		
	}

	@Override
	public void doFilter(EventRequest req, EventResponse resp, FilterChain chain)
			throws IOException, PortletException {
		Session s = getSession();
		chain.doFilter(req, resp);
		s.close();
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	

}
