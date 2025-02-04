package utils;

import model.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe responsável pela leitura do arquivo CSV contendo os dados das vendas.
 * Esta classe fornece um método para ler as informações de vendas a partir de um arquivo CSV
 * e retornar uma lista de objetos do tipo Sale.
 * --
 * O arquivo CSV deve estar no formato esperado, com os seguintes campos:
 * <ul>
 *     <li>ID_VENDA</li>
 *     <li>DATA</li>
 *     <li>VENDEDOR</li>
 *     <li>PRODUTO</li>
 *     <li>CATEGORIA</li>
 *     <li>VALOR</li>
 * </ul>
 */
public class CsvReader {

    /**
     * Lê os dados de vendas a partir de um arquivo CSV e os converte em uma lista de objetos Sale.
     */
    public static List<Sale> readSales(String filePath) {
        List<Sale> sales = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));

            // Primeira linha é lida e ignorada porque é o cabeçalho
            br.readLine();

            // Loop para ler todas as linhas do arquivo CSV
            String line = br.readLine();
            do {
                // Divide a linha usando ponto e vírgula como delimitador
                String[] data = line.split(";");

                // Converte os dados para os tipos apropriados
                int id = Integer.parseInt(data[0]);
                Date date = formatter.parse(data[1]);
                String seller = data[2];
                String product = data[3];
                String category = data[4];
                double value = Double.parseDouble(data[5]);

                // Adiciona o objeto à lista
                sales.add(new Sale(id, date, seller, product, category, value));
                line = br.readLine();
            } while (line != null);
        } catch (IOException e) {
            System.out.println("Problema ao ler arquivo.");
        } catch (ParseException e) {
            System.out.println("Erro ao realizar a conversão de valores.");
        } catch (NumberFormatException e) {
            System.out.println("Erro ao realizar a conversão de números.");
        } catch (Exception e) {
            System.out.println("Erro inesperado." + e.getMessage());
        }

        // Retorna a lista de vendas
        return sales;
    }
}