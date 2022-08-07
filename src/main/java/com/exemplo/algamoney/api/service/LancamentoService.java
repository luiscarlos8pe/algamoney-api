package com.exemplo.algamoney.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exemplo.algamoney.api.model.Lancamento;
import com.exemplo.algamoney.api.model.Pessoa;
import com.exemplo.algamoney.api.repository.LancamentoRepository;
import com.exemplo.algamoney.api.repository.PessoaRepository;
import com.exemplo.algamoney.api.service.exception.PessoaInexistenteOuInativaException;

@Service
public class LancamentoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired 
	private LancamentoRepository lancamentoRepository;

	
		
	
		public Lancamento salvar(Lancamento lancamento) {
			Optional<Pessoa> pessoa = pessoaRepository.findById(lancamento.getPessoa().getCodigo());
			if (pessoa == null || pessoa.isPresent()) {
				throw new PessoaInexistenteOuInativaException();
			}
			
			return lancamentoRepository.save(lancamento);
		}
}
