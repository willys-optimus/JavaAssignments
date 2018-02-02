import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addToCart
 */
@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      processRequest(request, response);
    }
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		cart shoppingCart;
		shoppingCart = (cart) session.getAttribute("cart");
		if(shoppingCart == null){
			shoppingCart = new cart();
			session.setAttribute("cart", shoppingCart);
		}
		String name = request.getParameter("name");
		Integer price = Integer.parseInt(request.getParameter("price"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		
		shoppingCart.addToCart(name, price, quantity);
		session.setAttribute("cart", shoppingCart);
		
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>result</title>");            
			out.println("</head>");
			out.println("<link rel=\"stylesheet\" href=\"Resources/masterStyleSheet.css\" />");
			out.println("<body>");
			out.println("<h1> " + name +" successfully added to cart </h1>");
			out.println("<form action='index.jsp'>Add more items<input type='submit' value='go'></form>");
			out.println("<hr>");
			out.println("<h2>Cart</h2>");
			out.println("<h3>Total is: " + shoppingCart.total() + "</h3>");
			Map<String, List<Integer>> items = shoppingCart.getCartItems();
			out.println("<table border='1px'>");
			for(String key: items.keySet()){
				out.println("<form action='deleteFromCart'><input type='hidden' name='name' value='"+key+"'>"
								+ "<tr><td>"+key+" - </td>"
								+ "<td>$"+items.get(key).get(0) +"</td>"
								+ "<td>Qty: " + items.get(key).get(1) + "</td>"
								+"<td><input type='submit' value='delete'></td>"
							+ "</tr></form>");
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");			
		}
	}			
}
//cartItems.get(key).get(0)
