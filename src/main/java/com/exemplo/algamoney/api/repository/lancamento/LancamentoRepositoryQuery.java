package com.exemplo.algamoney.api.repository.lancamento;

import java.util.List;

import com.exemplo.algamoney.api.model.Lancamento;
import com.exemplo.algamoney.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	
	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
}
