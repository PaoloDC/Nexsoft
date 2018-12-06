package model.paser.anagrafiche.cayenne;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _AnagraficaSegmenti was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _AnagraficaSegmenti extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String CODSEG_PK_COLUMN = "CODSEG";

    public static final Property<String> DESSEG = Property.create("desseg", String.class);

    public void setDesseg(String desseg) {
        writeProperty("desseg", desseg);
    }
    public String getDesseg() {
        return (String)readProperty("desseg");
    }

}
