package model.paser.equipaggiamenti.cayenne;

import java.util.Date;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import model.paser.equipaggiamenti.custom.ComposizionePacchetti;
import model.paser.identificazione.custom.Base;

/**
 * Class _Inclusioni was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Inclusioni extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ANNOXX_PK_COLUMN = "ANNOXX";
    public static final String CODALL_PK_COLUMN = "CODALL";
    public static final String CODQR1_PK_COLUMN = "CODQR1";
    public static final String CODQR2_PK_COLUMN = "CODQR2";
    public static final String DATACO_PK_COLUMN = "DATACO";
    public static final String MESEXX_PK_COLUMN = "MESEXX";

    public static final Property<Date> DATAVA = Property.create("datava", Date.class);
    public static final Property<Base> BASE = Property.create("base", Base.class);
    public static final Property<Base> BASE1 = Property.create("base1", Base.class);
    public static final Property<Base> BASE2 = Property.create("base2", Base.class);
    public static final Property<ComposizionePacchetti> COMPOSIZIONE_PACCHETTI = Property.create("composizionePacchetti", ComposizionePacchetti.class);
    public static final Property<ComposizionePacchetti> COMPOSIZIONE_PACCHETTI1 = Property.create("composizionePacchetti1", ComposizionePacchetti.class);

    public void setDatava(Date datava) {
        writeProperty("datava", datava);
    }
    public Date getDatava() {
        return (Date)readProperty("datava");
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


    public void setComposizionePacchetti(ComposizionePacchetti composizionePacchetti) {
        setToOneTarget("composizionePacchetti", composizionePacchetti, true);
    }

    public ComposizionePacchetti getComposizionePacchetti() {
        return (ComposizionePacchetti)readProperty("composizionePacchetti");
    }


    public void setComposizionePacchetti1(ComposizionePacchetti composizionePacchetti1) {
        setToOneTarget("composizionePacchetti1", composizionePacchetti1, true);
    }

    public ComposizionePacchetti getComposizionePacchetti1() {
        return (ComposizionePacchetti)readProperty("composizionePacchetti1");
    }


}