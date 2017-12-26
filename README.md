<h1>Java - Servidores de serviços RMI</h1>
<h2>Trabalho acadêmico de Sistemas Distribuídos</h2>
<b>Descrição do projeto:</b></br>
Sistema de serviços básicos com servidor de nomes, redundância e balanceamento (utilização do conceito de Round-Robin) de servidores feito em RMI Java.
<img src="https://github.com/Ganuto/Java-Servidores-ServicosRMI/blob/master/ServidorNomes.png?raw=true" alt="SevidorNomes.png">
<span style="color:grey"><i>Visão macro do funcionamento do projeto</i></span>
<p></p>
<b>Informações Adicionais:</b></br>
O projeto está com a roupagem de um projeto criados na IDE Netbeans.<br>
Por se tratar de um projeto que trabalha com conexões remotas via RMI, é necessário criar as classes STUBs caso queira executar pelo terminal/prompt.
<p></p>
Devido à redundância, caso um dos servidores que hospedam um serviço caia, outro servidor que possui o mesmo serviço assumirá.
<p></p>
Devido ao balanceamento, a cada nova requisição de serviço, é feita uma troca de servidores (através da utilização do conceito de Round-Robin)
para evitar, de maneira simples, a sobrecarga nos servidores provedores do serviço requisitado.
<p></p>
<h3>Classes executáveis:</h3>
<dl>
  <dt>Iniciar servidor de nomes:</dt>
  <dd>nomesServidor.java</dd>
  <dt>Iniciar servidores de serviços:</dt>
  <dd>CalculadoraServidor.java</dd>
  <dd>DicionarioServidor.java</dd>
  <dd>IMCServidor.java</dd>
  <dd>MediaServidor.java</dd>
  <dd>NomesServidor.java</dd>                                
  <dt>Iniciar cliente p/ req. dos serviços:</dt>
  <dd>Cliente.java</dd>
</dl>
<h3>Autores:</h3>
<li> 
  Ganut0 -
  <a href="mailto:ganuto@hotmail.com">ganuto@hotmail.com</a>
</li>

