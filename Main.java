import java.util.Scanner;

public class Main {

    static class PelmeniCalculator {
        public double calculatePelmeniProductivity(double qSut, double t) {
            return qSut / (2 * t);
        }

        public double calculateDoughProductivity(double rTl, double aT) {
            return rTl * (aT / 100);
        }

        public double calculateFillingProductivity(double rTl, double aF) {
            return rTl * (aF / 100);
        }

        public int calculateMachineCount(double rTl, double rMachine) {
            return (int) Math.ceil(rTl / rMachine);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Расчет технологической линии изготовления пельменей ===\n");

        System.out.print("Введите суточную выработку готовой продукции (т): ");
        double qSut = scanner.nextDouble();

        System.out.print("Введите продолжительность рабочей смены (ч): ");
        double t = scanner.nextDouble();

        System.out.print("Введите массовую долю теста в готовой продукции (%): ");
        double aT = scanner.nextDouble();

        System.out.print("Введите массовую долю фарша в готовой продукции (%): ");
        double aF = scanner.nextDouble();

        System.out.print("Введите производительность пельменного автомата (т/ч): ");
        double rPa = scanner.nextDouble();

        System.out.print("Введите производительность тестомесильной машины (т/ч): ");
        double rTm = scanner.nextDouble();

        System.out.print("Введите производительность куттера (т/ч): ");
        double rK = scanner.nextDouble();

        PelmeniCalculator calculator = new PelmeniCalculator();

        double rTl = calculator.calculatePelmeniProductivity(qSut, t);
        int nPa = calculator.calculateMachineCount(rTl, rPa);

        double rTlTest = calculator.calculateDoughProductivity(rTl, aT);
        int nTm = calculator.calculateMachineCount(rTlTest, rTm);

        double rTlFarsh = calculator.calculateFillingProductivity(rTl, aF);
        int nK = calculator.calculateMachineCount(rTlFarsh, rK);

        System.out.println("\n=== РЕЗУЛЬТАТЫ РАСЧЕТОВ ===");
        System.out.println("--------------------------------------------");
        System.out.printf("Производительность технологической линии: %.4f т/ч\n", rTl);
        System.out.println("--------------------------------------------");
        System.out.printf("Количество пельменных автоматов: %d шт.\n", nPa);
        System.out.printf("Количество тестомесильных машин: %d шт.\n", nTm);
        System.out.printf("Количество куттеров: %d шт.\n", nK);
        System.out.println("--------------------------------------------");

        scanner.close();
    }
}