package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.CompaniaDTO;
import co.com.cipres.inventario.entity.Compania;
import co.com.cipres.inventario.repository.CompaniaRepository;
import co.com.cipres.inventario.vo.CompaniaQueryVO;
import co.com.cipres.inventario.vo.CompaniaUpdateVO;
import co.com.cipres.inventario.vo.CompaniaVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CompaniaService {

    @Autowired
    private CompaniaRepository companiaRepository;

    public Long save(CompaniaVO vO) {
        Compania bean = new Compania();
        BeanUtils.copyProperties(vO, bean);
        bean = companiaRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        companiaRepository.deleteById(id);
    }

    public void update(Long id, CompaniaUpdateVO vO) {
        Compania bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        companiaRepository.save(bean);
    }

    public CompaniaDTO getById(Long id) {
        Compania original = requireOne(id);
        return toDTO(original);
    }

    public Page<CompaniaDTO> query(CompaniaQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CompaniaDTO toDTO(Compania original) {
        CompaniaDTO bean = new CompaniaDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Compania requireOne(Long id) {
        return companiaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
