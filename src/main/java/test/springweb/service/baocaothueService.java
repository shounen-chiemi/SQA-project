package test.springweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import test.springweb.dto.baocaothueDTO;
import test.springweb.entity2.baocaothue;
import test.springweb.entity2.khoangiamtru;
import test.springweb.entity2.repository.baocaothueRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class baocaothueService {
   @Autowired
   baocaothueRepository bctR;
   @Autowired
   khoangiamtruService kgS;

    public Page<baocaothue> getDs(Pageable pageable)
    {
        Page<baocaothue> page = bctR.getDsBaocaothue(pageable);
        return page;
    }

    public List<baocaothueDTO> getdsbaocaothue(Pageable pageable)
    {
        Page<baocaothue> ds = bctR.getDsBaocaothue(pageable);

        List<baocaothueDTO> dsbc = new ArrayList<>();
        for(baocaothue i : ds)
        {
            baocaothueDTO baocaothueDTO = new baocaothueDTO();
            baocaothueDTO.setChitietthuesuat(i.getChitietthuesuat());
            baocaothueDTO.setLoaithue(i.getLoaithue());
            baocaothueDTO.setId(i.getId());
            baocaothueDTO.setNgaynop(i.getNgaynop());
            baocaothueDTO.setSonguoiphuthuoc(i.getSonguoiphuthuoc());
            baocaothueDTO.setTnct(i.getTnct());
            baocaothueDTO.setTinhtrang(i.getTinhtrang());
            baocaothueDTO.setNguoidongthue(i.getNguoidongthue());
            baocaothueDTO.setList_khoangiamtru(i.getList_khoangiamtru());
            float thue = i.getTnct();
            i.setList_khoangiamtru(kgS.getDskhoanggiamtru(i.getId()));
            for(khoangiamtru j : i.getList_khoangiamtru())
            {
                float mucgiamtru = j.getMucgiamtru();
                if(j.getTenmucgiamtru().equals("giảm trừ với mỗi người phụ thuộc"))
                {
                    mucgiamtru = (float)i.getSonguoiphuthuoc()*mucgiamtru;
                }
                thue = (float)(thue - mucgiamtru);
            }
            thue = (float)(thue*(i.getChitietthuesuat().getThuesuat()/100));
            if(thue<0) thue=0;
            baocaothueDTO.setTongtien((int) thue);
            dsbc.add(baocaothueDTO);
        }
        return dsbc;
    }


}
