package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.ArticulodetalleDTO;
import co.com.cipres.inventario.entity.Articulodetalle;
import co.com.cipres.inventario.repository.ArticulodetalleRepository;
import co.com.cipres.inventario.vo.ArticulodetalleQueryVO;
import co.com.cipres.inventario.vo.ArticulodetalleUpdateVO;
import co.com.cipres.inventario.vo.ArticulodetalleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ArticulodetalleService {

    @Autowired
    private ArticulodetalleRepository articulodetalleRepository;

    public Long save(ArticulodetalleVO vO) {
        Articulodetalle bean = new Articulodetalle();
        BeanUtils.copyProperties(vO, bean);
        bean = articulodetalleRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        articulodetalleRepository.deleteById(id);
    }

    public void update(Long id, ArticulodetalleUpdateVO vO) {
        Articulodetalle bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        articulodetalleRepository.save(bean);
    }

    public ArticulodetalleDTO getById(Long id) {
        Articulodetalle original = requireOne(id);
        return toDTO(original);
    }

    public Page<ArticulodetalleDTO> query(ArticulodetalleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ArticulodetalleDTO toDTO(Articulodetalle original) {
        ArticulodetalleDTO bean = new ArticulodetalleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Articulodetalle requireOne(Long id) {
        return articulodetalleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
