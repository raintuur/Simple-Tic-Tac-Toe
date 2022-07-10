import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCompanies = scanner.nextInt();
        int[] companyNumbers = generateCompaniesNumbers(numberOfCompanies);
        int[] companiesYearlyIncome = getYearlyIncomesFromInput(scanner, numberOfCompanies);
        int[] companiesTaxPercentage = getTaxPercentagesFromInput(scanner, numberOfCompanies);
        double[] companiesTaxPaid = calculateTaxPaidInfo(companiesYearlyIncome, companiesTaxPercentage);
        System.out.println(getCompanyNumberThatPaidTheMostTax(companiesTaxPaid, companyNumbers));
    }

    private static int[] generateCompaniesNumbers(int numberOfCompanies) {
        int[] companyNumbers = new int[numberOfCompanies];
        for (int i = 0; i < numberOfCompanies; i++) {
            companyNumbers[i] = i + 1;
        }
        return companyNumbers;
    }

    private static int[] getYearlyIncomesFromInput(Scanner scanner, int numberOfCompanies) {
        int[] companiesYearlyIncome = new int[numberOfCompanies];
        for (int i = 0; i < numberOfCompanies; i++) {
            companiesYearlyIncome[i] = scanner.nextInt();
        }
        return companiesYearlyIncome;
    }

    private static int[] getTaxPercentagesFromInput(Scanner scanner, int numberOfCompanies) {
        int[] companiesTaxPercentage = new int[numberOfCompanies];
        for (int i = 0; i < numberOfCompanies; i++) {
            companiesTaxPercentage[i] = scanner.nextInt();
        }
        return companiesTaxPercentage;
    }

    private static double[] calculateTaxPaidInfo(int[] companiesYearlyIncome, int[] companiesTaxPercentage) {
        double[] companiesTaxPaid = new double[companiesYearlyIncome.length];
        for (int i = 0; i < companiesYearlyIncome.length; i++) {
            int income = companiesYearlyIncome[i];
            double percentage = companiesTaxPercentage[i] / 100d;
            companiesTaxPaid[i] = income * percentage;
        }
        return companiesTaxPaid;
    }

    private static int getCompanyNumberThatPaidTheMostTax(double[] companiesTaxPaid, int[] companyNumbers) {
        int companyNumber = 0;
        double maxPaid = 0;
        for (int i = companiesTaxPaid.length - 1; i >= 0; i--) {
            if (companiesTaxPaid[i] >= maxPaid) {
                maxPaid = companiesTaxPaid[i];
                companyNumber = companyNumbers[i];
            }
        }

        return companyNumber;
    }
}