package com.project.services;

import com.project.entities.PersistentEntry;

/**
 * Created with IntelliJ IDEA.
 * User: selim.bensenouci
 * Date: 02/08/13
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public class BookmarkletTemplateMbean extends ParameterMBean {

    private static final String JS_DIR = "css-dir";
    private static final String CSS_DIR = "js-dir";


    @Override
    public String getPropertiesFilename() {
        return "link-collector-bookmarklet.Properties";
    }

    public  String getJsDir() {
        return getProperty(JS_DIR);
    }

    public  String getCssDir() {
        return getProperty(CSS_DIR);
    }

    public  void setJsDir(String jsDir) {
        setProperty(JS_DIR,jsDir);
    }

    public  void setCssDir(String cssDir) {
        setProperty(CSS_DIR,cssDir);
    }
}
