import model.Sale;
import service.ReportService;
import service.SaleService;
import utils.CsvReader;

import java.util.List;
import java.util.Map;

public class Main {

    // Caminho do arquivo CSV onde os dados de vendas estão armazenados
    private static final String FILE_PATH = "./src/main/resources/data.csv";

    public static void main(String[] args) {
        List<Sale> sales = CsvReader.readSales(FILE_PATH);

        // Gerar estatísticas
        Map<String, Double> totalBySeller = SaleService.totalSalesBySeller(sales);
        Map<String, Double> revenueByCategory = SaleService.revenueByCategory(sales);

        // Exibir relatórios
        ReportService.printReport("Total de Vendas por Vendedor", totalBySeller);
        ReportService.printReport("Faturamento por Categoria", revenueByCategory);
    }
}
