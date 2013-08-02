package com.project.web.controlers;

import com.project.entities.Container;
import com.project.services.EntityFacade;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: selim.bensenouci
 * Date: 02/08/13
 * Time: 16:22
 * To change this template use File | Settings | File Templates.
 */
@Named
@ConversationScoped
public class ContainerCtrl implements Serializable {

    private final static Logger LOG = Logger.getLogger(ContainerCtrl.class);

    private Container selectedContainer;

    @Inject
    EntityFacade entityFacade;

    @PostConstruct
    private void postInit(){
        LOG.info("@PostConstruct " + this );
        this.selectedContainer = new Container();
    }

    public Container getSelectedContainer() {
        return selectedContainer;
    }

    public void setSelectedContainer(Container selectedContainer) {
        this.selectedContainer = selectedContainer;
    }

    public void createContainer(){
        entityFacade.createContainer(this.selectedContainer);
    }

}
