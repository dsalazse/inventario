package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.CompaniadetalleDTO;
import co.com.cipres.inventario.entity.Companiadetalle;
import co.com.cipres.inventario.repository.CompaniadetalleRepository;
import co.com.cipres.inventario.vo.CompaniadetalleQueryVO;
import co.com.cipres.inventario.vo.CompaniadetalleUpdateVO;
import co.com.cipres.inventario.vo.CompaniadetalleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CompaniadetalleService {
    private CompaniadetalleRepository companiadetalleRepository;
    @Autowired
    public CompaniadetalleService(CompaniadetalleRepository companiadetalleRepository) {
        this.companiadetalleRepository = companiadetalleRepository;
    }

    public Long save(CompaniadetalleVO vO) {
        Companiadetalle bean = new Companiadetalle();
        BeanUtils.copyProperties(vO, bean);
        bean = companiadetalleRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        companiadetalleRepository.deleteById(id);
    }

    public void update(Long id, CompaniadetalleUpdateVO vO) {
        Companiadetalle bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        companiadetalleRepository.save(bean);
    }

    public CompaniadetalleDTO getById(Long id) {
        Companiadetalle original = requireOne(id);
        return toDTO(original);
    }

    public Page<CompaniadetalleDTO> query(CompaniadetalleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private CompaniadetalleDTO toDTO(Companiadetalle original) {
        CompaniadetalleDTO bean = new CompaniadetalleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Companiadetalle requireOne(Long id) {
        return companiadetalleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
