package model.paser.identificazione.cayenne;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import model.paser.anagrafiche.custom.TipoPneumatici;
import model.paser.identificazione.custom.Base;

/**
 * Class _Pneumatici was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Pneumatici extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ANNOXX_PK_COLUMN = "ANNOXX";
    public static final String CODALL_PK_COLUMN = "CODALL";
    public static final String MESEXX_PK_COLUMN = "MESEXX";
    public static final String TIPOXX_PK_COLUMN = "TIPOXX";
    public static final String TRENO_PK_COLUMN = "TRENO";

    public static final Property<Boolean> CARVCL = Property.create("carvcl", Boolean.class);
    public static final Property<Integer> DIAMME = Property.create("diamme", Integer.class);
    public static final Property<Integer> DIAMPO = Property.create("diampo", Integer.class);
    public static final Property<Integer> DIAMTO = Property.create("diamto", Integer.class);
    public static final Property<Integer> INDCAR = Property.create("indcar", Integer.class);
    public static final Property<String> INDVEL = Property.create("indvel", String.class);
    public static final Property<Boolean> INDVELS = Property.create("indvels", Boolean.class);
    public static final Property<Integer> LARGMM = Property.create("largmm", Integer.class);
    public static final Property<Integer> LARGPO = Property.create("largpo", Integer.class);
    public static final Property<String> PNEUMA = Property.create("pneuma", String.class);
    public static final Property<Boolean> PRESTA = Property.create("presta", Boolean.class);
    public static final Property<Integer> SPALLA = Property.create("spalla", Integer.class);
    public static final Property<String> TIRUPO = Property.create("tirupo", String.class);
    public static final Property<Base> BASE = Property.create("base", Base.class);
    public static final Property<Base> BASE1 = Property.create("base1", Base.class);
    public static final Property<Base> BASE2 = Property.create("base2", Base.class);
    public static final Property<TipoPneumatici> TIPO_PNEUMATICI = Property.create("tipoPneumatici", TipoPneumatici.class);

    public void setCarvcl(boolean carvcl) {
        writeProperty("carvcl", carvcl);
    }
	public boolean isCarvcl() {
        Boolean value = (Boolean)readProperty("carvcl");
        return (value != null) ? value.booleanValue() : false;
    }

    public void setDiamme(int diamme) {
        writeProperty("diamme", diamme);
    }
    public int getDiamme() {
        Object value = readProperty("diamme");
        return (value != null) ? (Integer) value : 0;
    }

    public void setDiampo(int diampo) {
        writeProperty("diampo", diampo);
    }
    public int getDiampo() {
        Object value = readProperty("diampo");
        return (value != null) ? (Integer) value : 0;
    }

    public void setDiamto(int diamto) {
        writeProperty("diamto", diamto);
    }
    public int getDiamto() {
        Object value = readProperty("diamto");
        return (value != null) ? (Integer) value : 0;
    }

    public void setIndcar(int indcar) {
        writeProperty("indcar", indcar);
    }
    public int getIndcar() {
        Object value = readProperty("indcar");
        return (value != null) ? (Integer) value : 0;
    }

    public void setIndvel(String indvel) {
        writeProperty("indvel", indvel);
    }
    public String getIndvel() {
        return (String)readProperty("indvel");
    }

    public void setIndvels(boolean indvels) {
        writeProperty("indvels", indvels);
    }
	public boolean isIndvels() {
        Boolean value = (Boolean)readProperty("indvels");
        return (value != null) ? value.booleanValue() : false;
    }

    public void setLargmm(int largmm) {
        writeProperty("largmm", largmm);
    }
    public int getLargmm() {
        Object value = readProperty("largmm");
        return (value != null) ? (Integer) value : 0;
    }

    public void setLargpo(int largpo) {
        writeProperty("largpo", largpo);
    }
    public int getLargpo() {
        Object value = readProperty("largpo");
        return (value != null) ? (Integer) value : 0;
    }

    public void setPneuma(String pneuma) {
        writeProperty("pneuma", pneuma);
    }
    public String getPneuma() {
        return (String)readProperty("pneuma");
    }

    public void setPresta(boolean presta) {
        writeProperty("presta", presta);
    }
	public boolean isPresta() {
        Boolean value = (Boolean)readProperty("presta");
        return (value != null) ? value.booleanValue() : false;
    }

    public void setSpalla(int spalla) {
        writeProperty("spalla", spalla);
    }
    public int getSpalla() {
        Object value = readProperty("spalla");
        return (value != null) ? (Integer) value : 0;
    }

    public void setTirupo(String tirupo) {
        writeProperty("tirupo", tirupo);
    }
    public String getTirupo() {
        return (String)readProperty("tirupo");
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


    public void setTipoPneumatici(TipoPneumatici tipoPneumatici) {
        setToOneTarget("tipoPneumatici", tipoPneumatici, true);
    }

    public TipoPneumatici getTipoPneumatici() {
        return (TipoPneumatici)readProperty("tipoPneumatici");
    }


}
