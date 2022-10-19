package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.UsuariodetalleDTO;
import co.com.cipres.inventario.entity.Usuariodetalle;
import co.com.cipres.inventario.repository.UsuariodetalleRepository;
import co.com.cipres.inventario.vo.UsuariodetalleQueryVO;
import co.com.cipres.inventario.vo.UsuariodetalleUpdateVO;
import co.com.cipres.inventario.vo.UsuariodetalleVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuariodetalleService {

    @Autowired
    private UsuariodetalleRepository usuariodetalleRepository;

    public Long save(UsuariodetalleVO vO) {
        Usuariodetalle bean = new Usuariodetalle();
        BeanUtils.copyProperties(vO, bean);
        bean = usuariodetalleRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        usuariodetalleRepository.deleteById(id);
    }

    public void update(Long id, UsuariodetalleUpdateVO vO) {
        Usuariodetalle bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        usuariodetalleRepository.save(bean);
    }

    public UsuariodetalleDTO getById(Long id) {
        Usuariodetalle original = requireOne(id);
        return toDTO(original);
    }

    public Page<UsuariodetalleDTO> query(UsuariodetalleQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UsuariodetalleDTO toDTO(Usuariodetalle original) {
        UsuariodetalleDTO bean = new UsuariodetalleDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Usuariodetalle requireOne(Long id) {
        return usuariodetalleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
