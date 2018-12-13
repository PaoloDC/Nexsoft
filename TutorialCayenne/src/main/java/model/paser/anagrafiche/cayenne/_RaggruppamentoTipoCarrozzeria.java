package model.paser.anagrafiche.cayenne;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _RaggruppamentoTipoCarrozzeria was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _RaggruppamentoTipoCarrozzeria extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String TIPCAR_PK_COLUMN = "TIPCAR";

    public static final Property<String> DESSIG = Property.create("dessig", String.class);

    public void setDessig(String dessig) {
        writeProperty("dessig", dessig);
    }
    public String getDessig() {
        return (String)readProperty("dessig");
    }

}