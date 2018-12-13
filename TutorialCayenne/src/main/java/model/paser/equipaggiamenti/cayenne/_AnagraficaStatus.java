package model.paser.equipaggiamenti.cayenne;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import model.paser.equipaggiamenti.custom.ListiniUfficiali;

/**
 * Class _AnagraficaStatus was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AnagraficaStatus extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String STATUS_PK_COLUMN = "STATUS";

    public static final Property<String> DESSTS = Property.create("dessts", String.class);
    public static final Property<String> SEGNO = Property.create("segno", String.class);
    public static final Property<List<ListiniUfficiali>> LISTINI_UFFICIALIS = Property.create("listiniUfficialis", List.class);

    public void setDessts(String dessts) {
        writeProperty("dessts", dessts);
    }
    public String getDessts() {
        return (String)readProperty("dessts");
    }

    public void setSegno(String segno) {
        writeProperty("segno", segno);
    }
    public String getSegno() {
        return (String)readProperty("segno");
    }

    public void addToListiniUfficialis(ListiniUfficiali obj) {
        addToManyTarget("listiniUfficialis", obj, true);
    }
    public void removeFromListiniUfficialis(ListiniUfficiali obj) {
        removeToManyTarget("listiniUfficialis", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<ListiniUfficiali> getListiniUfficialis() {
        return (List<ListiniUfficiali>)readProperty("listiniUfficialis");
    }


}