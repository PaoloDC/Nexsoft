package model.paser.anagrafiche.cayenne;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _Consumo was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _TipoConsumo extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String CODCON_PK_COLUMN = "CODCON";

    public static final Property<String> DESCON = Property.create("descon", String.class);
    public static final Property<String> TIPCON = Property.create("tipcon", String.class);

    public void setDescon(String descon) {
        writeProperty("descon", descon);
    }
    public String getDescon() {
        return (String)readProperty("descon");
    }

    public void setTipcon(String tipcon) {
        writeProperty("tipcon", tipcon);
    }
    public String getTipcon() {
        return (String)readProperty("tipcon");
    }

}
