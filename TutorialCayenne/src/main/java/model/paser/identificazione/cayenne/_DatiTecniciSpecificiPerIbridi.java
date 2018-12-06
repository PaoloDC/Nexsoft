package model.paser.identificazione.cayenne;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import model.paser.identificazione.custom.Base;

/**
 * Class _DatiTecniciSpecificiPerIbridi was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _DatiTecniciSpecificiPerIbridi extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ANNOXX_PK_COLUMN = "ANNOXX";
    public static final String CODALL_PK_COLUMN = "CODALL";
    public static final String MESEXX_PK_COLUMN = "MESEXX";

    public static final Property<String> CODIBR = Property.create("codibr", String.class);
    public static final Property<Integer> COPGMI = Property.create("copgmi", Integer.class);
    public static final Property<Integer> COPKGM = Property.create("copkgm", Integer.class);
    public static final Property<Integer> COPPNM = Property.create("coppnm", Integer.class);
    public static final Property<String> ELEPIN = Property.create("elepin", String.class);
    public static final Property<String> ELEPUR = Property.create("elepur", String.class);
    public static final Property<Integer> POTCVX = Property.create("potcvx", Integer.class);
    public static final Property<Integer> POTGMI = Property.create("potgmi", Integer.class);
    public static final Property<Integer> POTKWX = Property.create("potkwx", Integer.class);
    public static final Property<Base> BASE = Property.create("base", Base.class);
    public static final Property<Base> BASE1 = Property.create("base1", Base.class);
    public static final Property<Base> BASE2 = Property.create("base2", Base.class);

    public void setCodibr(String codibr) {
        writeProperty("codibr", codibr);
    }
    public String getCodibr() {
        return (String)readProperty("codibr");
    }

    public void setCopgmi(int copgmi) {
        writeProperty("copgmi", copgmi);
    }
    public int getCopgmi() {
        Object value = readProperty("copgmi");
        return (value != null) ? (Integer) value : 0;
    }

    public void setCopkgm(int copkgm) {
        writeProperty("copkgm", copkgm);
    }
    public int getCopkgm() {
        Object value = readProperty("copkgm");
        return (value != null) ? (Integer) value : 0;
    }

    public void setCoppnm(int coppnm) {
        writeProperty("coppnm", coppnm);
    }
    public int getCoppnm() {
        Object value = readProperty("coppnm");
        return (value != null) ? (Integer) value : 0;
    }

    public void setElepin(String elepin) {
        writeProperty("elepin", elepin);
    }
    public String getElepin() {
        return (String)readProperty("elepin");
    }

    public void setElepur(String elepur) {
        writeProperty("elepur", elepur);
    }
    public String getElepur() {
        return (String)readProperty("elepur");
    }

    public void setPotcvx(int potcvx) {
        writeProperty("potcvx", potcvx);
    }
    public int getPotcvx() {
        Object value = readProperty("potcvx");
        return (value != null) ? (Integer) value : 0;
    }

    public void setPotgmi(int potgmi) {
        writeProperty("potgmi", potgmi);
    }
    public int getPotgmi() {
        Object value = readProperty("potgmi");
        return (value != null) ? (Integer) value : 0;
    }

    public void setPotkwx(int potkwx) {
        writeProperty("potkwx", potkwx);
    }
    public int getPotkwx() {
        Object value = readProperty("potkwx");
        return (value != null) ? (Integer) value : 0;
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


}
