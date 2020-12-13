package ute.DoAn1.controller.web;


import java.util.List;
import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ute.DoAn1.DAO.impl.ProductDAO;
import ute.DoAn1.constant.SystemConstant;
import ute.DoAn1.model.ProductModel;
import ute.DoAn1.service.IProductService;

/**
 * Servlet implementation class PagingController
 */
@WebServlet("/PagingController")
public class PagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Inject
	private IProductService Iproduct;
    public PagingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*String index = request.getParameter("index");
		int indexPage = Integer.parseInt(index);
		if(index == null) {
			index = "1";
		}
		ProductModel product = new ProductModel();
		
		request.setAttribute("id", product_id);
		request.setAttribute("index", index);
		request.setAttribute("listResult", listProduct);
		request.getRequestDispatcher("/views/web/showproduct.jsp").forward(request, response);

		*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
