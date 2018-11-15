package database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import database.bean.Cliente;
import database.model.ClienteModel;
import database.model.OrdineModel;

public class Main {

	public static final Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {

		LOG.info("INFO");
		LOG.error("ERRORE");
		LOG.debug("DEBUG");
		LOG.warn("WARN");
		ClienteModel cm = new ClienteModel();
		OrdineModel om = new OrdineModel();

		Scanner in = new Scanner(System.in);
		boolean esegui = true;
		do {
			System.out.println("\nCLIENTE - ORDINI" + "\n1) Inserisci nuovo cliente" + "\n2) Elimina Cliente"
					+ "\n3) Mostra tutti i clienti" + "\n4) Cerca cliente per ID" + "\n5) Inserisci Ordine"
					+ "\n6) Elimina Ordine" + "\n7) Esci\n");
			String op = in.nextLine();
			switch (op) {
			case "1":
				System.out.print("Digita Nome: ");
				String nome = in.nextLine();
				System.out.print("Digita Cognome: ");
				String cognome = in.nextLine();
				System.out.print("Digita Telefono: ");
				String telefono = in.nextLine();
				System.out.print("Digita Email: ");
				String email = in.nextLine();
				try {
					cm.insertCliente(nome, cognome, email, telefono);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "2":
				System.out.print("Digita ID del cliente da eliminare: ");
				int idEliminare = Integer.parseInt(in.nextLine());
				try {
					cm.deleteCliente(idEliminare);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "3":
				try {
					ArrayList<Cliente> lista = cm.selectClienti();
					System.out.println("Lista Clienti");
					for (Cliente c : lista) {
						System.out.println(c.toString());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "4":
				System.out.print("Digita ID del cliente da cercare: ");
				int idClienteDaCercare = Integer.parseInt(in.nextLine());
				try {
					Cliente c = cm.selectClienteByID(idClienteDaCercare);
					System.out.println("Cliente Trovato: " + c);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "5":
				boolean trovato = false;
				int idNuovoCliente = 0;
				
				do {
					System.out.print("Digita idCliente: ");
					idNuovoCliente = Integer.parseInt(in.nextLine());

					// controllo su idCliente
					try {
						for (int i : cm.selectIDsClienti()) {
							if (i == idNuovoCliente)
								trovato = true;
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					if (!trovato)
						System.err.println("\nID Cliente Non Presente!!!!\n");
				} while (!trovato);

				System.out.print("Digita data ordine: ");
				String data = in.nextLine();
				System.out.print("Digita importo: ");
				double importo = Double.parseDouble(in.nextLine());
				try {
					om.insertOrdine(idNuovoCliente, data, importo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case "6":
				System.out.print("Digita ID dell'ordine da eliminare: ");
				int idOrdineEliminare = Integer.parseInt(in.nextLine());
				try {
					om.deleteOrdine(idOrdineEliminare);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				break;
			case "7":
				esegui = false;
				break;
			default:
				System.err.println("Operazione non disponibile!!!");
				break;
			}
		} while (esegui);
		in.close();
		System.out.println("Programma Terminato");
	}
}
