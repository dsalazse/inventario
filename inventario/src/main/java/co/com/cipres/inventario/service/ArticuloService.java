package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.ArticuloDTO;
import co.com.cipres.inventario.entity.Articulo;
import co.com.cipres.inventario.repository.ArticuloRepository;
import co.com.cipres.inventario.vo.ArticuloQueryVO;
import co.com.cipres.inventario.vo.ArticuloUpdateVO;
import co.com.cipres.inventario.vo.ArticuloVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    public Long save(ArticuloVO vO) {
        Articulo bean = new Articulo();
        BeanUtils.copyProperties(vO, bean);
        bean = articuloRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        articuloRepository.deleteById(id);
    }

    public void update(Long id, ArticuloUpdateVO vO) {
        Articulo bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        articuloRepository.save(bean);
    }

    public ArticuloDTO getById(Long id) {
        Articulo original = requireOne(id);
        return toDTO(original);
    }

    public Page<ArticuloDTO> query(ArticuloQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private ArticuloDTO toDTO(Articulo original) {
        ArticuloDTO bean = new ArticuloDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Articulo requireOne(Long id) {
        return articuloRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
