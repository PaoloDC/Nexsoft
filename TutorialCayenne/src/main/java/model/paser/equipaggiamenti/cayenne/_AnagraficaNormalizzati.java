package model.paser.equipaggiamenti.cayenne;

import java.util.Date;
import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import model.paser.equipaggiamenti.custom.AnagraficaUfficiali;

/**
 * Class _AnagraficaNormalizzati was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AnagraficaNormalizzati extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String CODQRN_PK_COLUMN = "CODQRN";

    public static final Property<Date> DATPRU = Property.create("datpru", Date.class);
    public static final Property<String> DESNOR = Property.create("desnor", String.class);
    public static final Property<Boolean> FLAPRU = Property.create("flapru", Boolean.class);
    public static final Property<List<AnagraficaUfficiali>> ANAGRAFICA_UFFICIALIS = Property.create("anagraficaUfficialis", List.class);

    public void setDatpru(Date datpru) {
        writeProperty("datpru", datpru);
    }
    public Date getDatpru() {
        return (Date)readProperty("datpru");
    }

    public void setDesnor(String desnor) {
        writeProperty("desnor", desnor);
    }
    public String getDesnor() {
        return (String)readProperty("desnor");
    }

    public void setFlapru(boolean flapru) {
        writeProperty("flapru", flapru);
    }
	public boolean isFlapru() {
        Boolean value = (Boolean)readProperty("flapru");
        return (value != null) ? value.booleanValue() : false;
    }

    public void addToAnagraficaUfficialis(AnagraficaUfficiali obj) {
        addToManyTarget("anagraficaUfficialis", obj, true);
    }
    public void removeFromAnagraficaUfficialis(AnagraficaUfficiali obj) {
        removeToManyTarget("anagraficaUfficialis", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<AnagraficaUfficiali> getAnagraficaUfficialis() {
        return (List<AnagraficaUfficiali>)readProperty("anagraficaUfficialis");
    }


}
