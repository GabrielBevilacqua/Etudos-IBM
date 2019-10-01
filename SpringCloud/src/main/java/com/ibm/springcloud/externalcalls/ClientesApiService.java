package com.ibm.springcloud.externalcalls;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.ibm.springcloud.client.ClienteServiceClient;
import com.ibm.springcloud.model.Cliente;

@Service
public class ClientesApiService {

	private final static Logger LOG = LoggerFactory.getLogger(ClientesApiService.class);
	
	private ClienteServiceClient clienteServiceClient;

	@Autowired
	public ClientesApiService(ClienteServiceClient clienteServiceClient) {
		this.clienteServiceClient = clienteServiceClient;
	}

	@Async
	public CompletableFuture<String> getEndereco(Long id) {
		LOG.info("Trying to buscarEnderecoCliente " + Thread.currentThread().getName());
		CompletableFuture<String> endereco = CompletableFuture.completedFuture(clienteServiceClient.buscarEnderecoCliente(id));
		LOG.info("Retorno buscarEnderecoCliente: " + endereco);
		return endereco;
	}
	
	@Async
	public CompletableFuture<String> getNome(Long id) throws InterruptedException {
		LOG.info("Trying to buscarNomeCliente " + Thread.currentThread().getName());
//		Thread.sleep(3000);
		CompletableFuture<String> nome = CompletableFuture.completedFuture(clienteServiceClient.buscarNomeCliente(id));
		LOG.info("Retorno buscarNomeCliente: " + nome);
		return nome;
	}
	
	@Async
	public CompletableFuture<List<Cliente>> getClientes() {
		return CompletableFuture.completedFuture(clienteServiceClient.buscarClientes());
	}
	

}