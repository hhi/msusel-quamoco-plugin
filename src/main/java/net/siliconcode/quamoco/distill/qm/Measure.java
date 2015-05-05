/**
 *
 */
package net.siliconcode.quamoco.distill.qm;

import java.util.ArrayList;
import java.util.List;

/**
 * Measure -
 *
 * @author isaac
 */
public class Measure extends AbstractQMEntity {

    private String                 characterises;
    private String                 originatesFrom;
    private String                 refines;
    private String                 parent;
    private String                 title;
    private String                 type;
    private String                 taggedBy;
    private final List<Annotation> annotations;
    private final List<Measure>    measures;

    /**
     *
     */
    public Measure(String name, String description, String title, String parent, String characterises, String type,
            String taggedBy, String originatesFrom, String refines, String id)
    {
        annotations = new ArrayList<>();
        measures = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.title = title;
        this.parent = parent;
        this.characterises = characterises;
        this.type = type;
        this.taggedBy = taggedBy;
        this.id = id;
        this.refines = refines;
    }

    public void addAnnotation(Annotation ann)
    {
        if (ann == null || annotations.contains(ann))
        {
            return;
        }

        annotations.add(ann);
    }

    /**
     * @param measure
     *            the measure to add
     */
    public void addMeasure(Measure measure)
    {
        if (measure == null || measures.contains(measure))
        {
            return;
        }

        measures.add(measure);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Measure other = (Measure) obj;
        if (characterises == null)
        {
            if (other.characterises != null)
            {
                return false;
            }
        }
        else if (!characterises.equals(other.characterises))
        {
            return false;
        }
        if (description == null)
        {
            if (other.description != null)
            {
                return false;
            }
        }
        else if (!description.equals(other.description))
        {
            return false;
        }
        if (measures == null)
        {
            if (other.measures != null)
            {
                return false;
            }
        }
        else if (!measures.equals(other.measures))
        {
            return false;
        }
        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        }
        else if (!name.equals(other.name))
        {
            return false;
        }
        if (originatesFrom == null)
        {
            if (other.originatesFrom != null)
            {
                return false;
            }
        }
        else if (!originatesFrom.equals(other.originatesFrom))
        {
            return false;
        }
        if (parent == null)
        {
            if (other.parent != null)
            {
                return false;
            }
        }
        else if (!parent.equals(other.parent))
        {
            return false;
        }
        if (refines == null)
        {
            if (other.refines != null)
            {
                return false;
            }
        }
        else if (!refines.equals(other.refines))
        {
            return false;
        }
        if (taggedBy == null)
        {
            if (other.taggedBy != null)
            {
                return false;
            }
        }
        else if (!taggedBy.equals(other.taggedBy))
        {
            return false;
        }
        if (title == null)
        {
            if (other.title != null)
            {
                return false;
            }
        }
        else if (!title.equals(other.title))
        {
            return false;
        }
        if (type == null)
        {
            if (other.type != null)
            {
                return false;
            }
        }
        else if (!type.equals(other.type))
        {
            return false;
        }
        return true;
    }

    /**
     * @return the characterises
     */
    public String getCharacterises()
    {
        return characterises;
    }

    /**
     * @return the originatesFrom
     */
    public String getOriginatesFrom()
    {
        return originatesFrom;
    }

    /**
     * @return the parent
     */
    public String getParent()
    {
        return parent;
    }

    /**
     * @return the refines
     */
    public String getRefines()
    {
        return refines;
    }

    /**
     * @return the taggedBy
     */
    public String getTaggedBy()
    {
        return taggedBy;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (characterises == null ? 0 : characterises.hashCode());
        result = prime * result + (description == null ? 0 : description.hashCode());
        result = prime * result + (measures == null ? 0 : measures.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (originatesFrom == null ? 0 : originatesFrom.hashCode());
        result = prime * result + (parent == null ? 0 : parent.hashCode());
        result = prime * result + (refines == null ? 0 : refines.hashCode());
        result = prime * result + (taggedBy == null ? 0 : taggedBy.hashCode());
        result = prime * result + (title == null ? 0 : title.hashCode());
        result = prime * result + (type == null ? 0 : type.hashCode());
        return result;
    }

    public void removeAnnotation(Annotation ann)
    {
        if (ann == null || !annotations.contains(ann))
        {
            return;
        }

        annotations.remove(ann);
    }

    /**
     * @param measure
     *            the measure to remove
     */
    public void removeMeasure(Measure measure)
    {
        if (measure == null || !measures.contains(measure))
        {
            return;
        }

        measures.remove(measure);
    }

    /**
     * @param characterises
     *            the characterises to set
     */
    public void setCharacterises(String characterises)
    {
        this.characterises = characterises;
    }

    /**
     * @param originatesFrom
     *            the originatesFrom to set
     */
    public void setOriginatesFrom(String originatesFrom)
    {
        this.originatesFrom = originatesFrom;
    }

    /**
     * @param parent
     *            the parent to set
     */
    public void setParent(String parent)
    {
        this.parent = parent;
    }

    /**
     * @param refines
     *            the refines to set
     */
    public void setRefines(String refines)
    {
        this.refines = refines;
    }

    /**
     * @param taggedBy
     *            the taggedBy to set
     */
    public void setTaggedBy(String taggedBy)
    {
        this.taggedBy = taggedBy;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /*
     * (non-Javadoc)
     * @see net.siliconcode.quamoco.swing.qm.AbstractQMEntity#resolve()
     */
    @Override
    public void resolve()
    {
        // TODO Auto-generated method stub

    }

}
