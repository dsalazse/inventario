package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.TransaccionDTO;
import co.com.cipres.inventario.entity.Transaccion;
import co.com.cipres.inventario.repository.TransaccionRepository;
import co.com.cipres.inventario.vo.TransaccionQueryVO;
import co.com.cipres.inventario.vo.TransaccionUpdateVO;
import co.com.cipres.inventario.vo.TransaccionVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TransaccionService {

    private TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public Long save(TransaccionVO vO) {
        Transaccion bean = new Transaccion();
        BeanUtils.copyProperties(vO, bean);
        bean = transaccionRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        transaccionRepository.deleteById(id);
    }

    public void update(Long id, TransaccionUpdateVO vO) {
        Transaccion bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        transaccionRepository.save(bean);
    }

    public TransaccionDTO getById(Long id) {
        Transaccion original = requireOne(id);
        return toDTO(original);
    }

    public Page<TransaccionDTO> query(TransaccionQueryVO vO) {
        throw new UnsupportedOperationException();
    }

    private TransaccionDTO toDTO(Transaccion original) {
        TransaccionDTO bean = new TransaccionDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Transaccion requireOne(Long id) {
        return transaccionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
