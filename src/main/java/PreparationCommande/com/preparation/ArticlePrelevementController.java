package PreparationCommande.com.preparation;



import PreparationCommande.com.dao.DataException;
import PreparationCommande.com.model.Article;
import PreparationCommande.com.model.Employee;
import PreparationCommande.com.repository.ArticleRepository;
import PreparationCommande.com.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping(path="/article")
public class ArticlePrelevementController {


    @Autowired
    ArticleRepository articleRepository;


    @ExceptionHandler(DataException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String dataExceptionHandler(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter w = new PrintWriter(out);
        ex.printStackTrace(w);
        w.close();
        return "ERROR" + "<!--\n" + out.toString() + "\n-->";
    }


    @GetMapping(path="/lane.html", produces = "text/html")
    public String getArticle(Model model, @RequestParam (name ="motCle") String mc) throws DataException {
        // get list article for allée

            List<Article> listarticle = (List<Article>)  this.articleRepository.chercherAllee(mc);
            System.out.println("heloooo!!");
            model.addAttribute("listarticle", listarticle);
            model.addAttribute("motCle",mc);
            return "_articles_prelevement";

}


    @GetMapping(path = "/getAll.html", produces = "text/html")
    public String getArticlesLane(Model model) throws DataException {
        try {
            List<Article> listarticle = (List<Article>) this.articleRepository.findAll();
            model.addAttribute("listarticle", listarticle);
            return "_articles_prelevement";
        }catch (Exception e){
            throw new DataException("Pas allée");
        }
    }


}
