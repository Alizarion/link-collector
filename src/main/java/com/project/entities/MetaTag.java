package com.project.entities;

import com.project.Helper;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: selim.bensenouci
 * Date: 02/08/13
 * Time: 15:47
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(catalog = Helper.ENTITIES_CATALOG,name = "meta_tags")
public class MetaTag {

    @Id
    @TableGenerator(name="MetaTag_SEQ", table="sequence",
            pkColumnName="SEQ_NAME", valueColumnName="SEQ_COUNT")
    @GeneratedValue(strategy= GenerationType.TABLE, generator="MetaTag_SEQ")
    @Column(name="id")
    private Long id;

    @Column(name="tag_label")
    private String tagLabel;

    @ManyToOne
    @JoinColumn(name="link_id")
    private Link parentLink;

    @Column(name="creation_date")
    private Date creationDate;

    @Column(name="archived")
    private Boolean archived;

    public MetaTag() {
        this.creationDate = new Date();
        this.archived = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagLabel() {
        return tagLabel;
    }

    public void setTagLabel(String tagLabel) {
        this.tagLabel = tagLabel;
    }

    public Link getParentLink() {
        return parentLink;
    }

    public void setParentLink(Link parentLink) {
        this.parentLink = parentLink;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MetaTag)) return false;

        MetaTag metaTag = (MetaTag) o;

        if (archived != null ? !archived.equals(metaTag.archived) :
                metaTag.archived != null)
            return false;
        if (creationDate != null ? !creationDate.equals(metaTag.creationDate) :
                metaTag.creationDate != null)
            return false;
        if (id != null ? !id.equals(metaTag.id) : metaTag.id != null)
            return false;
        if (parentLink != null ? !parentLink.equals(metaTag.parentLink) :
                metaTag.parentLink != null)
            return false;
        if (tagLabel != null ? !tagLabel.equals(metaTag.tagLabel) :
                metaTag.tagLabel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tagLabel != null ?
                tagLabel.hashCode() : 0);
        result = 31 * result + (parentLink != null ?
                parentLink.hashCode() : 0);
        result = 31 * result + (creationDate != null ?
                creationDate.hashCode() : 0);
        result = 31 * result + (archived != null ?
                archived.hashCode() : 0);
        return result;
    }
}
