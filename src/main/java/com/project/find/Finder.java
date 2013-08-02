package com.project.find;

import com.project.entities.Container;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * Created with IntelliJ IDEA.
 * User: selim.bensenouci
 * Date: 02/08/13
 * Time: 15:58
 * To change this template use File | Settings | File Templates.
 */
public class Finder {

    EntityManager em;

    public Finder(EntityManager em) {
        this.em = em;
    }

    /**
     * Method to find Container using UUID
     * @param uuid
     * @return
     */
    public Container findContainerByUUID(final String uuid){
        try{
            return (Container) em.createNamedQuery(Container.FIND_CONTAINER_BY_UUID).
                    setParameter("uuid",uuid ).getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

}
