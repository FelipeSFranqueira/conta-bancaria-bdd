import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

/**
 * Classe que implementa os métodos sugeridos pelo Cucumber
 * de uma conta bancária.
 *
 * @author Felipe Sanches Franqueira
 * @version 1.0
 * @since 1.0
 */
public class Conta {

    private int saldo; //Atributo que armazena o saldo da conta do cliente
    private boolean isEspecial; //Atributo booleano para deferenciar tipos diferentes de usuário

    private boolean saqueRealizado = false; //Atributo booleano para identificar se o saque foi realizado ou não

    /**
     * Método que defini o valor inicial da conta do cliente e
     * qual o tipo da conta do dele.
     *
     * @param saldo Valor inicial do saldo da conta.
     */
    @Given("Um cliente especial com saldo atual de {int} reais")
    public void um_cliente_especial_com_saldo_atual_de_reais(Integer saldo) {
        this.saldo = saldo;
        this.isEspecial=true;
    }

    /**
     * Método que realiza um saque atravéz do método realizarSaque.
     *
     * @param saque Valor a ser sacado.
     */
    @When("for solicitado um saque no valor de {int} reais")
    public void for_solicitado_um_saque_no_valor_de_reais(Integer saque) {
        this.realizarSaque(saque);
    }

    /**
     * Método que verifica o saldo da conta após um saque.
     *
     * @param novoSaldo Novo valor do saldo da conta.
     */
    @Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
    public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer novoSaldo) {
        assert this.saldo == novoSaldo;
    }

    /**
     * Método que mostra uma mensagem caso o cliente for Especial e
     * caso o saldo for negativo.
     */
    @Then("check more outcomes")
    public void check_more_outcomes() {
        if (this.isEspecial) {
            System.out.println("Cliente especial.");
        }

        if (this.saldo < 0) {
            System.out.println("Saldo negativo.");
        }
    }


    /**
     * Método que defini o valor inicial da conta do cliente e
     * qual o tipo da conta dele.
     *
     * @param saldo Valor inicial do saldo da conta.
     */
    @Given("Um cliente comum com saldo atual de {int} reais")
    public void um_cliente_comum_com_saldo_atual_de_reais(Integer saldo) {
        this.saldo = saldo;
        this.isEspecial = false;
    }

    /**
     * Método que realiza um saque atravéz do método realizarSaque.
     *
     * @param saque Valor a ser sacado.
     */
    @When("solicitar um saque de {int} reais")
    public void solicitar_um_saque_de_reais(Integer saque) {
        this.realizarSaque(saque);
    }

    /**
     * Método que garante que um saque não foi efetuado.
     */
    @Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
    public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
        assert this.saqueRealizado == false;
    }

    /**
     * Método que realiza um saque caso o cliente possa realizar essa ação,
     * caso o cliente não possa é mostrado uma mensagem.
     *
     * @param saque Valor a ser sacado.
     */
    private void realizarSaque(int saque) {
        if (saque > 0 && (this.isEspecial || this.saldo >= saque)) {
            this.saldo -= saque;
            this.saqueRealizado = true;
        } else {
            System.out.println("Saldo Insuficiente.");
        }
    }
}
