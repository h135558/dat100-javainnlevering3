package no.hvl.dat100.oppgave3;

import java.util.Arrays;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {
	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggtabell;
	}

	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++)
			if (innleggtabell[i].erLik(innlegg))
				return i;
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
			if (finnInnlegg(innlegg) != -1)
				return true;
		return false;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;
	}

	public boolean leggTil(Innlegg innlegg) {
		if (!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(innleggtabell.length).append("\n");

		for (int i = 0; i < nesteledig; i++)
			sb.append(innleggtabell[i].toString());

		return sb.toString();
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		innleggtabell = Arrays.copyOf(innleggtabell, innleggtabell.length * 2);
	}

	public boolean leggTilUtvid(Innlegg innlegg) {
		if (!ledigPlass())
			utvid();

		return (leggTil(innlegg)) ? true : false;
	}

	public boolean slett(Innlegg innlegg) {
		int index = finnInnlegg(innlegg);

		if (index == -1)
			return false;

		innleggtabell[index] = innleggtabell[nesteledig - 1];
		innleggtabell[nesteledig - 1] = null;
		nesteledig--;
		return true;

	}

	public int[] search(String keyword) {
		int antall = 0;
		String id = "";
		
		for (int i = 0; i < nesteledig; i++)
			if (innleggtabell[i].toString().contains(keyword))
				id += id + ",";
		
		id = id.substring(0, id.length() - 1);
		
		String ids[] = id.split(",");
		
		int idInt[] = new int[antall];
		
		for (int i = 0; i < idInt.length; i++)
			idInt[i] = Integer.parseInt(ids[i]);
		
		return idInt;
	}
}