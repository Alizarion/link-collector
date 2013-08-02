package com.project.entities;

import com.project.Helper;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: selim.bensenouci
 * Date: 02/08/13
 * Time: 15:10
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(catalog = Helper.ENTITIES_CATALOG,name = "links")
public class Link {

    @Id
    @TableGenerator(name="Link_SEQ", table="sequence",
            pkColumnName="SEQ_NAME", valueColumnName="SEQ_COUNT")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="Link_SEQ")
    @Column(name="id")
    private Long id;

    @Column(name="url")
    private String URL;

    @Column(name="domain_name")
    private String domainName;

    @Column(name="page_title")
    private String pageTitle;

    @Column(name="creation_date")
    private Date creationDate;

    @Column(name="archived")
    private Boolean archived;

    @ManyToOne
    @JoinColumn(name="container _id")
    private Container parentContainer;


    public Link() {
        this.creationDate = new Date();
        this.archived = false;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Container getParentContainer() {
        return parentContainer;
    }

    public void setParentContainer(Container parentContainer) {
        this.parentContainer = parentContainer;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Link)) return false;

        Link link = (Link) o;

        if (URL != null ? !URL.equals(link.URL) : link.URL != null)
            return false;
        if (archived != null ? !archived.equals(link.archived) :
                link.archived != null)
            return false;
        if (creationDate != null ? !creationDate.equals(link.creationDate) :
                link.creationDate != null)
            return false;
        if (domainName != null ? !domainName.equals(link.domainName) :
                link.domainName != null)
            return false;
        if (id != null ? !id.equals(link.id) : link.id != null) return false;
        if (pageTitle != null ? !pageTitle.equals(link.pageTitle) :
                link.pageTitle != null)
            return false;
        if (parentContainer != null ?
                !parentContainer.equals(link.parentContainer) :
                link.parentContainer != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (URL != null ? URL.hashCode() : 0);
        result = 31 * result + (domainName != null ? domainName.hashCode() : 0);
        result = 31 * result + (pageTitle != null ? pageTitle.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (archived != null ? archived.hashCode() : 0);
        result = 31 * result + (parentContainer != null ? parentContainer.hashCode() : 0);
        return result;
    }
}
