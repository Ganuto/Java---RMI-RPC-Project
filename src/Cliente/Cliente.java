package Cliente;

import BinderCalc.CalculadoraInterface;
import BinderCalc.RequisicaoCalc;
import BinderServidorNomes.RequisicaoConexaoServidorNomes;
import BinderCalc.RespostaCalc;
import BinderDicionario.DicionarioInterface;
import BinderDicionario.RequisicaoDicionario;
import BinderDicionario.RespostaDicionario;
import BinderIMC.IMCInterface;
import BinderIMC.RequisicaoIMC;
import BinderIMC.RespostaIMC;
import BinderMedia.MediaInterface;
import BinderMedia.RequisicaoMedia;
import BinderMedia.RespostaMedia;
import BinderServidorNomes.RequisicaoServidorNomes;
import BinderServidorNomes.RespostaServidorNomes;
import BinderServidorNomes.ServidorNomesInterface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        //Instancia do Servidor de nomes
        try {
            ServidorNomesInterface servidorNomes = (ServidorNomesInterface) Naming.lookup("rmi://localhost:6659/servidorNomes");
            RequisicaoServidorNomes requisicaoServidorNomes = new RequisicaoServidorNomes();
            RespostaServidorNomes respostaServidorNomes = new RespostaServidorNomes();
            Scanner in = new Scanner(System.in);
            //Verifica qual servico
            System.out.println("************BEM-VINDO AO SERVIDOR DE NOMES**********");
            System.out.println("Por favor, digite o serviço de acordo com as teclas correspondentes: ");
            System.out.println("1 - Para Calculadora.");
            System.out.println("2 - Para Media.");
            System.out.println("3 - Para IMC.");
            System.out.println("4 - Para Dicionario.");
            int servico = in.nextInt();
            requisicaoServidorNomes.setServico(servico);
            respostaServidorNomes = servidorNomes.repostaServidorServico(requisicaoServidorNomes);
            //DEBUG
            ArrayList<RequisicaoConexaoServidorNomes> lista = new ArrayList();
            lista = servidorNomes.getLista();
            for (RequisicaoConexaoServidorNomes arg : lista) {
                System.out.println("Endereco de IP: '" + arg.getEnderecoIP() + "'");
                System.out.println("Servico: '" + arg.getServico() + "'");
            }
            System.out.println("Teste: " + respostaServidorNomes.getStatus());
            //DEBUG

            boolean erro = false;
            switch (servico) {
                case 1:
                    //Calculadora
                    if (respostaServidorNomes.getStatus() == 0) {
                        System.out.println("servico: " + respostaServidorNomes.getStatus());
                        CalculadoraInterface calculadora = (CalculadoraInterface) Naming.lookup(respostaServidorNomes.getServidor());
                        RequisicaoCalc requisicaoCalc = new RequisicaoCalc();
                        System.out.println("Calculadora Distribuida");
                        System.out.println("Selecione a Operação");
                        System.out.println("(1)SOMA");
                        System.out.println("(2)SUBTRAÇÃO");
                        System.out.println("(3)DIVISÃO");
                        System.out.println("(4)MULTIPLICAÇÃO");
                        in.reset();
                        int operacao = in.nextInt();
                        System.out.println("Digite o operador 1");
                        requisicaoCalc.setOp1(in.nextInt());
                        System.out.println("Digite o operador 2");
                        requisicaoCalc.setOp2(in.nextInt());
                        RespostaCalc respostaCalc = new RespostaCalc();
                        switch (operacao) {
                            case 1:
                                respostaCalc = calculadora.soma(requisicaoCalc);
                                break;
                            case 2:
                                respostaCalc = calculadora.subtracao(requisicaoCalc);
                                break;
                            case 3:
                                respostaCalc = calculadora.divisao(requisicaoCalc);
                                break;
                            case 4:
                                respostaCalc = calculadora.multiplicacao(requisicaoCalc);
                                break;
                            default:
                                System.out.println("Operação não implementada");
                                erro = true;
                                System.out.println(erro);
                                break;
                        }
                        if (!erro) {
                            System.out.println("Resposta:" + respostaCalc.getResultado());
                        } else {
                            System.out.println(erro);
                            System.out.println("Não é possivel fazer divisão pro 0");
                        }
                    } else {
                        System.out.println("Servidor de servico requisitado nao esta online.");
                    }
                    break;
                case 2:
                    //MÉDIA
                    if (respostaServidorNomes.getStatus() == 0) {
                        MediaInterface media = (MediaInterface) Naming.lookup(respostaServidorNomes.getServidor());
                        System.out.println("Servidor em uso: " + respostaServidorNomes.getServidor());
                        RequisicaoMedia requisicaoMedia = new RequisicaoMedia();
                        RespostaMedia respostaMedia = new RespostaMedia();
                        System.out.println("CALCULO DE MEDIA ARITIMETICA");
                        System.out.println("Digite " + (requisicaoMedia.getTamanho() + 1) + "º valor: ");
                        in.reset();
                        requisicaoMedia.setValor(in.nextInt());
                        in.reset();
                        while (requisicaoMedia.getUltPos() != 0) {
                            System.out.println("DIGITE '0' PARA SAIR.");
                            System.out.println("Digite " + (requisicaoMedia.getTamanho() + 1) + "º valor: ");
                            requisicaoMedia.setValor(in.nextInt());
                            in.reset();
                        }
                        //Remove o zero
                        requisicaoMedia.removeUltPos();
                        respostaMedia = media.calculaMedia(requisicaoMedia);
                        System.out.println("Resultado: " + respostaMedia.getResultado());
                    } else {
                        System.out.println("Servidor de servico requisitado nao esta online.");
                    }
                    break;
                case 3:
                    //IMC
                    if (respostaServidorNomes.getStatus() == 0) {
                        IMCInterface imc = (IMCInterface) Naming.lookup(respostaServidorNomes.getServidor());
                        RequisicaoIMC requisicaoIMC = new RequisicaoIMC();
                        RespostaIMC respostaIMC = new RespostaIMC();
                        System.out.println("CALCULO DE IMC");
                        System.out.println("Digite o seu sexo: ");
                        in.reset();
                        requisicaoIMC.setSexo(in.next(".").charAt(0));
                        System.out.println("Digite seu peso: ");
                        in.reset();
                        requisicaoIMC.setPeso(in.nextFloat());
                        System.out.println("Digite sua altura: ");
                        in.reset();
                        requisicaoIMC.setAltura(in.nextFloat());
                        respostaIMC = imc.calculaIMC(requisicaoIMC);
                        System.out.println("Seu IMC é equivalente a: " + respostaIMC.getResultado());
                        System.out.println("Seu diagnostico é : " + respostaIMC.getDiagnostico());
                    } else {
                        System.out.println("Servidor de servico requisitado nao esta online.");
                    }
                    break;
                case 4:
                    //Dicionario
                    if (respostaServidorNomes.getStatus() == 0) {
                        DicionarioInterface dicionario = (DicionarioInterface) Naming.lookup(respostaServidorNomes.getServidor());
                        RequisicaoDicionario requisicaoDicionario = new RequisicaoDicionario();
                        RespostaDicionario respostaDicionario = new RespostaDicionario();
                        System.out.println("TRADUTOR");
                        System.out.println("Digite a palavra a ser traduzida: ");
                        in.reset();
                        in.nextLine();
                        requisicaoDicionario.setTraduzir(in.nextLine());
                        respostaDicionario = dicionario.traduzir(requisicaoDicionario);
                        System.out.println("Tradução: " + respostaDicionario.getTraducao());
                    } else {
                        System.out.println("Servidor de servico requisitado nao esta online.");
                    }
                    break;
                default:
                    System.out.println("Operação não implementada");
                    erro = true;
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Servidor de nomes não encontrado.");
        }

    }
}
