package model.paser.identificazione.cayenne;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import model.paser.anagrafiche.custom.VistaFoto;
import model.paser.identificazione.custom.Base;

/**
 * Class _Foto was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Foto extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String CODFOT_PK_COLUMN = "CODFOT";

    public static final Property<String> DIMFOT = Property.create("dimfot", String.class);
    public static final Property<Base> BASE = Property.create("base", Base.class);
    public static final Property<Base> BASE1 = Property.create("base1", Base.class);
    public static final Property<Base> BASE2 = Property.create("base2", Base.class);
    public static final Property<VistaFoto> VISTA_FOTO = Property.create("vistaFoto", VistaFoto.class);

    public void setDimfot(String dimfot) {
        writeProperty("dimfot", dimfot);
    }
    public String getDimfot() {
        return (String)readProperty("dimfot");
    }

    public void setBase(Base base) {
        setToOneTarget("base", base, true);
    }

    public Base getBase() {
        return (Base)readProperty("base");
    }


    public void setBase1(Base base1) {
        setToOneTarget("base1", base1, true);
    }

    public Base getBase1() {
        return (Base)readProperty("base1");
    }


    public void setBase2(Base base2) {
        setToOneTarget("base2", base2, true);
    }

    public Base getBase2() {
        return (Base)readProperty("base2");
    }


    public void setVistaFoto(VistaFoto vistaFoto) {
        setToOneTarget("vistaFoto", vistaFoto, true);
    }

    public VistaFoto getVistaFoto() {
        return (VistaFoto)readProperty("vistaFoto");
    }


}
