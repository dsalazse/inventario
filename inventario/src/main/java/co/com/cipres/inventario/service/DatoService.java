package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.DatoDTO;
import co.com.cipres.inventario.entity.Dato;
import co.com.cipres.inventario.repository.DatoRepository;
import co.com.cipres.inventario.vo.DatoUpdateVO;
import co.com.cipres.inventario.vo.DatoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DatoService {

    @Autowired
    private DatoRepository datoRepository;

    public Long save(DatoVO vO) {
        Dato bean = new Dato();
        BeanUtils.copyProperties(vO, bean);
        bean = datoRepository.save(bean);
        return bean.getId();
    }

    public void delete(Long id) {
        datoRepository.deleteById(id);
    }

    public void update(Long id, DatoUpdateVO vO) {
        Dato bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        datoRepository.save(bean);
    }

    public DatoDTO getById(Long id) {
        Dato original = requireOne(id);
        return toDTO(original);
    }

    public List<DatoDTO> query() {
        List<Dato> original =requireAll();
        return toDTOs(original);
    }

    private DatoDTO toDTO(Dato original) {
        DatoDTO bean = new DatoDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Dato requireOne(Long id) {
        return datoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private List<Dato> requireAll(){
        return datoRepository.findAll();
    }

    private List<DatoDTO> toDTOs(List<Dato> original) {
        List<DatoDTO> bean = new ArrayList<DatoDTO>() ;
        DatoDTO beanAux = new DatoDTO();
        System.out.println("*** valor de original: " + original.toString());
        /*
        for (int i = 0; i < original.size(); i++) {
            BeanUtils.copyProperties(original.get(i),beanAux);
            bean.add(beanAux);
        }
         */
        for (Dato source: original) {
            DatoDTO target= new DatoDTO();
            BeanUtils.copyProperties(source , target);
            bean.add(target);
        }


        System.out.println("valor de bean: " + bean.toString());
        System.out.println("valor de original: " + original.toString());
        return bean;
    }
}
