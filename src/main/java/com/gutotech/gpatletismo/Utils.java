package com.gutotech.gpatletismo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.gutotech.gpatletismo.model.Pais;

public class Utils {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Gustavo\\Downloads\\paises.html"));
		PrintWriter writer = new PrintWriter("C:\\Users\\Gustavo\\Downloads\\paises-inserts.sql");
		writer.write("INSERT INTO pais (nome, sigla, imagem_url)\nVALUES\n\t");

		Pais pais = new Pais();

		String line = "";
		while ((line = reader.readLine()) != null) {
			// sigla
			if (line.matches(".+>\\w{3}</td>")) {
				pais.setSigla(line.substring(line.length() - 8, line.length() - 5));
			}

			if (line.matches("<td><img alt=\"\" src=\"//upload.wikimedia.org/.+")
					|| line.matches("<td><span class=\"flagicon\"><img alt=\"\" src=\"//upload.wikimedia.org/.+")) {
				pais.setImagemUrl(line.substring(line.indexOf("//"), line.indexOf("\" decoding=\"async\"")));
			}

			// nome
			if (line.matches(".+title=\".+\">.+</a><.+")) {
				line = line.split("title=\"")[1];
				pais.setNome(line.substring(0, line.indexOf("\">")));

				writer.format("('%s', '%s', '%s'),\n\t", pais.getNome(), pais.getSigla(), pais.getImagemUrl());

				System.out.println(pais);
				pais = new Pais();
			}
		}

		reader.close();
		writer.close();
	}

}
