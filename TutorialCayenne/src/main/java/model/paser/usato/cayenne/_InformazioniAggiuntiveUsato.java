package model.paser.usato.cayenne;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;

import model.paser.anagrafiche.custom.AnagraficaMotivazioniPeriodiQuotazioniUsato;
import model.paser.identificazione.custom.Base;

/**
 * Class _InformazioniAggiuntiveUsato was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _InformazioniAggiuntiveUsato extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ANNOXX_PK_COLUMN = "ANNOXX";
    public static final String CODALL_PK_COLUMN = "CODALL";
    public static final String MESEXX_PK_COLUMN = "MESEXX";

    public static final Property<String> PERFIQ = Property.create("perfiq", String.class);
    public static final Property<String> PERIIQ = Property.create("periiq", String.class);
    public static final Property<AnagraficaMotivazioniPeriodiQuotazioniUsato> ANAGRAFICA_MOTIVAZIONI_PERIODI_QUOTAZIONI_USATO = Property.create("anagraficaMotivazioniPeriodiQuotazioniUsato", AnagraficaMotivazioniPeriodiQuotazioniUsato.class);
    public static final Property<Base> BASE = Property.create("base", Base.class);
    public static final Property<Base> BASE1 = Property.create("base1", Base.class);
    public static final Property<Base> BASE2 = Property.create("base2", Base.class);

    public void setPerfiq(String perfiq) {
        writeProperty("perfiq", perfiq);
    }
    public String getPerfiq() {
        return (String)readProperty("perfiq");
    }

    public void setPeriiq(String periiq) {
        writeProperty("periiq", periiq);
    }
    public String getPeriiq() {
        return (String)readProperty("periiq");
    }

    public void setAnagraficaMotivazioniPeriodiQuotazioniUsato(AnagraficaMotivazioniPeriodiQuotazioniUsato anagraficaMotivazioniPeriodiQuotazioniUsato) {
        setToOneTarget("anagraficaMotivazioniPeriodiQuotazioniUsato", anagraficaMotivazioniPeriodiQuotazioniUsato, true);
    }

    public AnagraficaMotivazioniPeriodiQuotazioniUsato getAnagraficaMotivazioniPeriodiQuotazioniUsato() {
        return (AnagraficaMotivazioniPeriodiQuotazioniUsato)readProperty("anagraficaMotivazioniPeriodiQuotazioniUsato");
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
