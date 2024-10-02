package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		
		// Repositório que tem o arquivo que será lido
		String path = "C:\\Users\\augusto.ludewig\\Downloads\\urna.txt";
		
		// Repositório para salvar os resultados
		String path2 = "C:\\Users\\augusto.ludewig\\Downloads\\urna_resultado.txt";
		
		Map<String, Integer> votacao = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				String nome = fields[0];
				Integer votos = Integer.valueOf(fields[1]);

				if (votacao.containsKey(nome) == true) {
					int votosComputados = votacao.get(nome);
					votosComputados = votosComputados + votos;
					votacao.put(nome, votosComputados);
				} else {
					votacao.put(nome, votos);
				}

				line = br.readLine();

			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {

				for (String key : votacao.keySet()) {
					bw.write(key + ": " + votacao.get(key) + "\n");
				}
			}

		} catch (Exception e) {
			System.out.println(e.getCause());
		}

	}

}
