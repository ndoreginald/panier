package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConnexionAction
 */
@WebServlet("/ConnexionAction")
public class ConnexionAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		doGet(request, response);
		PrintWriter out = response.getWriter();
		//R�cup�rer la valeur du param�tre login"
		String l = request.getParameter("login");
		
		//Afficher la valeur du param�tre
		out.println("La valeur du nom est:"+l);
		
		//R�cup�rer la valeur du param�tre password"
		String pwd = request.getParameter("password");
		
		//Afficher la valeur du param�tre
		out.println("La valeur du mot de passe est:"+pwd);
		
		// Cr�ation d'un tableau vide d"erreurs
		ArrayList<String> erreurs =new ArrayList<String>();
		
		// validation
		String message ="";
		if (l!=null && l.equals(""))
		{
			erreurs.add("Champs login vide. Merci de sp�cifier une valeur..");
		}
		if (pwd!=null && pwd.equals(""))
		{
			erreurs.add("Champs password vide. Merci de sp�cifier une valeur..");
		}
		//Placer le message d'err comme un attribut nomm� "msg" dans l'objet "request"

		//request.setAttribute("msg", message);
		if (erreurs.isEmpty())
		{
			HttpSession session =request.getSession(true);

			//Placer le login comme un attribut nomm� "login" dans l'objet "session"

			session.setAttribute("login", l);

			//Placer le password comme un attribut nomm� "password" dans l'objet "session"

			session.setAttribute("password", pwd);
			// Aller � la page d'accueil
			request.getRequestDispatcher("ListeProduits.jsp").forward(request, response);
		}
			else
		{
		//Placer le login comme un attribut nomm� "login" dans l'objet "request"
		request.setAttribute("login", l);

		//Placer le password comme un attribut nomm� "password" dans l'objet "request"
		request.setAttribute("password", pwd);
		
		//Placer le tableau des erreurs comme attribut "tab_err" dans l'objet "request"
		request.setAttribute("tab_err", erreurs);
		
		//Se rediriger vers la page "connexion.jsp"
		request.getRequestDispatcher("Connexion.jsp").forward(request,response);
		}
	}

}
