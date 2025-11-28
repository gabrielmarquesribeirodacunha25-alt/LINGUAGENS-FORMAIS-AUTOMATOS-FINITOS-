// ChatbotSuporteTecnicoDFA.java
import java.util.Scanner;

public class ChatbotSuporteTecnicoDFA {
    enum State {
        SAUDACAO,
        ESCOLHER_CATEGORIA,
        INT_ESCOLHER_PROBLEMA,
        INT_VALIDACAO_PADRAO,
        INT_DESPEDIDA,
        IMP_ESCOLHER_PROBLEMA,
        IMP_VALIDACAO_PADRAO,
        IMP_DESPEDIDA,
        LOG_ESCOLHER_PROBLEMA,
        LOG_VALIDACAO_PADRAO,
        LOG_DESPEDIDA,
        NUMERO_SUPORTE,
        FINALIZAR
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        State state = State.SAUDACAO;
        String categoria = null;
        String problema = null;

        System.out.println("=== CHATBOT DE SUPORTE TÉCNICO ===");
        System.out.println("Bot: Olá! Bem-vindo ao suporte técnico.\n");

        while (true) {
            String input = sc.nextLine().trim().toLowerCase();

            switch (state) {
                case SAUDACAO:
                    state = State.ESCOLHER_CATEGORIA;
                    System.out.println("Bot: Escolha uma categoria:");
                    System.out.println("  1 - Internet");
                    System.out.println("  2 - Impressora");
                    System.out.println("  3 - Login no 365");
                    System.out.print("> ");
                    break;

                case ESCOLHER_CATEGORIA:
                    if (input.contains("internet") || input.equals("1")) {
                        categoria = "Internet";
                        state = State.INT_ESCOLHER_PROBLEMA;
                        System.out.println("\nBot: Você escolheu Internet.");
                        System.out.println("Bot: Qual é o problema com a Internet?");
                        System.out.println("  - Conexão lenta");
                        System.out.println("  - Sem conexão");
                        System.out.println("  - Conexão intermitente");
                        System.out.print("> ");
                    } else if (input.contains("impressora") || input.equals("2")) {
                        categoria = "Impressora";
                        state = State.IMP_ESCOLHER_PROBLEMA;
                        System.out.println("\nBot: Você escolheu Impressora.");
                        System.out.println("Bot: Qual é o problema com a impressora?");
                        System.out.println("  - Não está imprimindo");
                        System.out.println("  - Impressão com falhas");
                        System.out.println("  - Impressora offline");
                        System.out.print("> ");
                    } else if (input.contains("login") || input.contains("365") || input.equals("3")) {
                        categoria = "Login no 365";
                        state = State.LOG_ESCOLHER_PROBLEMA;
                        System.out.println("\nBot: Você escolheu Login no 365.");
                        System.out.println("Bot: Qual é o problema com o login?");
                        System.out.println("  - Esqueci minha senha");
                        System.out.println("  - Conta bloqueada");
                        System.out.println("  - Erro ao fazer login");
                        System.out.print("> ");
                    } else {
                        System.out.println("Bot: Opção inválida. Digite 1, 2 ou 3.");
                        System.out.print("> ");
                    }
                    break;

                // ========== FLUXO INTERNET ==========
                case INT_ESCOLHER_PROBLEMA:
                    problema = input;
                    state = State.INT_VALIDACAO_PADRAO;
                    System.out.println("\nBot: Entendi. Problema: " + problema);
                    System.out.println("Bot: Siga estas instruções:");
                    System.out.println("  1. Reinicie o roteador (desligue por 30 segundos)");
                    System.out.println("  2. Verifique se os cabos estão conectados corretamente");
                    System.out.println("  3. Teste a conexão em outro dispositivo");
                    System.out.println("\nBot: O problema foi resolvido? (sim/não)");
                    System.out.print("> ");
                    break;

                case INT_VALIDACAO_PADRAO:
                    if (input.contains("sim") || input.equals("s")) {
                        state = State.INT_DESPEDIDA;
                        System.out.println("\nBot: Ótimo! Fico feliz em ajudar.");
                        state = State.FINALIZAR;
                        System.out.println("Bot: Atendimento concluído. Obrigado por usar nosso suporte!");
                        System.out.println("Bot: Até mais!");
                        sc.close();
                        return;
                    } else if (input.contains("não") || input.contains("nao") || input.equals("n")) {
                        state = State.NUMERO_SUPORTE;
                        System.out.println("\nBot: Lamento que o problema persista.");
                        System.out.println("Bot: Entre em contato com nosso suporte especializado:");
                        System.out.println("Bot: Telefone: (62) 3241-5555");
                        System.out.println("Bot: E-mail: suporte@empresa.com.br");
                        System.out.println("\nBot: Obrigado pelo contato!");
                        sc.close();
                        return;
                    } else {
                        System.out.println("Bot: Por favor, responda com 'sim' ou 'não'.");
                        System.out.print("> ");
                    }
                    break;

                // ========== FLUXO IMPRESSORA ==========
                case IMP_ESCOLHER_PROBLEMA:
                    problema = input;
                    state = State.IMP_VALIDACAO_PADRAO;
                    System.out.println("\nBot: Entendi. Problema: " + problema);
                    System.out.println("Bot: Siga estas instruções:");
                    System.out.println("  1. Verifique se a impressora está ligada");
                    System.out.println("  2. Confirme se está conectada ao computador/rede");
                    System.out.println("  3. Verifique se há papel e tinta/toner");
                    System.out.println("  4. Tente remover e reinstalar a impressora");
                    System.out.println("\nBot: O problema foi resolvido? (sim/não)");
                    System.out.print("> ");
                    break;

                case IMP_VALIDACAO_PADRAO:
                    if (input.contains("sim") || input.equals("s")) {
                        state = State.FINALIZAR;
                        System.out.println("\nBot: Excelente! Sua impressora está funcionando novamente.");
                        System.out.println("Bot: Atendimento concluído. Obrigado!");
                        System.out.println("Bot: Até mais!");
                        sc.close();
                        return;
                    } else if (input.contains("não") || input.contains("nao") || input.equals("n")) {
                        state = State.NUMERO_SUPORTE;
                        System.out.println("\nBot: Vou encaminhar para um técnico especializado.");
                        System.out.println("Bot: Entre em contato com nosso suporte:");
                        System.out.println("Bot: Telefone: (62) 3241-5555");
                        System.out.println("Bot: E-mail: suporte@empresa.com.br");
                        System.out.println("\nBot: Obrigado pelo contato!");
                        sc.close();
                        return;
                    } else {
                        System.out.println("Bot: Por favor, responda com 'sim' ou 'não'.");
                        System.out.print("> ");
                    }
                    break;

                // ========== FLUXO LOGIN 365 ==========
                case LOG_ESCOLHER_PROBLEMA:
                    problema = input;
                    state = State.LOG_VALIDACAO_PADRAO;
                    System.out.println("\nBot: Entendi. Problema: " + problema);
                    System.out.println("Bot: Siga estas instruções:");
                    if (input.contains("senha")) {
                        System.out.println("  1. Acesse: https://login.microsoftonline.com");
                        System.out.println("  2. Clique em 'Esqueci minha senha'");
                        System.out.println("  3. Siga as instruções para redefinir");
                    } else if (input.contains("bloqueada")) {
                        System.out.println("  1. Aguarde 30 minutos e tente novamente");
                        System.out.println("  2. Verifique se não há erros de digitação");
                        System.out.println("  3. Se persistir, contate o administrador");
                    } else {
                        System.out.println("  1. Limpe o cache do navegador");
                        System.out.println("  2. Tente usar outro navegador");
                        System.out.println("  3. Verifique sua conexão com a internet");
                    }
                    System.out.println("\nBot: O problema foi resolvido? (sim/não)");
                    System.out.print("> ");
                    break;

                case LOG_VALIDACAO_PADRAO:
                    if (input.contains("sim") || input.equals("s")) {
                        state = State.FINALIZAR;
                        System.out.println("\nBot: Perfeito! Você conseguiu acessar sua conta.");
                        System.out.println("Bot: Atendimento concluído. Obrigado!");
                        System.out.println("Bot: Até mais!");
                        sc.close();
                        return;
                    } else if (input.contains("não") || input.contains("nao") || input.equals("n")) {
                        state = State.NUMERO_SUPORTE;
                        System.out.println("\nBot: Vou encaminhar para o suporte de TI.");
                        System.out.println("Bot: Entre em contato:");
                        System.out.println("Bot: Telefone: (62) 3241-5555");
                        System.out.println("Bot: E-mail: ti@empresa.com.br");
                        System.out.println("\nBot: Obrigado pelo contato!");
                        sc.close();
                        return;
                    } else {
                        System.out.println("Bot: Por favor, responda com 'sim' ou 'não'.");
                        System.out.print("> ");
                    }
                    break;

                default:
                    System.out.println("Bot: Erro de estado. Encerrando...");
                    sc.close();
                    return;
            }
        }
    }
}