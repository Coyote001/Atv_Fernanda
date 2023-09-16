import java.util.Scanner;

class Funcionario {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public String getNome() {
        return nome;
    }
}

class Gerente extends Funcionario {
    private String departamento;

    public Gerente(String nome, double salario, String departamento) {
        super(nome, salario);
        this.departamento = departamento;
    }

    public double calcularBonus() {
        return getSalario() * 0.10;
    }

    public String getDepartamento() {
        return departamento;
    }
}

class Diretor extends Funcionario {
    private int acoes;

    public Diretor(String nome, double salario, int acoes) {
        super(nome, salario);
        this.acoes = acoes;
    }

    public int getAcoes() {
        return acoes;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o salário do funcionário: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.print("Digite o departamento do gerente (ou vazio para diretor): ");
        String departamento = scanner.nextLine();

        if (departamento.isEmpty()) {
            System.out.print("Digite a quantidade de ações do diretor: ");
            int acoes = scanner.nextInt();
            Diretor diretor = new Diretor(nome, salario, acoes);
            System.out.println("Diretor: " + diretor.getNome() + ", Salário: " + diretor.getSalario() + ", Ações: " + diretor.getAcoes());
        } else {
            Gerente gerente = new Gerente(nome, salario, departamento);
            System.out.println("Gerente: " + gerente.getNome() + ", Salário: " + gerente.getSalario() + ", Departamento: " + gerente.getDepartamento());
            System.out.println("Bônus do Gerente: " + gerente.calcularBonus());
        }

        scanner.close();
    }
}