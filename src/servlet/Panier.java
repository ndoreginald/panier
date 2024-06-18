package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Panier
 */
@WebServlet({ "/Panier", "/do" })
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Panier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//Récupérer la valeur du paramètre login"
		String p = request.getParameter("produit");
		String message;
		
		if( p == null) {
			message="vous devez cocher une case";
			request.setAttribute("message", message);
			this.getServletContext().getRequestDispatcher("/ListeProduits.jsp").forward(request, response);
		}
		else {
			HttpSession session =request.getSession(true);
			message="vous avez ajouté un produit au panier";
			session.setAttribute("message", message);
			session.setAttribute("produit", p);
			
			// Récupérer ou initialiser le panier dans la session
	        ArrayList<String> panier = (ArrayList<String>) session.getAttribute("panier");
	        if (panier == null) 
	        {
	            panier = new ArrayList<>();
	            session.setAttribute("panier", panier);
	        }
	        // Ajouter le produit au panier
	        	panier.add(p);
			this.getServletContext().getRequestDispatcher("/Afficher.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
