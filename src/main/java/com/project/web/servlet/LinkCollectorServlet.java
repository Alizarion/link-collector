package com.project.web.servlet;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: selim.bensenouci
 * Date: 02/08/13
 * Time: 16:44
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(urlPatterns = "/grabber/servlet")
public class LinkCollectorServlet extends HttpServlet {

    private final static Logger LOG = Logger.getLogger(LinkCollectorServlet.class);


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.info("doGet from " + this);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOG.info("doPost from " + this);
        doGet(request,response);
    }
}
