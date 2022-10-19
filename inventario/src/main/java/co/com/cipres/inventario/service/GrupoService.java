package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.GrupoDTO;
import co.com.cipres.inventario.entity.Grupo;
import co.com.cipres.inventario.repository.GrupoRepository;
import co.com.cipres.inventario.vo.GrupoQueryVO;
import co.com.cipres.inventario.vo.GrupoUpdateVO;
import co.com.cipres.inventario.vo.GrupoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GrupoService {

    @Autowired
    private GrupoRepository grupoRepository;

    public Long save(GrupoVO vO) {
        Grupo bean = new Grupo();
        BeanUtils.copyProperties(vO, bean);
        bean = grupoRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        grupoRepository.deleteById(id);
    }

    public void update(Long id, GrupoUpdateVO vO) {
        Grupo bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        grupoRepository.save(bean);
    }

    public GrupoDTO getById(Long id) {
        Grupo original = requireOne(id);
        return toDTO(original);
    }

    public Page<GrupoDTO> query(GrupoQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private GrupoDTO toDTO(Grupo original) {
        GrupoDTO bean = new GrupoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Grupo requireOne(Long id) {
        return grupoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
