package test.springweb.controller.baocaothueController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import test.springweb.dto.baocaothueDTO;
import test.springweb.entity2.baocaothue;
import test.springweb.entity2.khoangiamtru;
import test.springweb.entity2.repository.baocaothueRepository;
import test.springweb.service.baocaothueService;
import test.springweb.service.khoangiamtruService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class baocaothueController {
    @Autowired
    private baocaothueService bctS;
    @Autowired
    private khoangiamtruService kgS;

    @RequestMapping("/list-taxpayer")
    public String listTaxPayer(Model model, HttpServletRequest request, RedirectAttributes redirect){
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        request.getSession().setAttribute("dsbaocaothue",null);
        request.getSession().setAttribute("tranghientai",1);
        return "redirect:/list-taxpayer/page/1";
    }

    @RequestMapping("list-taxpayer/page/{pagenumber}")
    public String showPage(HttpServletRequest request, @PathVariable int pagenumber, Model model,RedirectAttributes redirect)
    {
        String name = (String) request.getSession().getAttribute("thanhvien");
        model.addAttribute("thvien", name);
        request.getSession().setAttribute("tranghientai",1);
        if(pagenumber<1)
            pagenumber = 1;
        int tranghientai = (Integer)request.getSession().getAttribute("tranghientai");
        tranghientai = pagenumber-1;
        Pageable pageable = PageRequest.of(tranghientai,5);
        List<baocaothueDTO> dsbc = bctS.getdsbaocaothue(pageable);
        request.getSession().setAttribute("tranghientai",(int)tranghientai+1);
        model.addAttribute("danhsachThue",dsbc);
        model.addAttribute("tranghientai",(int)tranghientai+1);

        return "admin/list-taxpayer";
    }

    @GetMapping("/zzz")
    public String t()
    {
        return "admin/list-taxpayer";
    }

}
