import model.Sale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.SaleService;

import java.util.*;

public class SalesTest {

    @Test
    @DisplayName("Valor total vendido por vendedor.")
    void testTotalSalesBySeller() {
        // Dados de exemplo
        List<Sale> sales = new ArrayList<>();
        Calendar c = Calendar.getInstance();

        sales.add(new Sale(1, c.getTime() ,"Carlos", "iPhone", "Eletrônicos", 500));
        sales.add(new Sale(2, c.getTime() ,"Carlos", "Android", "Eletrônicos", 500));
        sales.add(new Sale(3, c.getTime() ,"Fernanda", "Android", "Eletrônicos", 450));
        sales.add(new Sale(4, c.getTime() ,"Fernanda", "Android", "Eletrônicos", 620));
        sales.add(new Sale(5, c.getTime() ,"Fernanda", "iPhone", "Eletrônicos", 550));

        // Resultado esperado
        Map<String, Double> expected = new HashMap<>();
        expected.put("Carlos", 1000.0);
        expected.put("Fernanda", 1620D);

        // Chamada ao método
        Map<String, Double> result = SaleService.totalSalesBySeller(sales);

        // Verificação do resultado
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Valor total vendido por categoria.")
    void testRevenueByCategory() {
        // Dados de exemplo
        List<Sale> sales = new ArrayList<>();
        Calendar c = Calendar.getInstance();

        sales.add(new Sale(1, c.getTime() ,"Carlos", "iPhone", "Eletrônicos", 500));
        sales.add(new Sale(2, c.getTime() ,"Carlos", "HD Externo 1TB", "Armazenamento", 500));
        sales.add(new Sale(3, c.getTime() ,"Fernanda", "SSD M2", "Armazenamento", 450));
        sales.add(new Sale(4, c.getTime() ,"Fernanda", "SSD M2", "Armazenamento", 620));
        sales.add(new Sale(5, c.getTime() ,"Fernanda", "SSD M2", "Armazenamento", 550));

        // Resultado esperado
        Map<String, Double> expected = new HashMap<>();
        expected.put("Eletrônicos", 500.0);
        expected.put("Armazenamento", 2120.0);

        // Chamada ao método
        Map<String, Double> result = SaleService.revenueByCategory(sales);

        // Verificação do resultado
        Assertions.assertEquals(expected, result);
    }
}