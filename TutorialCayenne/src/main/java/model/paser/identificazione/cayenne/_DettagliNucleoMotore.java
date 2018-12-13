package model.paser.identificazione.cayenne;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import model.paser.anagrafiche.custom.DisposizioneCilindri;
import model.paser.anagrafiche.custom.TipoCombustibile;
import model.paser.identificazione.custom.CambiEPrestazioni;

/**
 * Class _DettagliNucleoMotore was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _DettagliNucleoMotore extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String NUCMOT_PK_COLUMN = "NUCMOT";

    public static final Property<Integer> CILIND = Property.create("cilind", Integer.class);
    public static final Property<String> CODCAT = Property.create("codcat", String.class);
    public static final Property<String> CODSOV = Property.create("codsov", String.class);
    public static final Property<Integer> ELECAC = Property.create("elecac", Integer.class);
    public static final Property<Integer> ELECAT = Property.create("elecat", Integer.class);
    public static final Property<Integer> ELEPBC = Property.create("elepbc", Integer.class);
    public static final Property<Integer> ELETMC = Property.create("eletmc", Integer.class);
    public static final Property<Integer> ELETRI = Property.create("eletri", Integer.class);
    public static final Property<Integer> ELETVC = Property.create("eletvc", Integer.class);
    public static final Property<Integer> ELETVT = Property.create("eletvt", Integer.class);
    public static final Property<Integer> NUMCIL = Property.create("numcil", Integer.class);
    public static final Property<Integer> NUMVAL = Property.create("numval", Integer.class);
    public static final Property<List<CambiEPrestazioni>> CAMBI_EPRESTAZIONIS = Property.create("cambiEPrestazionis", List.class);
    public static final Property<DisposizioneCilindri> DISPOSIZIONE_CILINDRI = Property.create("disposizioneCilindri", DisposizioneCilindri.class);
    public static final Property<TipoCombustibile> TIPO_COMBUSTIBILE = Property.create("tipoCombustibile", TipoCombustibile.class);

    public void setCilind(int cilind) {
        writeProperty("cilind", cilind);
    }
    public int getCilind() {
        Object value = readProperty("cilind");
        return (value != null) ? (Integer) value : 0;
    }

    public void setCodcat(String codcat) {
        writeProperty("codcat", codcat);
    }
    public String getCodcat() {
        return (String)readProperty("codcat");
    }

    public void setCodsov(String codsov) {
        writeProperty("codsov", codsov);
    }
    public String getCodsov() {
        return (String)readProperty("codsov");
    }

    public void setElecac(int elecac) {
        writeProperty("elecac", elecac);
    }
    public int getElecac() {
        Object value = readProperty("elecac");
        return (value != null) ? (Integer) value : 0;
    }

    public void setElecat(int elecat) {
        writeProperty("elecat", elecat);
    }
    public int getElecat() {
        Object value = readProperty("elecat");
        return (value != null) ? (Integer) value : 0;
    }

    public void setElepbc(int elepbc) {
        writeProperty("elepbc", elepbc);
    }
    public int getElepbc() {
        Object value = readProperty("elepbc");
        return (value != null) ? (Integer) value : 0;
    }

    public void setEletmc(int eletmc) {
        writeProperty("eletmc", eletmc);
    }
    public int getEletmc() {
        Object value = readProperty("eletmc");
        return (value != null) ? (Integer) value : 0;
    }

    public void setEletri(int eletri) {
        writeProperty("eletri", eletri);
    }
    public int getEletri() {
        Object value = readProperty("eletri");
        return (value != null) ? (Integer) value : 0;
    }

    public void setEletvc(int eletvc) {
        writeProperty("eletvc", eletvc);
    }
    public int getEletvc() {
        Object value = readProperty("eletvc");
        return (value != null) ? (Integer) value : 0;
    }

    public void setEletvt(int eletvt) {
        writeProperty("eletvt", eletvt);
    }
    public int getEletvt() {
        Object value = readProperty("eletvt");
        return (value != null) ? (Integer) value : 0;
    }

    public void setNumcil(int numcil) {
        writeProperty("numcil", numcil);
    }
    public int getNumcil() {
        Object value = readProperty("numcil");
        return (value != null) ? (Integer) value : 0;
    }

    public void setNumval(int numval) {
        writeProperty("numval", numval);
    }
    public int getNumval() {
        Object value = readProperty("numval");
        return (value != null) ? (Integer) value : 0;
    }

    public void addToCambiEPrestazionis(CambiEPrestazioni obj) {
        addToManyTarget("cambiEPrestazionis", obj, true);
    }
    public void removeFromCambiEPrestazionis(CambiEPrestazioni obj) {
        removeToManyTarget("cambiEPrestazionis", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<CambiEPrestazioni> getCambiEPrestazionis() {
        return (List<CambiEPrestazioni>)readProperty("cambiEPrestazionis");
    }


    public void setDisposizioneCilindri(DisposizioneCilindri disposizioneCilindri) {
        setToOneTarget("disposizioneCilindri", disposizioneCilindri, true);
    }

    public DisposizioneCilindri getDisposizioneCilindri() {
        return (DisposizioneCilindri)readProperty("disposizioneCilindri");
    }


    public void setTipoCombustibile(TipoCombustibile tipoCombustibile) {
        setToOneTarget("tipoCombustibile", tipoCombustibile, true);
    }

    public TipoCombustibile getTipoCombustibile() {
        return (TipoCombustibile)readProperty("tipoCombustibile");
    }


}