package co.com.cipres.inventario.service;

import co.com.cipres.inventario.dto.ArticulocontrolDTO;
import co.com.cipres.inventario.entity.Articulocontrol;
import co.com.cipres.inventario.repository.ArticulocontrolRepository;
import co.com.cipres.inventario.vo.ArticulocontrolQueryVO;
import co.com.cipres.inventario.vo.ArticulocontrolUpdateVO;
import co.com.cipres.inventario.vo.ArticulocontrolVO;
import com.mchange.v1.util.ListUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ArticulocontrolService {

    @Autowired
    private ArticulocontrolRepository articulocontrolRepository;

    public Long save(ArticulocontrolVO vO) {
        Articulocontrol bean = new Articulocontrol();
        BeanUtils.copyProperties(vO, bean);
        bean = articulocontrolRepository.save(bean);
        return bean.getCodigo();
    }

    public void delete(Long id) {
        articulocontrolRepository.deleteById(id);
    }

    public void update(Long id, ArticulocontrolUpdateVO vO) {
        Articulocontrol bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        articulocontrolRepository.save(bean);
    }

    public ArticulocontrolDTO getById(Long id) {
        Articulocontrol original = requireOne(id);
        return toDTO(original);
    }

    public List<ArticulocontrolDTO> query() {
        List<Articulocontrol> original = requireAll();
        return toDTO(original);
    }

    private ArticulocontrolDTO toDTO(Articulocontrol original) {
        ArticulocontrolDTO bean = new ArticulocontrolDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Articulocontrol requireOne(Long id) {
        return articulocontrolRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    private List<Articulocontrol> requireAll(){
        return articulocontrolRepository.findAll();
    }

    private List<ArticulocontrolDTO> toDTO(List<Articulocontrol> original){
        List<ArticulocontrolDTO> bean = new ArrayList<ArticulocontrolDTO>();

        for(Articulocontrol source : original){
            ArticulocontrolDTO target = new ArticulocontrolDTO();
            BeanUtils.copyProperties(source,target);
            bean.add(target);
        }
        return bean;

    }
}
