package com.exemplo.algamoney.api.repository.lancamento;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.exemplo.algamoney.api.model.Lancamento;
import com.exemplo.algamoney.api.repository.filter.LancamentoFilter;



public interface LancamentoRepositoryQuery {

	public Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);


}
