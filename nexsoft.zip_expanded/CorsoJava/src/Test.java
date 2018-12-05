
public class Test {
	public static void main(String[] args) {
		TipoOmologazioneVCL flagTipoVeicolo = TipoOmologazioneVCL.N;
		System.out.println(flagTipoVeicolo.name());
		System.out.println(flagTipoVeicolo.getDescrizione());
	}
	
	private TipoOmologazioneVCL flagTipoVeicolo;
	
	public enum TipoOmologazioneVCL {
		S("omologazione autovettura"), 
		N("omologazione autocarro"), 
		O("omologazione autovettura, con possibilità di omologazione autocarro");

		private String descrizione;
		
		TipoOmologazioneVCL(String s) {
			descrizione = s;
		}
		
		public String getDescrizione() {
			return descrizione;
		}
	}
}
