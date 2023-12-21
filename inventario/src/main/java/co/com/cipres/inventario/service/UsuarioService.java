package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.UsuarioDTO;
import co.com.cipres.inventario.entity.Usuario;
import co.com.cipres.inventario.repository.UsuarioRepository;
import co.com.cipres.inventario.vo.UsuarioQueryVO;
import co.com.cipres.inventario.vo.UsuarioUpdateVO;
import co.com.cipres.inventario.vo.UsuarioVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Long save(UsuarioVO vO) {
        Usuario bean = new Usuario();
        BeanUtils.copyProperties(vO, bean);
        bean = usuarioRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void update(Long id, UsuarioUpdateVO vO) {
        Usuario bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        usuarioRepository.save(bean);
    }

    public UsuarioDTO getById(Long id) {
        Usuario original = requireOne(id);
        return toDTO(original);
    }

    public Page<UsuarioDTO> query(UsuarioQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private UsuarioDTO toDTO(Usuario original) {
        UsuarioDTO bean = new UsuarioDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Usuario requireOne(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
