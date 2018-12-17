package PreparationCommande.com.preparation;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import PreparationCommande.com.dao.DriveDao;
import PreparationCommande.com.model.Drive;
import PreparationCommande.com.model.Employee;
import PreparationCommande.com.repository.DriveRepository;
import PreparationCommande.com.repository.EmployeeRepository;
import PreparationCommande.com.dao.DataException;

@Controller
@RequestMapping(path="/drive")
public class DriveController {

	@Autowired
	DriveDao daoDrive;
	
	@Autowired
	DriveRepository repositoryDrive;
	
	@Autowired
	EmployeeRepository repositoryEmployee;
	
	@ExceptionHandler(DataException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String dataExceptionHandler(Exception ex) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PrintWriter w = new PrintWriter( out );
		ex.printStackTrace(w);
		w.close();
		return 
			"ERROR"
			+ "<!--\n" + out.toString() + "\n-->";
	}


	@GetMapping(path="/{id}.html", produces="text/html")
	public String getDrive(@PathVariable(name="id") long id, Model model) throws DataException {
		// get employee of Drive
		try {
			List<Employee> employes = this.daoDrive.getAllEmployes(id);
			// assign to model var "employes"
			model.addAttribute("employes", employes);
			// return view name to display content of /WEB-INF/views/_employes_list.jsp
			return "_employes_list";
		} catch (Exception e) {
			throw new DataException("No existing ID");
		}
		
	}
	
		/*// Map this method to "employee/USER_ID.html"
		@RequestMapping(path="/employee/{id}.html")
		public String employeeCommand( Model model,
				@PathVariable int id ) 
		throws DataException {
			return "employee";
		}*/
}
