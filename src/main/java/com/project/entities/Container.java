package com.project.entities;

import com.project.Helper;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: selim.bensenouci
 * Date: 02/08/13
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
@NamedQuery(name =Container.FIND_CONTAINER_BY_UUID ,query = "select c " +
        "from Container c  where c.UUID = :uuid")
@Table(catalog = Helper.ENTITIES_CATALOG,name = "container")
public class Container {

    public static final String FIND_CONTAINER_BY_UUID =
            "Container.FIND_CONTAINER_BY_UUID";

    @Id
    @TableGenerator(name="Container_SEQ", table="sequence",
            pkColumnName="SEQ_NAME", valueColumnName="SEQ_COUNT")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="Container_SEQ")
    @Column(name="id")
    private Long id;

    @Column(name="UUID")
    private String UUID;

    @Column(name="name")
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Set<Link> links = new HashSet<Link>();

    public Container() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Link> getLinks() {
        return links;
    }

    public void setLinks(Set<Link> links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Container)) return false;

        Container container = (Container) o;

        if (UUID != null ? !UUID.equals(container.UUID) :
                container.UUID != null)
            return false;
        if (id != null ? !id.equals(container.id) :
                container.id != null)
            return false;
        if (links != null ? !links.equals(container.links) :
                container.links != null)
            return false;
        if (name != null ? !name.equals(container.name) :
                container.name != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (UUID != null ? UUID.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        return result;
    }

    @PrePersist
    public void prePersist(){
        this.UUID = java.util.UUID.randomUUID().toString();
    }
}


