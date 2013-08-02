package com.project.services;

import com.project.entities.Container;
import com.project.entities.Link;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Entity facade Service used for fonctional application
 * @author Selim.Bensenouci
 */
@Named(value = EntityFacade.EF_NAME)
@Stateless
@TransactionAttribute
public class EntityFacade implements Serializable{

    private final static Logger LOG = Logger.getLogger(EntityFacade.class);

    public static final String EF_NAME = "entityFacade";

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    protected void postConstruct() {
        LOG.debug("PostConstruct " + this);
    }


    /**
     * Method to merge person with the PersistantContext
     * @param container to merge              PersistentEntry
     * @return
     */
    public Container createContainer(Container container){
        return this.em.merge(container);
    }


    /**
     * Method to link person from the dataBase
     * @param link to delete
     */
    public void deleteLink(Link link){
        link.setArchived(true);
        this.em.merge(link);
        this.em.flush();
        this.em.clear();
    }

}
