package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave3.*;
import no.hvl.dat100.oppgave1.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		PrintWriter writer;
		try {
			writer = new PrintWriter(mappe + filnavn);
			writer.print(samling.toString());
			writer.close();

			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return false;
	}
}
