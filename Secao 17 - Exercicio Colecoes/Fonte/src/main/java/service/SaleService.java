package service;

import model.Sale;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe responsável por fornecer métodos de serviço para o cálculo de totais de vendas.
 * A classe oferece funcionalidades para calcular o total de vendas realizadas por cada vendedor
 * e o faturamento total por categoria de produto.
 * --
 * Utiliza os dados de uma lista de vendas e retorna os resultados agrupados por vendedor ou categoria
 * em forma de mapas, onde a chave é o nome do vendedor ou da categoria e o valor é o total de vendas.
 */
public class SaleService {

    /**
     * Método para calcular o total de vendas por vendedor
     */
    public static Map<String, Double> totalSalesBySeller(List<Sale> sales) {
        // Criação de um mapa para armazenar o total de vendas por vendedor
        Map<String, Double> totalBySeller = new HashMap<>();

        // Iteração sobre cada venda na lista de vendas
        for (Sale sale : sales) {
            String seller = sale.getSeller();
            double value = sale.getValue();

            // Verifica se o vendedor já está presente no mapa
            if (totalBySeller.containsKey(seller)) {
                // Se estiver, soma o valor da venda ao total já existente
                totalBySeller.put(seller, totalBySeller.get(seller) + value);
            } else {
                // Caso o vendedor não esteja no mapa, adiciona o vendedor com o valor da venda
                totalBySeller.put(seller, value);
            }
        }

        // Retorna o mapa contendo o total de vendas por vendedor
        return totalBySeller;
    }

    /**
     * Método para calcular o faturamento total por categoria
     */
    public static Map<String, Double> revenueByCategory(List<Sale> sales) {
        // Criação de um mapa para armazenar o total de vendas por categoria
        Map<String, Double> totalByCategory = new HashMap<>();

        // Iteração sobre cada venda na lista de vendas
        for (Sale sale : sales) {
            String category = sale.getCategory();
            double value = sale.getValue();

            // Verifica se a categoria já está presente no mapa
            if (totalByCategory.containsKey(category)) {
                // Se estiver, soma o valor da venda ao total já existente
                totalByCategory.put(category, totalByCategory.get(category) + value);
            } else {
                // Caso a categoria não esteja no mapa, adiciona a categoria com o valor da venda
                totalByCategory.put(category, value);
            }
        }

        // Retorna o mapa contendo o faturamento por categoria
        return totalByCategory;
    }
}