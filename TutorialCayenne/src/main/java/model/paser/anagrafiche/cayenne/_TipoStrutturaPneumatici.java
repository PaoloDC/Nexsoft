package model.paser.anagrafiche.cayenne;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

/**
 * Class _TipoStrutturaPneumatici was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _TipoStrutturaPneumatici extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String FLGSTR_PK_COLUMN = "FLGSTR";

    public static final Property<String> DESSTR = Property.create("desstr", String.class);

    public void setDesstr(String desstr) {
        writeProperty("desstr", desstr);
    }
    public String getDesstr() {
        return (String)readProperty("desstr");
    }

}
