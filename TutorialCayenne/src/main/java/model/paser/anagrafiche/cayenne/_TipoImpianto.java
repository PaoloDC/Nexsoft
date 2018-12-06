package model.paser.anagrafiche.cayenne;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import model.paser.identificazione.custom.DatiTecniciBase;

/**
 * Class _TipoImpianto was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _TipoImpianto extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String CODTIM_PK_COLUMN = "CODTIM";

    public static final Property<String> DESTIM = Property.create("destim", String.class);
    public static final Property<List<DatiTecniciBase>> DATI_TECNICI_BASES = Property.create("datiTecniciBases", List.class);

    public void setDestim(String destim) {
        writeProperty("destim", destim);
    }
    public String getDestim() {
        return (String)readProperty("destim");
    }

    public void addToDatiTecniciBases(DatiTecniciBase obj) {
        addToManyTarget("datiTecniciBases", obj, true);
    }
    public void removeFromDatiTecniciBases(DatiTecniciBase obj) {
        removeToManyTarget("datiTecniciBases", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<DatiTecniciBase> getDatiTecniciBases() {
        return (List<DatiTecniciBase>)readProperty("datiTecniciBases");
    }


}
